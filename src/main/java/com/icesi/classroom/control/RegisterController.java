package com.icesi.classroom.control;

import java.io.File;
import java.time.LocalDate;

import com.icesi.classroom.model.Browser;
import com.icesi.classroom.model.Career;
import com.icesi.classroom.model.Gender;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private BorderPane pane;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private Button browseProfilePictureButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private ChoiceBox<Browser> favBrowserMenu;

    @FXML
    private CheckBox femaleCheckBox;

    @FXML
    private CheckBox maleCheckbox;

    @FXML
    private CheckBox otherGenderCheckBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox systemsCareerCheckBox;

    @FXML
    private CheckBox telematicsCareerCheckBox;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField pathField;

    @FXML
    private Stage stage;

    @FXML
    private Alert alert;

    @FXML
    private void browseProfilePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            pathField.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void initialize(){
        stage = new Stage();
        ObservableList<Browser> options = FXCollections.observableArrayList(Browser.values());
        favBrowserMenu.setItems(options);
        
    }

    @FXML
    private void createStudentAccount(ActionEvent event) {
        String username = userNameField.getText();
        String password = passwordField.getText();
        System.out.println(pathField.getText());
        Image image = new Image( "file:"+pathField.getText() );
        Gender gender = null;
        if (maleCheckbox.isSelected()) {
            gender = Gender.Male;
        } else if (femaleCheckBox.isSelected()) {
            gender = Gender.Female;
        } else {
            gender = Gender.Other;
        }
        Career career = null;
        if (systemsCareerCheckBox.isSelected()) {
            career = Career.SystemsEngineering;
        } else {
            career = Career.TelematicsEngineering;
        }
        LocalDate birthdate = birthDatePicker.getValue();
        Browser browser = favBrowserMenu.getValue();

        if (username.isEmpty() || password.isEmpty() || image == null || gender == null || career == null || browser == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al crear cuenta");
            alert.setHeaderText("Datos incompletos");
            alert.setContentText("Por favor, completar las casillas vacias.");
            alert.showAndWait();
            return;
        }

        Classroom.getInstance().addStudent(username, password, image, gender, career, birthdate, browser);
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Cuenta creada!!");
        successAlert.setHeaderText("Success");
        successAlert.setContentText("Estudiante registrado satisfactoriamente!!");
        successAlert.showAndWait();

        clearForm();

        closeWindow();
    }

    @FXML
    private void returnToLogInView(ActionEvent event) {
        closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) browseProfilePictureButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clearForm() {
        userNameField.clear();
        passwordField.clear();
        pathField.clear();
        birthDatePicker.setValue(null);
        favBrowserMenu.setValue(null);
        maleCheckbox.setSelected(false);
        femaleCheckBox.setSelected(false);
        otherGenderCheckBox.setSelected(false);
        systemsCareerCheckBox.setSelected(false);
        telematicsCareerCheckBox.setSelected(false);
    }
}