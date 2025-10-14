package com.security.UserManagementSystem.Controller;

import com.security.UserManagementSystem.Entity.Users;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersContoller {

    private List<Users> users = new ArrayList<>(List.of(
            new Users(1L,"Anmol","A@123","USER"),
            new Users(2L,"Sanjay","S@123","USER")
    ));
    @GetMapping("/users")
    public List<Users> getUser(){
        return users;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/users")
    public Users createUser(@RequestBody Users user){
        users.add(user);
        return user;
    }
}
