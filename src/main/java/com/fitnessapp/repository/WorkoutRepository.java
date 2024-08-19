package com.fitnessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fitnessapp.model.Workout;

import jakarta.transaction.Transactional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
//	@Modifying
//    @Transactional
//    @Query("DELETE FROM WorkoutSession ws WHERE ws.user.id = :userId AND ws.workout.id = :workoutId")
//	void deleteByUserIdAndWorkoutId(Long userId, Long workoutId);
}