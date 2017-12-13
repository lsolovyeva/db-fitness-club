package ru.unn.db.fitnessclub.entities;

import org.springframework.data.annotation.Id;
import ru.unn.db.fitnessclub.repositories.ExerciseRepository;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Exercise {
    public static ExerciseRepository repository;

    @Id
    private String id;
    private String name;
    private String sportKind;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private Duration duration;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSportKind() {
        return sportKind;
    }
    public void setSportKind(String sportKind) {
        this.sportKind = sportKind;
    }

    public Duration getDuration() {
        return duration;
    }
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


    public Exercise(String name, String sportKind, DayOfWeek dayOfWeek, LocalTime startTime, Duration duration) {
        this.name = name;
        this.sportKind = sportKind;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format(
                "Exercise[id=%s, name='%s', sportKind='%s', dayOfWeek='%s', startTime='%s', duration='%s']",
                id, name, sportKind, dayOfWeek, startTime, duration);
    }
}
