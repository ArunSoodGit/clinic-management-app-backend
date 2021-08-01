package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
public class BasicAuthController {
    @GetMapping({"/validateLogin"})
    public User basicAuth(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("sessionCookie", "session_cookie");
        cookie.setMaxAge(500);
        httpServletResponse.addCookie(cookie);
        return new User("User successfully authenticated");
    }

}
