package com.example.contact;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            long t1 = System.currentTimeMillis();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/contact/MainView.fxml"));
            Parent root = loader.load();

            long t2 = System.currentTimeMillis();
            System.out.println("⏱️ MainView.fxml loaded in: " + (t2 - t1) + " ms");

            stage.setTitle("Контакт-менеджер");
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("🚀 Stage is shown!");
        } catch (Exception e) {
            System.err.println("❌ Ошибка при запуске приложения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
