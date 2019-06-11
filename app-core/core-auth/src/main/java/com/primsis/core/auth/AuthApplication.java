package com.primsis.core.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.primsis.core.auth.config.AuthConfig;

/**
 * @author abdulkerim.ATIK
 *
 */
@Import(value=AuthConfig.class)
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}




