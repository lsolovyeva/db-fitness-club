package ru.unn.db.fitnessclub;

import javafx.event.Event;
import javafx.scene.control.TabPane;
import ru.unn.db.fitnessclub.entities.*;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;


public class MainForm {
    @FXML
    private TabPane mainTabs;

    @FXML
    private TableView<ClientFX> clientTable;

    @FXML
    private TableView<CardFX> cardTable;

    @FXML
    private TableView<TrainerFX> trainerTable;

    @FXML
    private TableView<ExerciseFX> exerciseTable;

    @FXML
    private void initialize() {
        loadData();

        clientTable.setEditable(true);
        ClientFX.initColumns(clientTable.getColumns());

        cardTable.setEditable(true);
        CardFX.initColumns(cardTable.getColumns());

        trainerTable.setEditable(true);
        TrainerFX.initColumns(trainerTable.getColumns());

        exerciseTable.setEditable(true);
        ExerciseFX.initColumns(exerciseTable.getColumns());
    }

    private void loadData() {
        ObservableList<ClientFX> clients = FXCollections.observableArrayList();
        for (Client client : Client.repository.findAll()) {
            clients.add(new ClientFX(client));
        }
        clientTable.setItems(clients);

        ObservableList<CardFX> cards = FXCollections.observableArrayList();
        for (Card card : Card.repository.findAll()) {
            cards.add(new CardFX(card));
        }
        cardTable.setItems(cards);

        ObservableList<TrainerFX> trainers = FXCollections.observableArrayList();
        for (Trainer trainer : Trainer.repository.findAll()) {
            trainers.add(new TrainerFX(trainer));
        }
        trainerTable.setItems(trainers);

        ObservableList<ExerciseFX> exercises = FXCollections.observableArrayList();
        for (Exercise exercise : Exercise.repository.findAll()) {
            exercises.add(new ExerciseFX(exercise));
        }
        exerciseTable.setItems(exercises);
    }

    @FXML
    private void buttonAddClient_OnAction(ActionEvent event) {
        clientTable.getItems().add(new NewClientFX());
    }

    @FXML
    private void buttonDeleteClient_OnAction(ActionEvent event) {
        ClientFX selectedItem = clientTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            clientTable.getItems().remove(selectedItem);
            selectedItem.remove();
        }
    }

    @FXML
    private void buttonDeleteCard_OnAction(ActionEvent event) {
        CardFX selectedItem = cardTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            cardTable.getItems().remove(selectedItem);
            selectedItem.remove();
        }
    }

    @FXML
    private void buttonAddNewClientCard_OnAction(ActionEvent event) {
        cardTable.getItems().add(new NewCardFX(clientTable.getSelectionModel().getSelectedItem()));
        mainTabs.getSelectionModel().select(1);
    }

    @FXML
    private void tabs_OnSelectionChanged(Event event) {
        System.out.println(event.getEventType().toString());
    }

    @FXML
    private void buttonAddTrainer_OnAction(ActionEvent event) {
        trainerTable.getItems().add(new NewTrainerFX());
    }

    @FXML
    private void buttonDeleteTrainer_OnAction(ActionEvent event) {
        TrainerFX selectedItem = trainerTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            trainerTable.getItems().remove(selectedItem);
            selectedItem.remove();
        }
    }

    @FXML
    private void buttonAddExercise_OnAction(ActionEvent event) {
        exerciseTable.getItems().add(new NewExerciseFX());
    }

    @FXML
    private void buttonDeleteExercise_OnAction(ActionEvent event) {
        ExerciseFX selectedItem = exerciseTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            exerciseTable.getItems().remove(selectedItem);
            selectedItem.remove();
        }
    }
}
