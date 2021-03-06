package com.clinics.clinics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ClinicsApplication extends Application {
	private static ConfigurableApplicationContext springContext;
	private FXMLLoader fxmlLoader;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(ClinicsApplication.class);
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(springContext::getBean);
	}

	public static ConfigurableApplicationContext getSpringContext() {
		return springContext;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneManager.setStage(primaryStage);
		SceneManager.addScene("med_ResController", "FXML/BorderPane3.fxml");
		SceneManager.addScene("visitsController", "FXML/BorderPane2.fxml");
		SceneManager.addScene("specializationController", "FXML/BorderPane.fxml");
		SceneManager.addScene("allVisitsController", "FXML/BorderPane4.fxml");
		SceneManager.addScene("aprioriController", "FXML/Weka.fxml");
		SceneManager.addScene("loginController", "FXML/LoginPane.fxml");
		SceneManager.renderScene("loginController");
	}

	@Override
	public void stop() {
		springContext.close();
	}
}