package com.portal.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.portal.domain.core.Blogger;
import com.portal.exception.ImageUploadException;
import com.portal.service.BloggerService;

@Controller
@RequestMapping("/bloggers")
public class ProfileController {

	@Inject
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

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showBloggerProfile(@PathVariable String login, Model model) {
		Blogger blogger = bloggerService.getBloggerByLogin(login);
		model.addAttribute(blogger);
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
