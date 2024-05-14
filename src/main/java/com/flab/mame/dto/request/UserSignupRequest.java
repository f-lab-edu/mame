package com.flab.mame.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserSignupRequest {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String name;
	/*
	 * TODO : MethodArgumentException handler needed
	 * */
	@NotNull
	private Integer age;

	@NotBlank
	private String gender;

}
