package com.spring.mvc.practice.twitter.repository;

import com.spring.mvc.practice.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("from User u where u.username like %:username%")
    User findByUsername(@RequestParam("username") String username);

    @Query("from User u left join Follow f on u.id = f.whom and f.who = :id where u.username like %:username% and (f.status is null or f.status = 'F')")
    List<User> findByUsernames(String username,int id);

    @Modifying
    @Query("update User u set u.fname = :fname, u.lname = :lname , u.username = :username, u.email = :email where u.id = :id")
    void update(String fname,String lname,String username, String email,int id);

    User findUserByEmail(String email);

    @Modifying
    @Query("update User u set u.password = :password where u.id =:id")
    void savePassword(String password,int id);
}
