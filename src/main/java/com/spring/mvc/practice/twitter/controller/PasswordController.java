package com.spring.mvc.practice.twitter.controller;

import com.spring.mvc.practice.twitter.controller.service.EmailService;
import com.spring.mvc.practice.twitter.entity.ForgotPasswordDto;
import com.spring.mvc.practice.twitter.entity.PasswordResetDto;
import com.spring.mvc.practice.twitter.entity.ResetToken;
import com.spring.mvc.practice.twitter.entity.User;
import com.spring.mvc.practice.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.UUID;

@Controller
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private UserService service;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("forgotPasswordForm")
    public ForgotPasswordDto forgotPasswordDto() {
        return new ForgotPasswordDto();
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword(Model model) {
        model.addAttribute("user", new User());
        return "forgotPassword";
    }

    @PostMapping("/processForgotPassword")
    public String processForgotPassword(@ModelAttribute("forgotPasswordForm") @Valid ForgotPasswordDto form, HttpServletRequest request) throws ValidationException {

        System.out.println(form.getEmail());

        User user = service.findUserByEmail(form.getEmail());

        if (user == null) {
            throw new ValidationException("Email entered is not present in the Database");
        }

        ResetToken token = new ResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        service.save(token);
        System.out.println(token);

        String appURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/password/reset?token=" + token.getToken();

        System.out.println(appURL);

        System.out.println("token saved");

        emailService.sendMail(user.getEmail(), "Test Subject",
                "Click on the link below to reset your password <a href=" + appURL + "></a>");

        return "passwordResetSuccess";
    }

    @GetMapping("/reset")
    public String reset(Model model, @RequestParam("token") String token) throws ValidationException {

        ResetToken resettoken = service.findUserByToken(token);

        if (resettoken == null) {
            throw new ValidationException("User is not present in the database");
        }

        String t1 = resettoken.getToken();
        System.out.println(t1);
        model.addAttribute("token",t1);
        model.addAttribute("user", new User());

        return "resetPage";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute("passwordResetForm") PasswordResetDto form) {


        ResetToken resettoken = service.findUserByToken(form.getToken());

        System.out.println(resettoken);

        User user = resettoken.getUser();
        System.out.println(user);

        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        System.out.println(passwordEncoded);

        service.savePassword(passwordEncoded, user.getId());
        service.delete(resettoken);
        return "passwordChanged";

    }

}
