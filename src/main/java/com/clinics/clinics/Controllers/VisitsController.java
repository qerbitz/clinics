package com.clinics.clinics.Controllers;

import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.Adress;
import com.clinics.clinics.entity.helpclasses.VisitsCount;
import com.clinics.clinics.service.interf.AdressService;
import com.clinics.clinics.service.interf.VisitsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class VisitsController {

    @FXML
    private TableView<VisitsCount> tbl;

    @FXML
    private TableColumn<VisitsCount, String> column_place;

    @FXML
    private TableColumn<VisitsCount, String> column_street;

    @FXML
    private TableColumn<VisitsCount, String> column_count;

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

    ObservableList<VisitsCount> observableListVisits = FXCollections.observableArrayList();
    ObservableList<String> voievodships = FXCollections.observableArrayList();
    ObservableList<Adress> places = FXCollections.observableArrayList();

    public ObservableList<VisitsCount> getObservableListAllVisits(){
        List<VisitsCount> visitsList = visitsService.getVisitsCountByRegion();
        this.observableListVisits.addAll(visitsList);
        return this.observableListVisits;
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
        image_apriori.setImage(new Image(file2.toURI().toString()));

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

        image_apriori.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SceneManager.addScene("aprioriController", "FXML/Weka.fxml");
                SceneManager.renderScene("aprioriController");
                event.consume();
            }
        });
    }

    public Date convertDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    @FXML
    void show_filtered(ActionEvent event) throws ParseException {

        List<VisitsCount> filtered_list;

        if(choice_place.getValue() == null){
            filtered_list = visitsService.getVisitsCountByRegion(convertDate(date_from.getValue()), convertDate(date_to.getValue()), "","");
        }
        else{
            filtered_list = visitsService.getVisitsCountByRegion(convertDate(date_from.getValue()), convertDate(date_to.getValue()),
                    choice_place.getSelectionModel().getSelectedItem().getPlace(), choice_place.getSelectionModel().getSelectedItem().getStreet());
        }

        observableListVisits.clear();
        observableListVisits.addAll(filtered_list);

        column_place.setCellValueFactory(new PropertyValueFactory<>("place"));
        column_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("count"));
        tbl.getColumns().clear();

        tbl.setItems(observableListVisits);
        tbl.getColumns().addAll(column_place, column_street, column_count);


    }

    @FXML
    void choice_place_action(ActionEvent event) throws ParseException {

        List<VisitsCount> filtered_list;

        if(date_from.getValue() == null || date_to.getValue() == null){
            LocalDate date1 = LocalDate.of(2010, 1, 1);
            LocalDate date2 = LocalDate.of(2030, 1, 1);
            filtered_list = visitsService.getVisitsCountByRegion(convertDate(date1), convertDate(date2),
                    choice_place.getSelectionModel().getSelectedItem().getPlace(), choice_place.getSelectionModel().getSelectedItem().getStreet());
        }
        else{
            filtered_list = visitsService.getVisitsCountByRegion(convertDate(date_from.getValue()), convertDate(date_to.getValue()),
                    choice_place.getSelectionModel().getSelectedItem().getPlace(), choice_place.getSelectionModel().getSelectedItem().getStreet());
        }

        observableListVisits.clear();
        observableListVisits.addAll(filtered_list);

        column_place.setCellValueFactory(new PropertyValueFactory<>("place"));
        column_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("count"));
        tbl.getColumns().clear();
        tbl.setItems(observableListVisits);
        tbl.getColumns().addAll(column_place, column_street, column_count);
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


    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();
        visitsService = (VisitsService) springContext.getBean("visitsServiceImpl");
        adressService = (AdressService) springContext.getBean("adressServiceImpl");

        column_place.setCellValueFactory(new PropertyValueFactory<>("place"));
        column_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("count"));
        tbl.getColumns().clear();
        tbl.setItems(getObservableListAllVisits());
        tbl.getColumns().addAll(column_place, column_street, column_count);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        List<String> voievodship_list = adressService.getAllVoievodship();      //////////choicebox voievodship
        voievodships.addAll(voievodship_list);
        choice_voivodeship.setItems(voievodships);

        help();



    }
}
