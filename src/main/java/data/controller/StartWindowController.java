package data.controller;

import dataManagment.controllers.LoginController;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StartWindowController  {

    FileInputStream fis;
    Properties property;

    public StartWindowController () {

    }

    public void checkUserInfo() throws IOException {
        try {
            fis = new FileInputStream("src\\main\\resources\\config.properties");
            property = new Properties();
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathToFile = property.getProperty("PATH_TO_SERIALIZED_DATA");

        File userInfoFile = new File(pathToFile);

        if (0 == userInfoFile.length()) {
            LoginController loginController = new LoginController();
            loginController.main();
        }
    }
}




