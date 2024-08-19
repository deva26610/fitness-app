package com.fitnessapp.controller;

import com.fitnessapp.model.Workout;
import com.fitnessapp.model.User;
import com.fitnessapp.model.Category;
import com.fitnessapp.service.AdminWorkoutService;
import com.fitnessapp.service.AdminUserService;
import com.fitnessapp.service.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminWorkoutService adminWorkoutService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private AdminCategoryService adminCategoryService;

    @GetMapping("/workouts")
    public String viewWorkouts(Model model) {
        List<Workout> workouts = adminWorkoutService.getAllWorkouts();
        model.addAttribute("workouts", workouts);
        return "admin/workouts";
    }

    @PostMapping("/workouts")
    public String addWorkout(@ModelAttribute Workout workout) {
        adminWorkoutService.addWorkout(workout);
        return "redirect:/admin/workouts";
    }

    @PostMapping("/workouts/delete/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        adminWorkoutService.deleteWorkout(id);
        return "redirect:/admin/workouts";
    }

    @GetMapping("/users")
    public String viewUsers(Model model) {
        List<User> users = adminUserService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        adminUserService.addUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        adminUserService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/categories")
    public String viewCategories(Model model) {
        List<Category> categories = adminCategoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin/categories";
    }

    @PostMapping("/categories")
    public String addCategory(@ModelAttribute Category category) {
        adminCategoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        adminCategoryService.deleteCategory(id);
        return "redirect:/admin/categories";
    }
}
