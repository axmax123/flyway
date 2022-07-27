package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "project_name", nullable = false, length = 30)
    private String projectName;

    @Column(name = "time_start", nullable = false)
    private LocalDate timeStart;

    @Column(name = "time_end", nullable = false)
    private LocalDate timeEnd;

    @Column(name = "state", nullable = false, length = 30)
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDate timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDate getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDate timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}