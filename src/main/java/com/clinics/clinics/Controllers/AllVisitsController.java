package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.Visits;
import com.clinics.clinics.service.interf.VisitsService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AllVisitsController {

    @FXML
    private TableView tbl;

    @FXML
    private TableColumn<Visits, String> column_patient;

    @FXML
    private TableColumn<Visits, String> column_doctor;

    @FXML
    private TableColumn<Visits, String> column_diagnose;

    @FXML
    private TableColumn<Visits, String> column_date;

    @FXML
    private ImageView image_visits;

    @FXML
    private ImageView image_specialization;

    @FXML
    private ImageView image_med;

    @FXML
    private ImageView image_visits_all;

    @FXML
    private ImageView xdd4;

    @FXML
    private DatePicker date_to;

    @FXML
    private DatePicker date_from;


    @FXML
    private ComboBox<String> choice_region;

    private VisitsService visitsService;

    ObservableList<Visits> observableListVisits = FXCollections.observableArrayList();
    ObservableList<String> values = FXCollections.observableArrayList("podkarpackie", "dolnoslaskie", "lubuskie", "lubelskie");

    public ObservableList<Visits> getObservableListAllVisits(){
        List<Visits> visitsList = visitsService.getVisitsByTime();
        this.observableListVisits.addAll(visitsList);
        return this.observableListVisits;
    }

    @FXML
    void show_filtered(ActionEvent event) {
        System.out.println(date_from.getValue());
    }

    public void help(){
        File file1 = new File("D:\\Pobrane - chrome\\unnamed.png");
        File file2 = new File("D:\\Pobrane - chrome\\Specjalizacje.png");
        File file3 = new File("D:\\Pobrane - chrome\\Badania_leki.png");
        File file4 = new File("D:\\Pobrane - chrome\\Specjalizacje.png");
        File file5 = new File("D:\\Pobrane - chrome\\Specjalizacje.png");

        image_visits.setImage(new Image(file1.toURI().toString()));
        image_specialization.setImage(new Image(file2.toURI().toString()));
        image_med.setImage(new Image(file3.toURI().toString()));
        image_visits_all.setImage(new Image(file2.toURI().toString()));
        xdd4.setImage(new Image(file2.toURI().toString()));

        image_specialization.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.addScene("specializationController", "FXML/BorderPane.fxml");
                SceneManager.renderScene("specializationController");
                event.consume();
            }
        });

        image_med.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.addScene("med_ResController", "FXML/BorderPane3.fxml");
                SceneManager.renderScene("med_ResController");
                event.consume();
            }
        });

        image_visits.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.addScene("visitsController", "FXML/BorderPane2.fxml");
                SceneManager.renderScene("visitsController");
                event.consume();
            }
        });

        image_visits_all.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.addScene("allVisitsController", "FXML/BorderPane4.fxml");
                SceneManager.renderScene("allVisitsController");
                event.consume();
            }
        });
    }

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();

        visitsService = (VisitsService) springContext.getBean("visitsServiceImpl");
       // choice_region.setItems(values);
        column_patient.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_patient().getName()+" "+help.getValue().getId_patient().getSurname()));
        column_doctor.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_doctor().getName()+" "+help.getValue().getId_doctor().getSurname()));
        column_diagnose.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_diagnosis().getName()));
        column_date.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_deadline().getDate().toString()));
        tbl.getColumns().clear();
        tbl.setItems(getObservableListAllVisits());
        tbl.getColumns().addAll(column_patient, column_doctor, column_diagnose, column_date);


        help();
    }

}
