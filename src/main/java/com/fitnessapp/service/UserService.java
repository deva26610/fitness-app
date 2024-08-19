package com.fitnessapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitnessapp.model.Workout;
import com.fitnessapp.repository.WorkoutRepository;

@Service
public class UserService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public void startWorkout(Long workoutId) {
        Workout workout = workoutRepository.findById(workoutId).orElseThrow();
        // Logic to start workout
    }

    public void endWorkout(Long workoutId) {
        Workout workout = workoutRepository.findById(workoutId).orElseThrow();
        // Logic to end workout
    }
}
