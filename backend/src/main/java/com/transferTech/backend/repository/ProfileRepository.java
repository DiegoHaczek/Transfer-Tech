package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Profile;

public interface ProfileRepository {
    Profile create(Profile profile);
    Profile findById(int id);
    Profile update(Profile profile);
    void delete(Profile profile);
}
