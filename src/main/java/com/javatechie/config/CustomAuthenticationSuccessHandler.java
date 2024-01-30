//package com.javatechie.config;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//
//import java.io.IOException;
//
//@Component
//public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, ServletException {
//        HttpSession session = request.getSession();
//        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
//
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}
