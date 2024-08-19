package com.fitnessapp.controller;

import com.fitnessapp.model.User;
import com.fitnessapp.model.Workout;
import com.fitnessapp.service.TrainerService;
import com.fitnessapp.service.WorkoutActiveService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private WorkoutActiveService workoutActiveService;
    
    @Autowired
    private TrainerService trainerService;

    
    @GetMapping("/assign")
    public String viewAssignWorkouts(Model model) {
        Map<User, Workout> workOuts = workoutActiveService.getActiveWorkouts();
        model.addAttribute("workoutSessions", workOuts);
        return "trainer/assignWorkouts";
    }

    @PostMapping("/assign")
    public String assignWorkoutToUser(@RequestParam Long userId, @RequestParam Long workoutId) {
        workoutActiveService.assignWorkoutToUser(userId, workoutId);
        return "redirect:/trainer/assign";
    }
   
//    @PostMapping("/delete/{id}")
//    public String deleteWorkoutSession(@PathVariable Long id) {
//        trainerService.deleteWorkoutSession(id);
//        return "redirect:/trainer/assign";
//    }
    @PostMapping("/delete/{userId}/{workoutId}")
    public String deleteWorkoutSession(@PathVariable Long userId, @PathVariable Long workoutId) {
        trainerService.deleteWorkoutSession(userId, workoutId);
        return "redirect:/trainer/assign";
    }
}
