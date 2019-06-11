package com.primsis.core.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primsis.core.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findById(Long id);
}
