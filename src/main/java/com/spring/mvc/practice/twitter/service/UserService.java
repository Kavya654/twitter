package com.spring.mvc.practice.twitter.service;

import com.spring.mvc.practice.twitter.entity.*;
import com.spring.mvc.practice.twitter.repository.FollowRepository;
import com.spring.mvc.practice.twitter.repository.ResetTokenRepository;
import com.spring.mvc.practice.twitter.repository.TweetRepository;
import com.spring.mvc.practice.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TweetRepository tweetRepo;

    @Autowired
    private FollowRepository followRepo;

    @Autowired
    private ResetTokenRepository tokenRepo;

    public void save(@Valid User user) {
        repo.save(user);
    }

    public void save(Tweet tweet) {
        tweetRepo.save(tweet);
    }

    public List<Tweet> findAll() {
        return tweetRepo.findAll();
    }

    public Page<UserTweetDto> fetchUserTweetInnerJoin(int page) {

        Pageable paging= PageRequest.of(page,5);
        Page<UserTweetDto> pagedResult = tweetRepo.fetchUserTweetInnerJoin(paging);
        return pagedResult;
    }

    public User findById(int id) {

        return repo.findById(id).get();
    }

    public int findFollowers() {
        return followRepo.findFollowers();
    }

    public int isFollowing(int who, int whom) {
        return followRepo.isFollowing(who, whom);
    }

    public int findFollowing() {
        return followRepo.findFollowing();
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public List<User> findByUsernames(String username,int id) {
        return repo.findByUsernames(username,id);
    }

    public void save(Follow follow) {
        followRepo.save(follow);
    }

    public List<Tweet> myTweets(int id) {
        return tweetRepo.findAllById(id);
    }

    @Transactional
    public void deleteByWhomId(int id) {
        followRepo.deleteByWhomId(id);
    }

    @Transactional
    public void update(String fname,String lname,String username, String email,int id) {
        repo.update(fname,lname,username,email,id);
    }
    public User findUserByEmail(String email) {

        return repo.findUserByEmail(email);
    }

    @Transactional
    public void savePassword(String password,int  id) {
        repo.savePassword(password,id);
    }

    public void save(ResetToken token) {
        tokenRepo.save(token);
    }
    public ResetToken findUserByToken(String token) {

        return tokenRepo.findByToken(token);
    }
    public void delete(ResetToken t1) {
        tokenRepo.delete(t1);
    }
}





