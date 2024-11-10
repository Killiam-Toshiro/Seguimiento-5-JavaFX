package com.icesi.classroom.control;

import com.icesi.classroom.ClassroomApplication;
import com.icesi.classroom.model.Browser;
import com.icesi.classroom.model.Career;
import com.icesi.classroom.model.Gender;
import com.icesi.classroom.model.StudentAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.time.LocalDate;

public class ViewController {

      @FXML
    private Button logOut;

    @FXML
    private ImageView studentProfilePic;

    @FXML
    private TableView<StudentAccount> studentsTable;

    @FXML
    private TableColumn<StudentAccount, String> nameColumn;

    @FXML
    private TableColumn<StudentAccount, Gender> genderColumn;

    @FXML
    private TableColumn<StudentAccount, Career> careerColumn;

    @FXML
    private TableColumn<StudentAccount, LocalDate> birthdateColumn;

    @FXML
    private TableColumn<StudentAccount, Browser> browserColumn;

    @FXML
    private void initialize(){
        ObservableList<StudentAccount> students = Classroom.getInstance().getStudents();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        careerColumn.setCellValueFactory(new PropertyValueFactory<>("career"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        browserColumn.setCellValueFactory(new PropertyValueFactory<>("browser"));

        studentsTable.setItems(students);
        // INICIALIZAR TABLE VIEW Y COLUMNAS
    }

    @FXML
    private void deleteStudent(ActionEvent event) {
    StudentAccount selectedStudent = studentsTable.getSelectionModel().getSelectedItem();
    
    if (selectedStudent == null) {
        return; // Si no tiene estudiantes selecionados termina el metodo
    }
    
    // Creamos dialogo de confirmacion
    Alert confirmationAlert = new Alert(Alert.AlertType.WARNING);
    confirmationAlert.setTitle("Eliminar Estudiante");
    confirmationAlert.setHeaderText("Confirmar eliminación");
    confirmationAlert.setContentText("¿Estás seguro de eliminar al estudiante " + selectedStudent.getUsername() + "?");
    
    // Mostrar dialogo de confirmacion
    confirmationAlert.showAndWait();
    
    // Verificamos confirmacion y eliminamos
    if (confirmationAlert.getResult() == ButtonType.OK) {
        Classroom.getInstance().getStudents().remove(selectedStudent);
    }
}


    @FXML
    private void logOut(ActionEvent event) {
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.close();
    }

    private void closeWindow(){
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.close();
    }
}
