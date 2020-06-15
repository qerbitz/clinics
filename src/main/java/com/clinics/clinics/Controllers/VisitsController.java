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
    private ComboBox<String> choice_voivodeship;


    private VisitsService visitsService;
    private AdressService adressService;

    ObservableList<VisitsCount> observableListVisits = FXCollections.observableArrayList();
    ObservableList<String> voievodships = FXCollections.observableArrayList();
    ObservableList<VisitsCount> places = FXCollections.observableArrayList();

    public ObservableList<VisitsCount> getObservableListAllVisits(){
        List<VisitsCount> visitsList = visitsService.getVisitsCountByRegion();
        this.observableListVisits.addAll(visitsList);
        return this.observableListVisits;
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


    @FXML
    void choice_voievodship_action(ActionEvent event){
        places.clear();

        List<VisitsCount> places_list = visitsService.getVisitsCountByRegions(choice_voivodeship.getSelectionModel().getSelectedItem());
        places.addAll(places_list);

        observableListVisits.clear();
        observableListVisits.addAll(places_list);
        column_place.setCellValueFactory(new PropertyValueFactory<>("place"));
        column_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("count"));
        tbl.getColumns().clear();
        tbl.setItems(places);
        tbl.getColumns().addAll(column_place, column_street, column_count);;
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
