package com.caserta.spring_security.repository;

import com.caserta.spring_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleType(String roleType);
}
