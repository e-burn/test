package dataManagment.controllers;

import data.UserInfo;
import data.controller.UserInfoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LoginController extends Application implements IDataManagmentController {


    public static void signUp() {
        Application.launch();
    }
    private File userInfoFile_;

    public void start(Stage primaryStage) throws IOException {
        Pane mainPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("signUp.fxml"));
        primaryStage.setScene(new Scene(mainPane));
        //login =  loginInputField.getText();
        //createUserInfo
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public UserInfo createUserInfo (String login) throws IOException {
        UserInfo userInfo = new UserInfo(login);
        return userInfo;
    }

    /*public boolean validationRequest (UserInfo userInfo) {

        return false;
    }*/

    public void saveUserInfo (UserInfo userInfo)
    {
        String pathToFile = PropertiesController.getProperty("PATH_TO_SERIALIZED_DATA");
        userInfoFile_ = new File(pathToFile);
        UserInfoController.saveUserInfoToFile(userInfo, userInfoFile_);
    }
}
