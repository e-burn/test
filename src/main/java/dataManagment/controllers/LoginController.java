package dataManagment.controllers;

import data.UserInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends Application {


    public static void main() {
        Application.launch();
    }


    public void start(Stage primaryStage) throws IOException {
        Pane mainPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("signUp.fxml"));
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public UserInfo createUserInfo (String login) {

        return null;
    }

    public boolean validationRequest (UserInfo userInfo) {

        return false;
    }

    public void saveUserInfo (UserInfo userInfo) {

    }
}
