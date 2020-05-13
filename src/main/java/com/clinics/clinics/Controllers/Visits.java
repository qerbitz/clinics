package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;

@Controller
public class Visits{

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();


    }
}
