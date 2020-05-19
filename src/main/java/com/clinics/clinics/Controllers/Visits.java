package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.Doctors;
import com.clinics.clinics.entity.Specialization;
import com.clinics.clinics.service.interf.DoctorsService;
import com.clinics.clinics.service.interf.SpecializationService;
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
public class Visits{


    public ObservableList<Specialization> getObservableListAllSpecialization(){
        List<Specialization> ordersList = specializationService.getAllSpecializations();
        this.observableListSpecialization.addAll(ordersList);
        return this.observableListSpecialization;
    }

    public ObservableList<Doctors> getObservableListAllDoctors(){
        List<Doctors> doctorsList = doctorsService.getAllDoctors();
        this.observableListDoctors.addAll(doctorsList);
        return this.observableListDoctors;
    }

    private SpecializationService specializationService;

    private DoctorsService doctorsService;

    ObservableList<Specialization> observableListSpecialization = FXCollections.observableArrayList();
    ObservableList<Doctors> observableListDoctors = FXCollections.observableArrayList();

    @FXML
    private ImageView xdd;

    @FXML
    private ImageView xdd1;

    @FXML
    private ImageView xdd2;

    @FXML
    private ImageView xdd3;

    @FXML
    private ImageView xdd4;

    @FXML
    private TableColumn<Doctors, String> column_name;

    @FXML
    private TableColumn<Doctors, String> column_surname;

    @FXML
    private TableColumn<Doctors, String> column_count;

    @FXML
    private TableView<Doctors> tbl;

    @FXML
    public void haHA(MouseEvent event) {
        System.out.println("xdddd");
    }

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();
        specializationService = (SpecializationService) springContext.getBean("specializationServiceImpl");
        doctorsService = (DoctorsService) springContext.getBean("doctorsServiceImpl");

        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tbl.getColumns().clear();
        tbl.setItems(getObservableListAllDoctors());
        tbl.getColumns().addAll(column_name, column_surname);

        File file = new File("D:\\Pobrane - chrome\\unnamed.png");
        Image image = new Image(file.toURI().toString());
        xdd.setImage(image);
        xdd1.setImage(image);
        xdd2.setImage(image);
        xdd3.setImage(image);
        xdd4.setImage(image);

        xdd.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("xdddd");
                //SceneManager.addScene("visits", "FXML/BorderPane1.fxml");
               // SceneManager.renderScene("visits");
                event.consume();
            }
        });

    }
}
