package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Role;
import com.transferTech.backend.enumeration.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(ERole roleName);
}
