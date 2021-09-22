package com.example.clinicmanagementappbackend.controller;
import com.example.clinicmanagementappbackend.model.AppUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BasicAuthController {
    @GetMapping({"/validateLogin"})
    public AppUser basicAuth(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("sessionCookie", "session_cookie");
        cookie.setMaxAge(500);
        httpServletResponse.addCookie(cookie);
        return new AppUser("User successfully authenticated");
    }
}
