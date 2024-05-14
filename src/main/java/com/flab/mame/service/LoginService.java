package com.flab.mame.service;

import org.springframework.stereotype.Service;

import com.flab.mame.CustomException;
import com.flab.mame.ErrorCode;
import com.flab.mame.domain.User;
import com.flab.mame.dto.request.UserLoginRequest;
import com.flab.mame.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final UserRepository userRepository;

	private final HttpSession httpSession;

	public void login(final UserLoginRequest request) {
		User foundUser = userRepository.findByEmail(request.getEmail())
			.orElseThrow(() -> new CustomException(ErrorCode.EMAIL_ALREADY_EXIST));

		if (!foundUser.getPassword().equals(request.getPassword())) {
			throw new RuntimeException("비밀번호 틀림");
		}

		httpSession.setAttribute("userId", foundUser.getId());
	}

	public void logout() {
		httpSession.invalidate();
	}
}
