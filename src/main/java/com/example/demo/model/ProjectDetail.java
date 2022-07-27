package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "project_detail")
public class ProjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long id;

    @Lob
    @Column(name = "status")
    private String status;

    @Column(name = "time_start")
    private LocalDate timeStart;

    @Column(name = "time_end")
    private LocalDate timeEnd;

    @Column(name = "technical")
    private String technical;

    public Long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

}