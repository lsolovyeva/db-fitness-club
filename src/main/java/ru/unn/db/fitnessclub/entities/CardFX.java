package ru.unn.db.fitnessclub.entities;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.text.SimpleDateFormat;

public class CardFX {
    final Card card;
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public CardFX(final Card card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return card.toString();
    }

    public String getDate() {
        //return card.getDate().toString();
        return dateFormatter.format(card.getDate());
    }
    //public void setDate(String date) {
    //    Date from = Date.from(Instant.parse(date));
    //    Date from2 = new Date(date);
    //    card.setDate(from2);
    //    Card.repository.save(card);
    //}

    public String getPrice() {
        return String.valueOf(card.getPrice());
    }
    public void setPrice(String price) {
        card.setPrice(Integer.valueOf(price));
        Card.repository.save(card);
    }

    public Client getClient() {
        return card.getClient();
    }
    public void setClient(Client client) {
        card.setClient(client);
        Card.repository.save(card);
    }

    public String getClientName() {
        return card.getClient().getName();
    }
    public void remove() {
        Card.repository.delete(card);
    }


    public static void initColumns(ObservableList<TableColumn<CardFX, ?>> columns) {


        TableColumn<CardFX, String> col2 = new TableColumn<>("Date");
        col2.setMinWidth(200);
        col2.setCellValueFactory(new PropertyValueFactory<>("date"));
        //col2.setCellFactory(TextFieldTableCell.forTableColumn());
        //col2.setOnEditCommit(
        //        event -> event.getRowValue().setDate(event.getNewValue())
        //);
        columns.add(col2);

        TableColumn<CardFX, String> col3 = new TableColumn<>("Price");
        col3.setMinWidth(50);
        col3.setCellValueFactory(new PropertyValueFactory<>("price"));
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setOnEditCommit(
                event -> event.getRowValue().setPrice(event.getNewValue())
        );
        columns.add(col3);

        TableColumn<CardFX, String> col1 = new TableColumn<>("Client name");
        col1.setMinWidth(200);
        col1.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        //col1.setCellFactory(TextFieldTableCell.forTableColumn());
        //col1.setOnEditCommit(
        //        event -> event.getRowValue().setName(event.getNewValue())
        //);
        columns.add(col1);

    }
}
