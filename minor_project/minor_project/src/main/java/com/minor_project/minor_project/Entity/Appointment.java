package com.minor_project.minor_project.Entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String taskLocation;

    @NotNull
    private String taskDuration;  // "small", "medium", "large"

    @NotNull
    private String taskDetails;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskLocation() {
        return taskLocation;
    }

    public void setTaskLocation(String taskLocation) {
        this.taskLocation = taskLocation;
    }

    public String getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(String taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }
}
