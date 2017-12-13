package ru.unn.db.fitnessclub.entities;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TrainerFX {
    final Trainer trainer;

    public TrainerFX(final Trainer trainer) {
        this.trainer = trainer;
    }


    @Override
    public String toString() {
        return trainer.toString();
    }


    public String getName() {
        return trainer.getName();
    }

    public void setName(String name) {
        trainer.setName(name);
        Trainer.repository.save(trainer);
    }

    public String getMobile() {
        return trainer.getMobile();
    }

    public void setMobile(String mobile) {
        trainer.setMobile(mobile);
        Trainer.repository.save(trainer);
    }

    public String getSportKind() {
        return trainer.getSportKind();
    }

    public void setSportKind(String sportKind) {
        trainer.setSportKind(sportKind);
        Trainer.repository.save(trainer);
    }

    public void remove() {
        Trainer.repository.delete(trainer);
    }


    public static void initColumns(ObservableList<TableColumn<TrainerFX, ?>> columns) {
        TableColumn<TrainerFX, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                event -> event.getRowValue().setName(event.getNewValue())
        );
        columns.add(nameCol);

        TableColumn<TrainerFX, String> mobileCol = new TableColumn<>("Mobile");
        mobileCol.setMinWidth(100);
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        mobileCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mobileCol.setOnEditCommit(
                event -> event.getRowValue().setMobile(event.getNewValue())
        );
        columns.add(mobileCol);

        TableColumn<TrainerFX, String> sportKindCol = new TableColumn<>("Sport kind");
        sportKindCol.setMinWidth(150);
        sportKindCol.setCellValueFactory(new PropertyValueFactory<>("sportKind"));
        sportKindCol.setCellFactory(TextFieldTableCell.forTableColumn());
        sportKindCol.setOnEditCommit(
                event -> event.getRowValue().setSportKind(event.getNewValue())
        );
        columns.add(sportKindCol);
    }
}
