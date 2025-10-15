package com.security.UserManagementSystem.Controller;

import com.security.UserManagementSystem.Entity.Users;
import com.security.UserManagementSystem.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UsersContoller {

    @Autowired
    UsersService usersService;


    @GetMapping("/users")
    public List<Users> getUser(){
        return usersService.getAllUsers() ;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        usersService.register(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        return usersService.verify(users);

    }
}
