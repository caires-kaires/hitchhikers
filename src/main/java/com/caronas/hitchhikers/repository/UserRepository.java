package com.caronas.hitchhikers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caronas.hitchhikers.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
