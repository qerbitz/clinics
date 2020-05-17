package com.clinics.clinics.Controllers;


import com.clinics.clinics.ClinicsApplication;
import com.clinics.clinics.SceneManager;
import com.clinics.clinics.entity.Specialization;
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

    ObservableList<Specialization> observableListSpecialization = FXCollections.observableArrayList();

    public ObservableList<Specialization> getObservableListAllSpecialization(){
        List<Specialization> ordersList = specializationService.getAllSpecializations();
        this.observableListSpecialization.addAll(ordersList);
        return this.observableListSpecialization;
    }

    private SpecializationService specializationService;

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
    private TableColumn<Specialization, String> column1;

    @FXML
    private TableColumn<Specialization, String> column2;

    @FXML
    private TableView<Specialization> tbl;

    @FXML
    public void haHA(MouseEvent event) {
        System.out.println("xdddd");
    }

    @FXML
    void initialize() {
        ConfigurableApplicationContext springContext = ClinicsApplication.getSpringContext();
        specializationService = (SpecializationService) springContext.getBean("specializationServiceImpl");

        column1.setCellValueFactory(new PropertyValueFactory<>("id_specjalizacji"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        tbl.setItems(getObservableListAllSpecialization());
        tbl.getColumns().clear();
        tbl.getColumns().addAll(column1, column2);

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
                System.out.println("Tile pressed xddd ");
                SceneManager.addScene("visits", "FXML/BorderPane1.fxml");
                SceneManager.renderScene("visits");
                event.consume();
            }
        });

    }
}
