package ru.unn.db.fitnessclub.entities;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class ExerciseFX {
    final Exercise exercise;

    public ExerciseFX(final Exercise exercise) {
        this.exercise = exercise;
    }
    @Override
    public String toString() {
        return exercise.toString();
    }


    public String getName() {
        return exercise.getName();
    }
    public void setName(String name) {
        exercise.setName(name);
        Exercise.repository.save(exercise);
    }

    public String getSportKind() {
        return exercise.getSportKind();
    }
    public void setSportKind(String sportKind) {
        exercise.setSportKind(sportKind);
        Exercise.repository.save(exercise);
    }


    public String getDayOfWeek() {
        return exercise.getDayOfWeek().toString();
    }
    public void setDayOfWeek(String dayOfWeek) {
        exercise.setDayOfWeek(DayOfWeek.valueOf(dayOfWeek));
        Exercise.repository.save(exercise);
    }


    public String getStartTime() {
        return exercise.getStartTime().toString();
    }
    public void setStartTime(String startTime) {
        exercise.setStartTime(LocalTime.parse(startTime));
        Exercise.repository.save(exercise);
    }


    public String getDuration() {
        return exercise.getDuration().toString();
    }
    public void setDuration(String duration) {
        exercise.setDuration(Duration.parse(duration));
        Exercise.repository.save(exercise);
    }

    public void remove() {
        Exercise.repository.delete(exercise);
    }


    public static void initColumns(ObservableList<TableColumn<ExerciseFX, ?>> columns) {
        TableColumn<ExerciseFX, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                //event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue())
                event -> event.getRowValue().setName(event.getNewValue())
        );
        columns.add(nameCol);

        TableColumn<ExerciseFX, String> sportKindCol = new TableColumn<>("Sport kind");
        sportKindCol.setMinWidth(100);
        sportKindCol.setCellValueFactory(new PropertyValueFactory<>("sportKind"));
        sportKindCol.setCellFactory(TextFieldTableCell.forTableColumn());
        sportKindCol.setOnEditCommit(
                event -> event.getRowValue().setSportKind(event.getNewValue())
        );
        columns.add(sportKindCol);

        TableColumn<ExerciseFX, String> dayOfWeekCol = new TableColumn<>("Day of week");
        dayOfWeekCol.setMinWidth(50);
        dayOfWeekCol.setCellValueFactory(new PropertyValueFactory<>("dayOfWeek"));
        dayOfWeekCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dayOfWeekCol.setOnEditCommit(
                event -> event.getRowValue().setDayOfWeek(event.getNewValue())
        );
        columns.add(dayOfWeekCol);

        TableColumn<ExerciseFX, String> startTimeCol = new TableColumn<>("Start time");
        startTimeCol.setMinWidth(50);
        startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        startTimeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        startTimeCol.setOnEditCommit(
                event -> event.getRowValue().setStartTime(event.getNewValue())
        );
        columns.add(startTimeCol);

        TableColumn<ExerciseFX, String> durationCol = new TableColumn<>("Duration");
        durationCol.setMinWidth(50);
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        durationCol.setCellFactory(TextFieldTableCell.forTableColumn());
        durationCol.setOnEditCommit(
                event -> event.getRowValue().setDuration(event.getNewValue())
        );
        columns.add(durationCol);
    }
}
