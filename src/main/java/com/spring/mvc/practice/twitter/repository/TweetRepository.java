package com.spring.mvc.practice.twitter.repository;

import com.spring.mvc.practice.twitter.entity.Tweet;
import com.spring.mvc.practice.twitter.entity.UserTweetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TweetRepository extends PagingAndSortingRepository<Tweet, Integer> {

    List<Tweet> findAll();

    @Query("SELECT new com.spring.mvc.practice.twitter.entity.UserTweetDto(u.username,t.description,t.datetime) "
            + "FROM User u INNER JOIN u.tweets t inner join Follow f on u.id = f.whom ")
    Page<UserTweetDto> fetchUserTweetInnerJoin(Pageable pageable);

    @Query("from Tweet where user_id = :id")
    List<Tweet> findAllById(@RequestParam("id") int id);
}
