package ru.unn.db.fitnessclub.entities;

import org.springframework.data.annotation.Id;
import ru.unn.db.fitnessclub.repositories.TrainerRepository;

public class Trainer {
    public static TrainerRepository repository;

    @Id
    private String id;
    private String name;
    private String mobile;
    private String sportKind;


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

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Trainer(String name, String mobile, String sportKind) {
        this.name = name;
        this.mobile = mobile;
        this.sportKind = sportKind;
    }

    @Override
    public String toString() {
        return String.format(
                "Trainer[id=%s, name='%s', mobile='%s', sportKind = '%s']",
                id, name, mobile, sportKind);
    }
}
