package com.javatechie.controller;

import com.javatechie.dto.Product;
import com.javatechie.entity.UserInfo;
import com.javatechie.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000","http://localhost:8082"})

@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request) {

        Authentication auth =(Authentication) request.getSession().getAttribute("Auth");
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/all")

//    @PreAuthorize("hasAuthority('ROLE_ANONYMOUS')")
    public List<Product> getAllTheProducts() {
        System.out.println("in getAllTheProducts");
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
}
