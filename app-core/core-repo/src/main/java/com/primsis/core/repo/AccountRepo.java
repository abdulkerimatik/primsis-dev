package com.primsis.core.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.primsis.core.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	
	Optional<Account> findById(Long id);
}
