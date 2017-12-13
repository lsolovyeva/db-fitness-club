package ru.unn.db.fitnessclub.entities;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ClientFX {
    final Client client;

    public ClientFX(final Client client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return client.toString();
    }


    public String getName() {
        return client.getName();
    }

    public void setName(String name) {
        client.setName(name);
        Client.repository.save(client);
    }

    public String getMobile() {
        return client.getMobile();
    }

    public void setMobile(String mobile) {
        client.setMobile(mobile);
        Client.repository.save(client);
    }

    public String getAge() {
        return Byte.toString(client.getAge());
    }

    public void setAge(String age) {
        client.setAge(Byte.valueOf(age));
        Client.repository.save(client);
    }

    public void remove() {
        Client.repository.delete(client);
    }


    public static void initColumns(ObservableList<TableColumn<ClientFX, ?>> columns) {
        TableColumn<ClientFX, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                //event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue())
                event -> event.getRowValue().setName(event.getNewValue())
        );
        columns.add(nameCol);

        TableColumn<ClientFX, String> mobileCol = new TableColumn<>("Mobile");
        mobileCol.setMinWidth(100);
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        mobileCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mobileCol.setOnEditCommit(
                event -> event.getRowValue().setMobile(event.getNewValue())
        );
        columns.add(mobileCol);

        TableColumn<ClientFX, String> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(50);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ageCol.setOnEditCommit(
                event -> event.getRowValue().setAge(event.getNewValue())
        );
        columns.add(ageCol);
    }
}
