package com.fitnessapp.service;


import com.fitnessapp.model.Workout;
import com.fitnessapp.repository.UserRepository;
import com.fitnessapp.repository.WorkoutRepository;
import com.fitnessapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WorkoutActiveService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    private Map<User, Workout> activeWorkouts = new HashMap<>();

    public void assignWorkoutToUser(Long userId, Long workoutId) {
        User user = userRepository.findById(userId).orElse(null);
        Workout workout = workoutRepository.findById(workoutId).orElse(null);
        if (user != null && workout != null) {
            activeWorkouts.put(user, workout);
        }
    }

    public Map<User, Workout> getActiveWorkouts() {
        return activeWorkouts;
    }

    public void deleteWorkoutToUser(Long id) {
    	workoutRepository.deleteById(id);
    }
}
