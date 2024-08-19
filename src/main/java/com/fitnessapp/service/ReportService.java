package com.fitnessapp.service;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessapp.model.WorkoutSession;
import com.fitnessapp.repository.WorkoutSessionRepository;

@Service
public class ReportService {

	 @Autowired
	  private WorkoutSessionRepository workoutSessionRepository;
	 
    public String generateWeeklyReport() {
    	
    	LocalDate startOfWeekDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDateTime startOfWeek = startOfWeekDate.atStartOfDay();
        LocalDateTime endOfWeek = LocalDateTime.now();
        

        List<WorkoutSession> weeklySessions = workoutSessionRepository.findByStartTimeBetween(startOfWeek, endOfWeek);

        return generateReport("Weekly", weeklySessions);
    }

    public String generateMonthlyReport() {
        LocalDate startOfMonthDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime startOfMonth = startOfMonthDate.atStartOfDay();
        LocalDateTime endOfMonth = LocalDateTime.now();

        List<WorkoutSession> monthlySessions = workoutSessionRepository.findByStartTimeBetween(startOfMonth, endOfMonth);

        return generateReport("Monthly", monthlySessions);
    }

    private String generateReport(String reportType, List<WorkoutSession> sessions) {
        if (sessions.isEmpty()) {
            return reportType + " Report: No data available";
        }

        int totalSessions = sessions.size();
        int totalDuration = sessions.stream()
                .filter(session -> session.getEndTime() != null) // Filter out sessions without end time
                .mapToInt(session -> Duration.between(session.getStartTime(), session.getEndTime()).toMinutesPart())
                .sum();

        // Customize the report content as needed
        StringBuilder report = new StringBuilder();
        report.append(reportType).append(" Report\n");
        report.append("Total Sessions: ").append(totalSessions).append("\n");
        report.append("Total Duration: ").append(totalDuration).append(" minutes\n");

        // Include details of each session if needed
        sessions.forEach(session -> {
            report.append("User: ").append(session.getUser().getUsername())
                  .append(", Workout: ").append(session.getWorkout().getName())
                  .append(", Duration: ")
                  .append(session.getEndTime() != null ? Duration.between(session.getStartTime(), session.getEndTime()).toMinutes() : "In Progress")
                  .append(" minutes\n");
        });

        return report.toString();
    }
}
