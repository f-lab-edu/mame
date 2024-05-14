package com.flab.mame.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flab.mame.CustomException;
import com.flab.mame.ErrorCode;
import com.flab.mame.domain.User;
import com.flab.mame.dto.request.UserSignupRequest;
import com.flab.mame.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void signup(final UserSignupRequest reqeust) {
		userRepository.findByEmail(reqeust.getEmail()).ifPresent(e -> {
			throw new CustomException(ErrorCode.EMAIL_ALREADY_EXIST);
		});

		User newUser = User.builder()
			.email(reqeust.getEmail())
			.password(reqeust.getPassword())
			.name(reqeust.getName())
			.age(reqeust.getAge())
			.gender(reqeust.getGender())
			.build();

		userRepository.save(newUser);
	}

}
