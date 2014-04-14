package com.portal.controller;

import com.portal.exception.ImageUploadException;
import com.portal.model.Blogger;
import com.portal.model.Post;
import com.portal.service.BloggerService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

//@Lazy
@Controller
@RequestMapping("/bloggers")
public class ProfileController {

	Logger logger = LoggerFactory.getLogger(ProfileController.class);
	@Autowired
	BloggerService bloggerService;

	@RequestMapping(method = RequestMethod.GET, value = "createNewBlogger")
	public String createNewBloggerProfile(Model model) {
		Blogger blogger = new Blogger();
		model.addAttribute("blogger", blogger);
		return "bloggers/newUserInputForm";
	}

	@RequestMapping(method = RequestMethod.POST, value = "createNewBlogger")
	public String addNewBloggerFromForm(@Valid Blogger blogger,
			BindingResult bindingResult,
			@RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest request) throws UnsupportedEncodingException {
		if (bindingResult.hasErrors()) {
			return "bloggers/newUserInputForm";
		}
		bloggerService.saveBlogger(blogger);
		try {
			if (!image.isEmpty()) {
				validateImage(image);
				saveImage("nana.jpg", image, request);
			}
		} catch (Exception e) {
			bindingResult.reject(e.getMessage());
			return "bloggers/newUserInputForm";
		}

		return "redirect:/bloggers/" + blogger.getLogin();
	}
	
	@RequestMapping(value="signin", method = RequestMethod.GET)
	public String signIn(Model model) {
		Blogger blogger = new Blogger();
		model.addAttribute(blogger);
		return "bloggers/signin";
	}
	
	@RequestMapping(value="signinPost", method = RequestMethod.POST)
	public String signInPost(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, Model model,
			HttpServletRequest request) {
		Blogger blogger = null;
		try {
			blogger = bloggerService.getBloggerByEmail(email);
		} catch (NoResultException e) {
			model.addAttribute("errorMessage", "Sorry, there is no such user registered");
			return "bloggers/signin";
		}
		//model.addAttribute(blogger);
		//org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		//log.debug("admin@i.ua password 11 = " + encoder.encode("11"));
		return "redirect:/bloggers/" + blogger.getLogin();
	}
	
	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showRecentPosts(@PathVariable String login, Model model) {
		Blogger blogger = null;
		try {
			blogger = bloggerService.getBloggerByLogin(login);
		} catch (NoResultException e) {
			model.addAttribute("errorMessage", "Sorry, there is no such user registered");
			return "errorPage";
		}
		model.addAttribute(blogger);
		model.addAttribute(new Post());
		model.addAttribute("postList", bloggerService.getPostsOfBlogger(blogger));
		return "bloggers/postList";
	}

	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted");
		}

	}

	private void saveImage(String fileName, MultipartFile image,
			HttpServletRequest request) {

		//TODO Save avatar to particular image store but no at dynamic application context
		File file = new File(request.getRealPath("/") + "/resources/store/"
				+ fileName);
		try {
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ImageUploadException("Unable to save image", e);
		}

	}

}
