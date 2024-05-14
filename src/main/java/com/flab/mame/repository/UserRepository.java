package com.flab.mame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flab.mame.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
