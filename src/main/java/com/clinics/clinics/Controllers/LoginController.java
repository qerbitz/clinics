package com.clinics.clinics.Controllers;

import com.clinics.clinics.SceneManager;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

@Controller
public class LoginController {

    @FXML
    private TextField textfield_login;


    @FXML
    private PasswordField textfield_password;

    @FXML
    void loginButton(ActionEvent event){
        if(textfield_login.getText().equals("") && textfield_password.getText().equals("")){
            SceneManager.renderScene("specializationController");
        }
        else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Wprowadzone dane są nieprawidłowe");
            error.setTitle("Błąd danych");
            error.setHeaderText("Błąd autoryzacji");
            error.show();
        }

    }
}
