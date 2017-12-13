package ru.unn.db.fitnessclub;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.unn.db.fitnessclub.entities.Card;
import ru.unn.db.fitnessclub.entities.Client;
import ru.unn.db.fitnessclub.entities.Exercise;
import ru.unn.db.fitnessclub.entities.Trainer;
import ru.unn.db.fitnessclub.repositories.CardRepository;
import ru.unn.db.fitnessclub.repositories.ClientRepository;
import ru.unn.db.fitnessclub.repositories.ExerciseRepository;
import ru.unn.db.fitnessclub.repositories.TrainerRepository;

import java.io.IOException;



@SpringBootApplication
public class Main extends Application implements CommandLineRunner {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Main.class);
    private static final String MAIN_FXML = "Main.fxml";
    private static final String MAIN_TITLE = "Fitness Club";

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Client.repository = clientRepository;
        Card.repository = cardRepository;
        Trainer.repository = trainerRepository;
        Exercise.repository = exerciseRepository;
        LOGGER.info("*** initializing Java FX ***");
        launch(args);
        LOGGER.info("*** finished ***");
/*
        Date date = Date.valueOf("2017-11-30");
        Client client = clientRepository.findAll().iterator().next();
        cardRepository.save(new Card(date,100, client));*/
        //repository.save(new Client("Петька", "+71234567890", (byte) 3));
        //repository.findAll().forEach(c -> LOGGER.info("\tfindAll: {}", c));
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        java.net.URL fxml = Main.class.getClassLoader().getResource(MAIN_FXML);
        if (fxml == null) fxml = Main.class.getResource(MAIN_FXML);
        Parent root = FXMLLoader.load(fxml);
        primaryStage.setTitle(MAIN_TITLE);
        primaryStage.setScene(new Scene(root));
        LOGGER.info("*** done initializing Java FX ***");
        primaryStage.show();
    }
}
