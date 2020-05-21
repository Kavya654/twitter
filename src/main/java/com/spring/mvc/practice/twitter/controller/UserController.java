package com.spring.mvc.practice.twitter.controller;

import com.spring.mvc.practice.twitter.controller.exception.UserObjectIsNullException;
import com.spring.mvc.practice.twitter.entity.Follow;
import com.spring.mvc.practice.twitter.entity.Tweet;
import com.spring.mvc.practice.twitter.entity.User;
import com.spring.mvc.practice.twitter.entity.UserTweetDto;
import com.spring.mvc.practice.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String showLoginPage() {
        return "loginPage";
    }

    @GetMapping("/feed")
    public String feed(Model model, @RequestParam("page") Optional<Integer> p) {
        Page<UserTweetDto> tweets = service.fetchUserTweetInnerJoin(p.isPresent() ? p.get() : 0);

        List<UserTweetDto> tweetList = tweets.toList();

        SimpleDateFormat dateFormater = new SimpleDateFormat("dd MMMM yyyy");

        model.addAttribute("tweets", tweetList);
        model.addAttribute("page", tweets);
        model.addAttribute("dateFormater", dateFormater);
        return "feed";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerPage";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws UserObjectIsNullException {

        if (bindingResult.hasErrors()) {
            return "registerPage";
        }

        if (user.getUsername() == "") {
            System.out.println(user.getUsername());
            throw new UserObjectIsNullException();
        }

        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        service.save(user);
        return "saved";

    }

    @ExceptionHandler(UserObjectIsNullException.class)
    public String handleResourceNotFoundException() {
        return "error";
    }

    @GetMapping("/createTweet")
    public String createTweet(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "tweet";

    }

    @PostMapping("/addTweet")
    public String addTweet(@ModelAttribute("tweet") Tweet tweet) {

        service.save(tweet);
        return "redirect:/feed";
    }

    @GetMapping("/profile")
    public String myProfile(Model model, @RequestParam("id") int id) {

        List<Tweet> tweets = service.myTweets(id);

        int followers = service.findFollowers();
        int following = service.findFollowing();

        User user = service.findById(id);

        Boolean isFollowing = service.isFollowing(15, id) == 1;

        model.addAttribute("user", user);
        model.addAttribute("followers", followers);
        model.addAttribute("following", following);
        model.addAttribute("tweets", tweets);

        model.addAttribute("isFollowing", isFollowing);

        return "profile";
    }

    @GetMapping("/updateProfile")
    public String updateProfile(Model model,@RequestParam("id") int id){

       User user = service.findById(id);
       model.addAttribute("user",user);

        return "UpdatePage";

    }

    @PostMapping("/saveUpdatedUser")
    public String saveUpdatedUser(String fname, String lname, String username, String email,@RequestParam("id") int id){

        service.update(fname,lname,username,email,id);

        return "redirect:/profile?id=15";
    }


    @GetMapping("/searchUser")
    public String searchUser(@RequestParam("username") String username, Model model, Optional<Integer> id) {

        List<User> name = service.findByUsernames(username, 15);
        System.out.println(name);

        model.addAttribute("user", name);

        return "userFound";
    }

    @PostMapping("/followRequest")
    public String followRequest(@ModelAttribute("follow") Follow follow, @RequestParam("id") int id) {

        follow.setWho(15);
        follow.setWhom(id);
        service.save(follow);

        return "redirect:/feed";

    }

    @PostMapping("/unFollowRequest")
    public String unFollowRequest(@RequestParam("id") int id) {

        service.deleteByWhomId(id);
        return "redirect:/feed";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

}
