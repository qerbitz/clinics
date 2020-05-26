package com.clinics.clinics.Controllers;

import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.helpclasses.Med_Res_Count;
import com.clinics.clinics.entity.helpclasses.SpecializationCount;
import com.clinics.clinics.entity.helpclasses.VisitsCount;
import com.clinics.clinics.service.interf.DoctorsService;
import com.clinics.clinics.service.interf.VisitsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;

import java.io.File;
import java.util.List;

@Controller
public class Med_ResController {

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
    private TableColumn<Med_Res_Count, String> column_place;

    @FXML
    private TableColumn<Med_Res_Count, String> column_street;

    @FXML
    private TableColumn<Med_Res_Count, String> column_count_med;

    @FXML
    private TableColumn<Med_Res_Count, String> column_count_res;

    @FXML
    private TableView<Med_Res_Count> tbl;

    private VisitsService visitsService;

    ObservableList<Med_Res_Count> observableListVisits = FXCollections.observableArrayList();
    ObservableList<String> values = FXCollections.observableArrayList("podkarpackie", "dolnoslaskie", "lubuskie", "lubelskie");

    public ObservableList<Med_Res_Count> getObservableListMed_Res_Count(){
        List<Med_Res_Count> visitsList = visitsService.getMed_Res_Count();
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

        column_place.setCellValueFactory(new PropertyValueFactory<>("place"));
        column_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        column_count_med.setCellValueFactory(new PropertyValueFactory<>("count_med"));
        column_count_res.setCellValueFactory(new PropertyValueFactory<>("count_res"));
        tbl.getColumns().clear();
        tbl.setItems(getObservableListMed_Res_Count());
        tbl.getColumns().addAll(column_place, column_street, column_count_med, column_count_res);

        help();

    }
}
