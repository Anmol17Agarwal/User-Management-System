package com.security.UserManagementSystem.Repository;

import com.security.UserManagementSystem.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserName(String username);
}
