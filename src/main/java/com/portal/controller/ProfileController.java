package com.portal.controller;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portal.domain.core.Blogger;
import com.portal.domain.core.Post;
import com.portal.service.BloggerService;

//@Lazy
@Controller
@RequestMapping("/bloggers")
public class ProfileController {

	Logger log = LoggerFactory.getLogger(ProfileController.class.getName());
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
			BindingResult bindingResult, HttpServletRequest request)
			throws UnsupportedEncodingException {
		if (bindingResult.hasErrors()) {
			return "bloggers/newUserInputForm";
		}

		try {
			ServletFileUpload upload = new ServletFileUpload();
			FileItemIterator iterator = upload.getItemIterator(request);
			while (iterator.hasNext()) {
				FileItemStream item = iterator.next();
				InputStream stream = item.openStream();

				if (item.isFormField()) {
					log.warn("Got a form field: " + item.getFieldName());
				} else {
					log.warn("Got an uploaded file: " + item.getFieldName()
							+ ", name = " + item.getName());

					byte[] bytes = IOUtils.toByteArray(stream);
					Blob blob = new org.datanucleus.store.rdbms.datatype.BlobImpl(
							bytes);
					blogger.setImage(blob);
				}
			}
		} catch (Exception ex) {
			return "bloggers/newUserInputForm";
		}

		bloggerService.saveBlogger(blogger);
		return "redirect:/bloggers/" + blogger.getLogin();
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showRecentPosts(@PathVariable String login, Model model) {
		Blogger blogger = bloggerService.getBloggerByLogin(login);
		model.addAttribute(blogger);
		model.addAttribute(new Post());
		model.addAttribute("postList",
				bloggerService.getPostsOfBlogger(blogger));
		return "bloggers/postList";
	}

	/*
	 * private void validateImage(MultipartFile image) { if
	 * (!image.getContentType().equals("image/jpeg")) { throw new
	 * ImageUploadException("Only JPG images accepted"); }
	 * 
	 * }
	 * 
	 * private void saveImage(String fileName, MultipartFile image,
	 * HttpServletRequest request) {
	 * 
	 * //TODO Save avatar to particular image store but no at dynamic
	 * application context File file = new File(request.getRealPath("/") +
	 * "/resources/store/" + fileName); try {
	 * FileUtils.writeByteArrayToFile(file, image.getBytes()); } catch
	 * (IOException e) { // TODO Auto-generated catch block throw new
	 * ImageUploadException("Unable to save image", e); }
	 * 
	 * }
	 */

}
