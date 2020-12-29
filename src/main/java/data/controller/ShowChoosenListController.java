package data.controller;

import consts.ListID;
import data.ListOfFilms;
import data.UserInfo;
import dataManagment.controllers.PropertiesController;

import java.io.File;
import java.io.IOException;

public class ShowChoosenListController
{
    public static void showChoosenList(ListID listID) throws IOException {
        String pathToFile = PropertiesController.getProperty("PATH_TO_SERIALIZED_DATA");
        File userInfoFile = new File(pathToFile);
        UserInfo userInfo = UserInfoController.getUserInfoFromFile(userInfoFile);
        ListOfFilms list = userInfo.getFilmList(listID);
        //list.showFilms();
    }
}
