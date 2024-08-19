package com.fitnessapp.controller;

import com.fitnessapp.service.UserWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserWorkoutService userWorkoutService;

    @GetMapping("/start")
    public String startWorkoutPage(Model model) {
        // Add necessary attributes to model
        return "user/startWorkout";
    }

    @PostMapping("/start")
    public String startWorkout(@RequestParam Long userId, @RequestParam Long workoutId) {
        userWorkoutService.startWorkout(userId, workoutId);
        return "redirect:/user/start";
    }

    @GetMapping("/end")
    public String endWorkoutPage(Model model) {
        // Add necessary attributes to model
        return "user/endWorkout";
    }

    @PostMapping("/end")
    public String endWorkout(@RequestParam Long userId, @RequestParam Long workoutId) {
        userWorkoutService.endWorkout(userId, workoutId);
        return "redirect:/user/end";
    }
}
