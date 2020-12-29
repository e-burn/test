package data.controller;

import data.Personalization;
import data.PropertiesGetter;
import data.UserInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StartController extends Application {

    private UserInfo userInfo = UserInfo.getInstance();
    private Personalization personalization = Personalization.getInstance();

    public StartController() throws IOException {
    }

    public static void main() {
        Application.launch();
    }

    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        PropertiesGetter properties = new PropertiesGetter();
        String pathToFile = properties.getProperty("PATH_TO_SERIALIZED_DATA");

        File userInfoFile = new File(pathToFile);


        //start signUp or startWindow
        if (0 == userInfoFile.length()) {
            Pane mainPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("signUp.fxml"));
            primaryStage.setScene(new Scene(mainPane));
            primaryStage.setResizable(false);
            primaryStage.show();
        } else {
            //Десериализация
            //______________________________________
            FileInputStream fileInputStream = new FileInputStream(userInfoFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            UserInfo serUserInfo = (UserInfo) objectInputStream.readObject();
            userInfo.setLogin(serUserInfo.getLogin());
            personalization = serUserInfo.getPersonalization();
            userInfo.setPersonalization(personalization);
            //______________________________________
            SplitPane mainPane = (SplitPane) FXMLLoader.load(getClass().getClassLoader().getResource("startWindow.fxml"));
            mainPane.setStyle(userInfo.getPersonalization().getBackgroundColor());
            System.out.println(userInfo.getLogin());

            primaryStage.setScene(new Scene(mainPane));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }
}




