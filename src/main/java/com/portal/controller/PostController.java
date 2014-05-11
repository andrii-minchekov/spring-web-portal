package com.portal.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portal.model.Blogger;
import com.portal.model.Post;
import com.portal.service.BloggerService;
import com.portal.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Inject
	PostService postService;
	
	@Inject
	BloggerService bloggerService;

	@RequestMapping(method = RequestMethod.POST)
	public String createNewBloggerPost(@Valid Post post,
			BindingResult bindingResult, Model model, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
            return "redirect:" + request.getRequestURI();
		}

        String userEmail = getUserEmailFromSecurityContext();
        if (userEmail == null) {
            throw new IllegalArgumentException("User should be authorized");
        }
        Blogger blogger = bloggerService.getBloggerByEmail(userEmail);
        model.addAttribute(blogger);

		post.setBlogger(blogger);
		post.setLastUpdatedDate(new Date());
		postService.savePost(post);
		return "redirect:/posts/blogger/" + blogger.getEmail();
	}

    @RequestMapping(method=RequestMethod.GET)
	public String postList(Model model) {
		model.addAttribute(new Post());
		model.addAttribute("postList", postService.getAllPosts());
		return "posts/posts";
	}

    @RequestMapping(value="/blogger/{blogger_login:.+}")
    public String getPostsOfBlogger(@PathVariable(value = "blogger_login") String email, Model model) {

        Blogger blogger = null;
        try {
            blogger = bloggerService.getBloggerByEmail(email);
        } catch (NoResultException e) {
            model.addAttribute("errorMessage", "Sorry, there is no such user registered");
            return "errorPage";
        }
        model.addAttribute(blogger);
        model.addAttribute(new Post());
        model.addAttribute("postList", bloggerService.getPostsOfBlogger(blogger));
        return "posts/editPosts";
    }

    @RequestMapping(value="{postId}", method=RequestMethod.DELETE)
    public String deletePost(@PathVariable String postId, Model model) {
        postService.deletePost(Long.parseLong(postId));
        model.addAttribute(new Post());
        model.addAttribute("postList", postService.getAllPosts());
        return "redirect:posts/editPosts";
    }

    private String getUserEmailFromSecurityContext() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            throw new IllegalArgumentException("You must be authorized");
        }
        Object principal = auth.getPrincipal();
        String email = null;
        if (principal instanceof UserDetails) {
            return email = ((UserDetails) principal).getUsername();
        }
        return email = principal.toString();
    }
}
