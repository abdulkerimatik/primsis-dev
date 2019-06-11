package com.primsis.core.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.primsis.core.entity.Role;
import com.primsis.core.entity.User;
import com.primsis.core.repo.RoleRepo;
import com.primsis.core.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {


    @Autowired
    UserRepo users;
    
    @Autowired
    	RoleRepo roleRepo;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    Role role = Role.builder()
		.active(true).code("admin")
		.description("Admin")
		.name("admin")
		.build();
    
    
    roleRepo.save(role);
    
        this.users.save(User.builder()
            .username("user")
            .password(this.passwordEncoder.encode("password"))
            .build()
        );

        this.users.save(User.builder()
            .username("admin")
            .password(this.passwordEncoder.encode("password"))
            .build()
        );

        log.debug("printing all users...");
        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
    }
}
