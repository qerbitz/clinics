package com.clinics.clinics.Controllers;

import com.clinics.clinics.SceneManager;
import com.clinics.clinics.Weka.BasicTools;
import com.clinics.clinics.Weka.SQLDataImporter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Controller;
import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.Utils;

import java.awt.*;
import java.io.File;

@Controller
public class AprioriController {


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
    private TextArea associationData;

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

    @FXML
    void initialize() {

        try {
            String username = "postgres";
            String password = "zaq1@WSX";

            String query =
                    "SELECT STRING_AGG(UH.USLUG_NAZWA, ', ')\n" +
                            "FROM USLUGI_HOTELOWE UH\n" +
                            "JOIN UZYTE_USLUGI UU ON UH.USLUG_ID = UU.USLUG_ID\n" +
                            "JOIN REZERWACJE R ON UU.REZ_ID = R.REZ_ID\n" +
                            "JOIN GOSCIE G ON R.GOSC_ID = G.GOSC_ID\n" +
                            "GROUP BY UU.REZ_ID\n" +
                            "ORDER BY UU.REZ_ID";

            String query1 = "SELECT l.nazwa_leku FROM leki l;";

            Instances data = SQLDataImporter.getDataSetFromPostgreSQL(username, password, query1, 0);
            String fileName = "F:\\Programowanie\\clinics\\src\\main\\java\\com\\clinics\\clinics\\Weka\\Apriori.arff"; //Lokalizacja pliku z danymi
            BasicTools.saveData(data, fileName); //Zapis tablicy do pliku w fromacie ARFF
            BasicTools.processToApriori(data);
            data = BasicTools.loadData(fileName);
            data.setClassIndex(data.numAttributes() - 1);

            //String set = "-N " + minRules.getText() + " -C " + minMetric.getText() + " -M " + minSupp;
            String[] options = Utils.splitOptions("-N 10 -C 0.2 -M 0.05");
            Apriori apriori = new Apriori();
            apriori.setOptions(options);
            apriori.buildAssociations(data);


            associationData.setText(apriori.toString());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        help();
    }
}

