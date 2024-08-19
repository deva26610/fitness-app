

package com.fitnessapp.service;

import com.fitnessapp.model.Workout;
import com.fitnessapp.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminWorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout updateWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
}
