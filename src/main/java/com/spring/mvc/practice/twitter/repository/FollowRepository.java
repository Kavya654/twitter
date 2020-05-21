package com.spring.mvc.practice.twitter.repository;

import com.spring.mvc.practice.twitter.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface FollowRepository extends JpaRepository<Follow, Integer> {

    @Query("SELECT count(*) FROM Follow f where f.whom = 15")
    int findFollowers();

    @Query("SELECT count(*) FROM Follow f where f.who = 15")
    int findFollowing();

    @Query("select count(*) FROM Follow f where f.who = :who and f.whom = :whom")
    int isFollowing(int who, int whom);

    @Modifying
    @Query("delete from Follow f where f.whom=:id")
    void deleteByWhomId(@RequestParam("id") int id);

}
