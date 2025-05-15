package com.example.contact.controller;

import com.example.contact.model.Contact;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import java.util.Optional;

public class ContactDialog {

    @FXML private TextField name, phone, email, company, position;

    public static Optional<Contact> show(Contact original) {
        try {
            FXMLLoader loader = new FXMLLoader(ContactDialog.class.getResource("/com/example/contact/ContactDialog.fxml"));
            Parent root = loader.load();
            ContactDialog controller = loader.getController();

            Dialog<Contact> dialog = new Dialog<>();
            dialog.setTitle("Контакт");
            dialog.getDialogPane().setContent(root);
            dialog.getDialogPane().getButtonTypes().addAll(
                new ButtonType("OK", ButtonBar.ButtonData.OK_DONE),
                ButtonType.CANCEL
            );

            if (original != null) {
                controller.name.setText(original.getName());
                controller.phone.setText(original.getPhone());
                controller.email.setText(original.getEmail());
                controller.company.setText(original.getCompany());
                controller.position.setText(original.getPosition());
            } else {
                controller.name.clear();
                controller.phone.clear();
                controller.email.clear();
                controller.company.clear();
                controller.position.clear();
            }

            dialog.setResultConverter(bt -> {
                if (bt.getButtonData() != ButtonBar.ButtonData.OK_DONE) return null;

                Contact c = (original != null) ? original : new Contact();
                c.setName(controller.name.getText());
                c.setPhone(controller.phone.getText());
                c.setEmail(controller.email.getText());
                c.setCompany(controller.company.getText());
                c.setPosition(controller.position.getText());
                return c;
            });

            return dialog.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}