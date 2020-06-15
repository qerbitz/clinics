package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.*;
import com.clinics.clinics.entity.helpclasses.Details;
import com.clinics.clinics.service.interf.AdressService;
import com.clinics.clinics.service.interf.VisitsService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AllVisitsController {

    @FXML
    private TableView<Visits> tbl;

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
    private ImageView image_apriori;

    @FXML
    private DatePicker date_to;

    @FXML
    private DatePicker date_from;

    @FXML
    private ComboBox<String> choice_voivodeship;

    @FXML
    private ComboBox<Adress> choice_place;

    private VisitsService visitsService;
    private AdressService adressService;

    ObservableList<Visits> observableListVisits = FXCollections.observableArrayList();
    ObservableList<String> voievodships = FXCollections.observableArrayList();
    ObservableList<Adress> places = FXCollections.observableArrayList();

    public ObservableList<Visits> getObservableListAllVisits(){
        List<Visits> visitsList = visitsService.getVisitsByTime();
        this.observableListVisits.addAll(visitsList);
        return this.observableListVisits;
    }

    public Date convertDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    @FXML
    void show_filtered(ActionEvent event) throws ParseException {

        List<Visits> allVisitsList;

        if(choice_place.getValue() == null){
            allVisitsList = visitsService.getVisitsByDate(convertDate(date_from.getValue()), convertDate(date_to.getValue()), "","");
        }
        else{
            allVisitsList = visitsService.getVisitsByDate(convertDate(date_from.getValue()), convertDate(date_to.getValue()),
                    choice_place.getSelectionModel().getSelectedItem().getPlace(), choice_place.getSelectionModel().getSelectedItem().getStreet());
        }

        observableListVisits.clear();
        observableListVisits.addAll(allVisitsList);

        show_table_and_choicebox();
        tbl.setItems(observableListVisits);
        tbl.getColumns().addAll(column_patient, column_doctor, column_diagnose, column_date);
    }

    @FXML
    void choice_place_action(ActionEvent event) throws ParseException {

        List<Visits> filtered_list;

        if(date_from.getValue() == null || date_to.getValue() == null){
            LocalDate date1 = LocalDate.of(2010, 1, 1);
            LocalDate date2 = LocalDate.of(2030, 1, 1);
            filtered_list = visitsService.getVisitsByDate(convertDate(date1), convertDate(date2),
                    choice_place.getSelectionModel().getSelectedItem().getPlace(), choice_place.getSelectionModel().getSelectedItem().getStreet());
        }
        else{
            filtered_list = visitsService.getVisitsByDate(convertDate(date_from.getValue()), convertDate(date_to.getValue()),
                    choice_place.getSelectionModel().getSelectedItem().getPlace(), choice_place.getSelectionModel().getSelectedItem().getStreet());
        }

        observableListVisits.clear();
        observableListVisits.addAll(filtered_list);
        show_table_and_choicebox();
        tbl.setItems(observableListVisits);
        tbl.getColumns().addAll(column_patient, column_doctor, column_diagnose, column_date);
    }

    @FXML
    void choice_voievodship_action(ActionEvent event){

        places.clear();
        choice_place.getItems().clear();

        List<Adress> places_list = adressService.getAllPlaces(choice_voivodeship.getSelectionModel().getSelectedItem());
        places.addAll(places_list);
        choice_place.setItems(places);

        choice_place.setConverter(new StringConverter<Adress>() {
            @Override
            public String toString(Adress object) {
                return object.getPlace() + " " + object.getStreet() + " " + object.getNr_house();
            }

            @Override
            public Adress fromString(String string) {
                return null;
            }

        });
    }

    public void help(){
        File file1 = new File("D:\\Pobrane - chrome\\unnamed.png");
        File file2 = new File("D:\\Pobrane - chrome\\Specjalizacje.png");
        File file3 = new File("D:\\Pobrane - chrome\\Badania_leki.png");
        File file4 = new File("D:\\Pobrane - chrome\\liczba.png");
        File file5 = new File("D:\\Pobrane - chrome\\apriori.png");

        image_visits.setImage(new Image(file4.toURI().toString()));
        image_specialization.setImage(new Image(file2.toURI().toString()));
        image_med.setImage(new Image(file3.toURI().toString()));
        image_visits_all.setImage(new Image(file1.toURI().toString()));
        image_apriori.setImage(new Image(file5.toURI().toString()));

        image_specialization.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.renderScene("specializationController");
                event.consume();
            }
        });

        image_med.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.renderScene("med_ResController");
                event.consume();
            }
        });

        image_visits.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.renderScene("visitsController");
                event.consume();
            }
        });

        image_visits_all.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.renderScene("allVisitsController");
                event.consume();
            }
        });

        image_apriori.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.renderScene("aprioriController");
                event.consume();
            }
        });
    }

    public void show_table_and_choicebox(){
        column_patient.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_patient().getName()+" "+help.getValue().getId_patient().getSurname()));
        column_doctor.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_doctor().getName()+" "+help.getValue().getId_doctor().getSurname()));
        column_diagnose.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_diagnosis().getName()));
        column_date.setCellValueFactory(help -> new SimpleStringProperty(help.getValue().getId_deadline().getDate().toString()));

        tbl.getColumns().clear();
    }

    @FXML
    void pressButton(ActionEvent event){

        int id_visit = tbl.getSelectionModel().getSelectedItem().getId_visit();

        List<Details> listka = visitsService.getDetailsInfo(id_visit);


        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setContentText(listka.toString());
        alert.setTitle("Szczegoly wizyty");
        alert.setHeaderText(null);
        ButtonType cancelButtonType = new ButtonType("Wyjdz", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(cancelButtonType);
        alert.showAndWait();
    }


    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();

        visitsService = (VisitsService) springContext.getBean("visitsServiceImpl");
        adressService = (AdressService) springContext.getBean("adressServiceImpl");

        show_table_and_choicebox();
        tbl.setItems(getObservableListAllVisits());
        tbl.getColumns().addAll(column_patient, column_doctor, column_diagnose, column_date);


        List<String> voievodship_list = adressService.getAllVoievodship();      //////////choicebox voievodship
        voievodships.addAll(voievodship_list);
        choice_voivodeship.setItems(voievodships);


        help();

    }

}
