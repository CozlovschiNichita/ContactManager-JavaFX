package com.example.contact.controller;

import com.example.contact.model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML private TableView<Contact> table;
    @FXML private TableColumn<Contact, String> nameCol, phoneCol, emailCol, companyCol, positionCol;
    @FXML private TextField searchField;

    private final ObservableList<Contact> masterList = FXCollections.observableArrayList(
        new Contact("Анна", "+373 79 000 001", "anna@example.com", "Apple", "Designer"),
        new Contact("Иван", "+373 79 000 002", "ivan@example.com", "Google", "Developer")
    );

    private final FilteredList<Contact> filteredList = new FilteredList<>(masterList, p -> true);

    @FXML
    private void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        companyCol.setCellValueFactory(new PropertyValueFactory<>("company"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        table.setItems(filteredList);

        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            filteredList.setPredicate(contact -> {
                if (newVal == null || newVal.isBlank()) return true;
                String lower = newVal.toLowerCase();
                return contact.getName().toLowerCase().contains(lower) ||
                       contact.getPhone().toLowerCase().contains(lower) ||
                       contact.getEmail().toLowerCase().contains(lower) ||
                       contact.getCompany().toLowerCase().contains(lower) ||
                       contact.getPosition().toLowerCase().contains(lower);
            });
        });
    }

    @FXML
    private void onAdd() {
        ContactDialog.show(null).ifPresent(masterList::add);
    }

    @FXML
    private void onEdit() {
        Contact selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            ContactDialog.show(selected);
            table.refresh();
        }
    }

    @FXML
    private void onDelete() {
        Contact selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            masterList.remove(selected);
        }
    }

    @FXML
    private void onSearchClear() {
        searchField.clear();
    }
}