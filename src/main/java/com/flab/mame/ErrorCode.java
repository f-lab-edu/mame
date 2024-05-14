package com.flab.mame;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	EMAIL_ALREADY_EXIST(HttpStatus.CONFLICT, "이미 존재하는 회원입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
