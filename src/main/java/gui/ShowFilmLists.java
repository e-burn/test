package gui;

import consts.Consts;
import consts.ListID;
import data.FilmInfo;
import data.ListOfFilms;
import data.controller.ShowChoosenListController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShowFilmLists
{
    private HashMap<ListID, ListOfFilms> allLists_;
    public ShowFilmLists(HashMap<ListID, ListOfFilms> allLists)
    {
        for(Map.Entry<ListID, ListOfFilms> list: allLists_.entrySet())
        {
            Button listButton = new Button();
            listButton.setText(Consts.listsTitles.get(list.getValue()));
            listButton.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    try {
                        ShowChoosenListController.showChoosenList(list.getKey());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //list.getValue().showFilms();
                }
            });
        }
    }
    public void showAllFilmLists()
    {
//отобразить все кнопки
    }
}
