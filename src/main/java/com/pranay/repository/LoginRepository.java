package com.pranay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranay.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	Login findByName(String name);
}
