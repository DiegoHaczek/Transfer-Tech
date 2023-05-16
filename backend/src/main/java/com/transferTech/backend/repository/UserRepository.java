package com.transferTech.backend.repository;

import com.transferTech.backend.entity.User;

public interface UserRepository {
    User create(User user);
    User findById(int id);
    User update(User user);
    void delete(User user);

}
