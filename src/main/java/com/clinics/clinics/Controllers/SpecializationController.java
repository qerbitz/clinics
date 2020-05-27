package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.helpclasses.SpecializationCount;
import com.clinics.clinics.service.interf.DoctorsService;
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
public class SpecializationController {

    public ObservableList<SpecializationCount> getObservableListAllSpecialization(){
        List<SpecializationCount> specializationList = doctorsService.getSpecializationCount();
        this.observableListSpecialization.addAll(specializationList);
        return this.observableListSpecialization;
    }

    private DoctorsService doctorsService;

    ObservableList<SpecializationCount> observableListSpecialization = FXCollections.observableArrayList();

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
    private TableColumn<SpecializationCount, String> column_name;

    @FXML
    private TableColumn<SpecializationCount, String> column_surname;

    @FXML
    private TableColumn<SpecializationCount, String> column_count;

    @FXML
    private TableView<SpecializationCount> tbl;

    @FXML
    public void haHA(MouseEvent event) {
        System.out.println("xdddd");
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
        doctorsService = (DoctorsService) springContext.getBean("doctorsServiceImpl");

        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        column_count.setCellValueFactory(new PropertyValueFactory<>("count"));
        tbl.getColumns().clear();
        tbl.setItems(getObservableListAllSpecialization());
        tbl.getColumns().addAll(column_name, column_surname, column_count);

        help();
    }
}
