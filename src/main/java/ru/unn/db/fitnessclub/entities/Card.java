package ru.unn.db.fitnessclub.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import ru.unn.db.fitnessclub.repositories.CardRepository;

import java.util.Date;

public class Card {
    public static CardRepository repository;
    @Id
    private String id;
    private Date date;
    private int price;
    @DBRef
    private Client client;

    public Card(Date date, int price, Client client) {
        this.date = date;
        this.price = price;
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}


