package com.fitnessapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public User getUser() {
		return user;
	}
	public Workout getWorkout() {
		return workout;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	private LocalDateTime startTime;
    private LocalDateTime endTime;
	public void setUser(User user) {
		this.user=user;
		
	}
	public void setWorkout(Workout workout) {
		this.setWorkout(workout);		
	}
	public void setStartTime(LocalDateTime now) {
		this.setStartTime(now);
		
	}

    // getters and setters
}
