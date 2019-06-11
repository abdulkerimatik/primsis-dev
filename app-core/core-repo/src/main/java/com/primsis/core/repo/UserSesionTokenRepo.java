package com.primsis.core.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.primsis.core.entity.Account;
import com.primsis.core.entity.UserSessionToken;

public interface UserSesionTokenRepo extends JpaRepository<UserSessionToken, Long> {
	
}
