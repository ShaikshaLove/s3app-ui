package io.s3soft.proxyapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.s3soft.proxyapp.model.NavBar;
import io.s3soft.proxyapp.model.User;
import io.s3soft.proxyapp.service.IUserService;
import io.s3soft.proxyapp.util.NavbarUtil;

@RestController
@RequestMapping("/myaccount")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public NavBar getGetNavBar() {
		SecurityContext securityContext=SecurityContextHolder.getContext();
		String email=securityContext.getAuthentication().getName();
		User user=userService.getUserByEmail(email);
		System.out.println(user);
		NavBar navbar=new NavBar();
		navbar.setUser(user);
		if(user.getRoles().contains("USER")&user.getRoles().contains("ADMIN")) {
			navbar.setNavLinks(NavbarUtil.getAdminLinks());
		}else {
			navbar.setNavLinks(NavbarUtil.getUserLinks());
		}

		return navbar;
	}
}
