package com.clinics.clinics.Controllers;

import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.helpclasses.SpecializationCount;
import com.clinics.clinics.entity.helpclasses.VisitsCount;
import com.clinics.clinics.service.interf.VisitsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.File;
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
    private ImageView xdd3;

    @FXML
    private ImageView xdd4;

    @FXML
    private ComboBox<String> choice_region;

    private VisitsService visitsService;

    ObservableList<VisitsCount> observableListVisits = FXCollections.observableArrayList();
    ObservableList<String> values = FXCollections.observableArrayList("podkarpackie", "dolnoslaskie", "lubuskie", "lubelskie");

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
        xdd3.setImage(new Image(file2.toURI().toString()));
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
    }

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();
        visitsService = (VisitsService) springContext.getBean("visitsServiceImpl");
        choice_region.setItems(values);

        column_place.setCellValueFactory(new PropertyValueFactory<>("place"));
        column_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("count"));
        tbl.getColumns().clear();
        tbl.setItems(getObservableListAllVisits());
        tbl.getColumns().addAll(column_place, column_street, column_count);

        help();

    }
}