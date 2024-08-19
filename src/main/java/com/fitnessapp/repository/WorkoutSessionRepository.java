package com.fitnessapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fitnessapp.model.WorkoutSession;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {

	void deleteByUserIdAndWorkoutId(Long userId, Long workoutId);

	List<WorkoutSession> findByStartTimeBetween(LocalDateTime startOfWeek, LocalDateTime endOfWeek);

}
