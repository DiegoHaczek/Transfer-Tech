package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Role;

public interface RoleRepository {

    Role create(Role role);
    Role findById(int id);
    Role update(Role role);
    void delete(Role role);
}
