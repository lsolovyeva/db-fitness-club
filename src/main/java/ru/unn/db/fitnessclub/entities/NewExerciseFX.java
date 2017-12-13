package ru.unn.db.fitnessclub.entities;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class NewExerciseFX extends ExerciseFX {
    private boolean isNameSet, isSportKindSet, isDayOfWeekSet, isStartTimeSet, isDurationSet;

    public NewExerciseFX() {
        super(new Exercise("<Name>", "<SportKind>", DayOfWeek.SUNDAY, LocalTime.MIDNIGHT, Duration.ZERO));
        isNameSet = isSportKindSet = isDayOfWeekSet = isStartTimeSet = isDurationSet = false;
    }
    private boolean isAllSet() {
        return isNameSet && isSportKindSet && isDayOfWeekSet && isStartTimeSet && isDurationSet;
    }
    @Override
    public void setName(String name) {
        isNameSet = true;
        if (isAllSet()) super.setName(name);
        else exercise.setName(name);
    }
    @Override
    public void setSportKind(String sportKind) {
        isSportKindSet = true;
        if (isAllSet()) super.setSportKind(sportKind);
        else exercise.setSportKind(sportKind);
    }
    @Override
    public void setDayOfWeek(String dayOfWeek) {
        isDayOfWeekSet = true;
        if (isAllSet()) super.setDayOfWeek(dayOfWeek);
        else exercise.setDayOfWeek(DayOfWeek.valueOf(dayOfWeek));
    }
    @Override
    public void setStartTime(String startTime) {
        isStartTimeSet = true;
        if (isAllSet()) super.setStartTime(startTime);
        else exercise.setStartTime(LocalTime.parse(startTime));
    }
    @Override
    public void setDuration(String duration) {
        isDurationSet = true;
        if (isAllSet()) super.setDuration(duration);
        else exercise.setDuration(Duration.parse(duration));
    }
}
