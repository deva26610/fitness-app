package com.fitnessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitnessapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
