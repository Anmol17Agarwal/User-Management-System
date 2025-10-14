package com.security.UserManagementSystem.Controller;

import com.security.UserManagementSystem.Entity.User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserContoller {

    private List<User> users = new ArrayList<>(List.of(
            new User(1L,"Anmol","USER"),
            new User(2L,"Sanjay","ADMIN")
    ));
    @GetMapping("/users")
    public List<User> getUser(){
        return users;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        users.add(user);
        return user;
    }
}
