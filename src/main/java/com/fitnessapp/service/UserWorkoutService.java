package com.fitnessapp.service;


import com.fitnessapp.model.Workout;
import com.fitnessapp.model.WorkoutSession;
import com.fitnessapp.model.User;
import com.fitnessapp.repository.WorkoutRepository;
import com.fitnessapp.repository.WorkoutSessionRepository;
import com.fitnessapp.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkoutSessionRepository workoutSessionRepository;
    
    public void startWorkout(Long userId, Long workoutId) {
        // Logic to start workout for user
    	Optional<User> userOpt = userRepository.findById(userId);
        Optional<Workout> workoutOpt = workoutRepository.findById(workoutId);

        if (userOpt.isPresent() && workoutOpt.isPresent()) {
            User user = userOpt.get();
            Workout workout = workoutOpt.get();

            // Create and save a new workout session
            WorkoutSession workoutSession = new WorkoutSession();
            workoutSession.setUser(user);
            workoutSession.setWorkout(workout);
            workoutSession.setStartTime(LocalDateTime.now());

            workoutSessionRepository.save(workoutSession);
        } else {
            throw new RuntimeException("User or Workout not found");
        }
    }

    public void endWorkout(Long userId, Long workoutId) {
        // Logic to end workout for user
    	 Optional<User> userOpt = userRepository.findById(userId);
         Optional<Workout> workoutOpt = workoutRepository.findById(workoutId);

         if (userOpt.isPresent() && workoutOpt.isPresent()) {
             User user = userOpt.get();
             Workout workout = workoutOpt.get();

             // Find the active workout session
             WorkoutSession workoutSession = workoutSessionRepository
                     .findAll()
                     .stream()
                     .filter(ws -> ws.getUser().equals(user) && ws.getWorkout().equals(workout) && ws.getEndTime() == null)
                     .findFirst()
                     .orElseThrow(() -> new RuntimeException("Active workout session not found"));

             // End the workout session
             workoutSession.setEndTime(LocalDateTime.now());
             workoutSessionRepository.save(workoutSession);
         } else {
             throw new RuntimeException("User or Workout not found");
         }
    }
}
