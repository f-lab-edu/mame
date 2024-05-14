package com.flab.mame.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserLoginRequest {

	@Email
	@NotBlank
	String email;

	@NotBlank
	String password;
}
