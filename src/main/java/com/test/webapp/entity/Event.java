package com.test.webapp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="course")
    private Course course;

    @ManyToOne
    @JoinColumn(name="trainer")
    private Trainer trainer;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Event() {
    }

    public Event(Course course, Trainer trainer, LocalDate date) {
        this.course = course;
        this.trainer = trainer;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id) && date.equals(event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
