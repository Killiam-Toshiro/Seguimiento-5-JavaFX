package com.icesi.classroom.control;

import com.icesi.classroom.ClassroomApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController {

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField userNameField;

    @FXML
    private Alert alert;

    @FXML
    private void initialize(){
        alert = new Alert(Alert.AlertType.NONE);
    }

    @FXML
    public void logIn(ActionEvent event) {
        String username = userNameField.getText();
        String password = passwordField.getText();

        if(Classroom.getInstance().logIn(username,password)) {
            ClassroomApplication.openWindow("/view.fxml");
        }
    }

    @FXML
    public void signUp(ActionEvent event) {

        ClassroomApplication.openWindow("/register.fxml");
    }

}
