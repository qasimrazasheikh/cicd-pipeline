package com.javatechie.controller;

import com.javatechie.config.UserInfoUserDetails;
import com.javatechie.config.UserInfoUserDetailsService;
import com.javatechie.entity.UserCredentials;
import com.javatechie.entity.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserAuthController {



    @Autowired
    UserInfoUserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/authenticateUser")
    public String doAuthentication(@RequestBody UserCredentials userCredentials, HttpServletRequest request, HttpServletResponse response
                                   ){
//        UserDetails userDetails = userDetailsService.loadUserByUsername(userCredentials.getName());
//        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,  userDetails,userDetails.getAuthorities());

        Authentication authentication = new UsernamePasswordAuthenticationToken(userCredentials.getName(),  userCredentials.getPassword());
        authentication = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession().setAttribute("SPRING_SECURITY_CONTEXT",SecurityContextHolder.getContext());


//        Cookie jsessionIdCookie = new Cookie("JSESSIONID", request.getSession().getId());
//        jsessionIdCookie.setMaxAge(-1); // Session cookie (expires when browser is closed)
//        jsessionIdCookie.setPath("/");
//        jsessionIdCookie.setDomain("localhost");
//        response.addCookie(jsessionIdCookie);
        return request.getSession().getId() ;
    }
    @GetMapping("/welcome")
    public String welcomeUser(){
        return "Welcome user";
    }
}
