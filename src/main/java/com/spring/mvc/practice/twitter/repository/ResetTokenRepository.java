package com.spring.mvc.practice.twitter.repository;

import com.spring.mvc.practice.twitter.entity.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetTokenRepository extends JpaRepository<ResetToken,Integer> {

    ResetToken findByToken(String token);

}
