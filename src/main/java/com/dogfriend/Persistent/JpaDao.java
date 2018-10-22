package com.dogfriend.Persistent;

import com.dogfriend.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDao extends JpaRepository<User, String> {   //JPA 방식 DB

}