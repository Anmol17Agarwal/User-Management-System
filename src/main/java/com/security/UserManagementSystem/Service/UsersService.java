package com.security.UserManagementSystem.Service;

import com.security.UserManagementSystem.Entity.Users;
import com.security.UserManagementSystem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthenticationManager authManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users users){
        users.setUserPassword(encoder.encode(users.getUserPassword()));
        return usersRepository.save(users);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public String verify(Users users) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            users.getUserName(),
                            users.getUserPassword()
                    )
            );

            if (authentication.isAuthenticated()) {
                return "Success";
            } else {
                return "Failure";
            }

        } catch (Exception e) {
            return "Failure";
        }
    }

}
