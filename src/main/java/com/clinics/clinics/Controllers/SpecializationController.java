package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.Doctors;
import com.clinics.clinics.entity.Specialization;
import com.clinics.clinics.entity.helpclasses.SpecializationCount;
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
public class SpecializationController {


    public ObservableList<SpecializationCount> getObservableListAllSpecialization(){
        List<SpecializationCount> specializationList = doctorsService.getSpecializationCount();
        this.observableListSpecialization.addAll(specializationList);
        return this.observableListSpecialization;
    }

    private DoctorsService doctorsService;

    ObservableList<SpecializationCount> observableListSpecialization = FXCollections.observableArrayList();

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
