package com.primsis.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primsis.core.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
}
