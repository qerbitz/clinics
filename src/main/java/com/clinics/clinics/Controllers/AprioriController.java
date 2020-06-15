package com.clinics.clinics.Controllers;

import com.clinics.clinics.SceneManager;
import com.clinics.clinics.Weka.BasicTools;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Controller;
import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;
import weka.associations.Item;
import weka.core.Instances;
import weka.core.Utils;

import java.io.File;
import javafx.scene.control.TextField;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
    private TextField tekscior;

    @FXML
    private TextField text_field_diagnose;

    StringBuilder recommendedMedicine = new StringBuilder();

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

    public void regulyAsocjacyjne(String diagnose) throws Exception {


        Instances data = BasicTools.loadData("F:\\Programowanie\\clinics\\src\\main\\java\\com\\clinics\\clinics\\Weka\\Apriori.arff");
       // Instances data = BasicTools.loadData("./src/main/java/com/clinics/Weka/Apriori.arff");
        data.setClassIndex(data.numAttributes() - 1);

        //Opcje liczenia regul asocjacyjnych
        //-N ->Liczba regul do policzenia (standardowo: 10)
        //-C ->Minmalna ufnosc reguly (standardowo: 0.9).
        String[] options = Utils.splitOptions("-N 20 -C 0.6");
        Apriori apriori = new Apriori();
        apriori.setOptions(options);
        apriori.buildAssociations(data); //Generowanie regul asocjacyjnych

        System.out.println("Liczba regul=" + apriori.getNumRules());

        AssociationRules rules = apriori.getAssociationRules();
        List<AssociationRule> ruleList  = rules.getRules();

        for (int i=0; i<ruleList.size(); i++)
        {
            AssociationRule rule = ruleList.get(i); //Pobranie pojedynczej reguly

            //Pobranie opisu poprzednika reguly
            Collection<Item> poprzednik = rule.getPremise();
            Iterator<Item> iteratorPoprzednik = poprzednik.iterator();
            String poprzednikText = new String();
            while (iteratorPoprzednik.hasNext())
            {
                poprzednikText = poprzednikText + "("+iteratorPoprzednik.next().toString()+")";
                if (iteratorPoprzednik.hasNext()) poprzednikText = poprzednikText +"&";
            }

            //Pobranie opisu nastepnika reguly
            Collection<Item> nastepnik = rule.getConsequence();
            Iterator<Item> iteratorNastepnik = nastepnik.iterator();
            String nastepnikText = new String();
            while (iteratorNastepnik.hasNext())
            {
                nastepnikText = nastepnikText + "("+iteratorNastepnik.next().toString()+")";
                if (iteratorNastepnik.hasNext()) nastepnikText = nastepnikText +"&";
            }


            //Pobranie wsparcie i obliczenia ufnosci
            int wsparciePoprzednika = rule.getPremiseSupport();
            int wsparcieCalosci = rule.getTotalSupport();
            double ufnosc = (double)wsparcieCalosci/wsparciePoprzednika;

            /*

            System.out.print(poprzednikText+"=>"+nastepnikText+", ");
            System.out.print("Wsparcie:"+wsparcieCalosci+", ");
            System.out.println("Ufnosc:"+ufnosc);*/

            String xd2 = rule.getConsequence().toString();
            if(xd2.equals("[diagnoza="+ diagnose +"]")){
                recommendedMedicine.append(poprzednikText);
                recommendedMedicine.append("=>");
                recommendedMedicine.append(nastepnikText);
                recommendedMedicine.append(", ");
                recommendedMedicine.append("Wsparcie:");
                recommendedMedicine.append(wsparcieCalosci);
                recommendedMedicine.append(", ");
                recommendedMedicine.append("Ufnosc:");
                recommendedMedicine.append(ufnosc);
                recommendedMedicine.append("\n");
             }




        }
        tekscior.setText(recommendedMedicine.toString());

    }

    @FXML
    void akcja(ActionEvent event) throws Exception {

        tekscior.clear();
        regulyAsocjacyjne(text_field_diagnose.getText());
        text_field_diagnose.clear();
    }

    @FXML
    void initialize() throws Exception {

        help();


    }
}

