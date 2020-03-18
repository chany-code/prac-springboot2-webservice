package com.chany.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {//user의 CRUD를 담당
    Optional<User> findByEmail(String email);//
}
