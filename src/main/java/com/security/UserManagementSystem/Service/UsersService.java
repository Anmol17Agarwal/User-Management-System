package com.security.UserManagementSystem.Service;

import com.security.UserManagementSystem.Entity.Users;
import com.security.UserManagementSystem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users users){
        users.setUserPassword(encoder.encode(users.getUserPassword()));
        return usersRepository.save(users);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
