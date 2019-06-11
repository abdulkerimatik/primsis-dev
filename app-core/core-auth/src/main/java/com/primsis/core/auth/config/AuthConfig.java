package com.primsis.core.auth.config;

import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.primsis.core.entity.User;
import com.primsis.core.entity.UserSessionToken;
import com.primsis.core.repo.UserRepo;

/**
 * @author abdulkerim.ATIK
 *
 */
@Configuration
@ComponentScan(basePackages = "com.primsis.core")
@EntityScan(basePackageClasses = { User.class, UserSessionToken.class })
@EnableJpaRepositories(basePackageClasses = { UserRepo.class, UserSessionToken.class,UserDetailsService.class })
public class AuthConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	

	@Configuration
	 @EnableJpaAuditing
	 class DataJpaConfig {

	     @Bean
	     public AuditorAware<User> auditor() {
	         return () -> Optional.ofNullable(SecurityContextHolder.getContext())
	             .map(SecurityContext::getAuthentication)
	             .filter(Authentication::isAuthenticated)
	             .map(Authentication::getPrincipal)
	             .map(User.class::cast);
	     }
	}
}
