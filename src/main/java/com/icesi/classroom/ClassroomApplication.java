package com.icesi.classroom;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassroomApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openWindow("/login.fxml");
    }

    public static void openWindow(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ClassroomApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Classroom LogIn View");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}