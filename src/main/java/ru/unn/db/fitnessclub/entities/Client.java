package ru.unn.db.fitnessclub.entities;

import org.springframework.data.annotation.Id;
import ru.unn.db.fitnessclub.repositories.ClientRepository;

public class Client {
    public static ClientRepository repository;

    @Id
    private String id;
    private String name;
    private String mobile;
    private byte age;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }
    public void setAge(byte age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Client(String name, String mobile, byte age) {
        this.name = name;
        this.mobile = mobile;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id=%s, name='%s', mobile='%s', age = '%d']",
                id, name, mobile, age);
    }
}
