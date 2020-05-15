package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.entity.Specjalizacje;
import com.clinics.clinics.service.interf.SpecializationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;

import java.util.List;


@Controller
public class Visits{

    ObservableList<Specjalizacje> observableListSpecialization = FXCollections.observableArrayList();

    public ObservableList<Specjalizacje> getObservableListAllSpecialization(){
        List<Specjalizacje> ordersList = specializationService.getAllSpecializations();
        this.observableListSpecialization.addAll(ordersList);
        return this.observableListSpecialization;
    }

    private SpecializationService specializationService;

    @FXML
    private TableColumn<Specjalizacje, String> column1;

    @FXML
    private TableColumn<Specjalizacje, String> column2;

    @FXML
    private TableView<Specjalizacje> tbl;

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();
        specializationService = (SpecializationService) springContext.getBean("specializationServiceImpl");

        //column1.setCellFactory(new PropertyValueFactory<>("id_specjalizacji"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        tbl.setItems(getObservableListAllSpecialization());
        tbl.getColumns().clear();
        tbl.getColumns().addAll(column2);
    }
}
