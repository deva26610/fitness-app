package com.fitnessapp.service;



import com.fitnessapp.model.User;
import com.fitnessapp.model.Workout;
import com.fitnessapp.repository.UserRepository;
import com.fitnessapp.repository.WorkoutRepository;
import com.fitnessapp.repository.WorkoutSessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;

@Service
public class TrainerService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutRepository workoutRepository;
    
    @Autowired
    private WorkoutSessionRepository workoutSessionRepository;

    public void assignWorkoutToUser(Long userId, Long workoutId) {
        User user = userRepository.findById(userId).orElse(null);
        Workout workout = workoutRepository.findById(workoutId).orElse(null);

        if (user != null && workout != null) {
           // user.getWorkouts().add(workout);
            userRepository.save(user);
        }
    }
    

    
//    public void deleteWorkoutSession(Long workoutId) {
//    	workoutRepository.deleteById(workoutId);
//    }
    
    public void deleteWorkoutSession(Long id) {
        workoutSessionRepository.deleteById(id);
    }
    
    @Transactional
    public void deleteWorkoutSession(Long userId, Long workoutId) {
        workoutSessionRepository.deleteByUserIdAndWorkoutId(userId, workoutId);
    }
    
}
