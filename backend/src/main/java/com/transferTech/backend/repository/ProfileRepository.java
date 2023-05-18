package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
