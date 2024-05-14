package com.flab.mame.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flab.mame.dto.request.UserLoginRequest;
import com.flab.mame.service.LoginService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@PostMapping("/login")
	public void login(@RequestBody @Valid final UserLoginRequest request) {
		loginService.login(request);
	}

	@GetMapping("/logout")
	public void logout() {
		loginService.logout();
	}
}
