package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import javafx.fxml.FXML;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class MenuPageController {


    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();
    }

}
