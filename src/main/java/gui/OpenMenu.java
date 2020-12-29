package gui;

import consts.Consts;
import consts.ListID;
import consts.OptionID;
import data.ListOfFilms;
import data.controller.ShowChoosenListController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;

public class OpenMenu
{
    //private HashMap<OptionID, ListOfFilms> allOptions_;
    public OpenMenu(HashMap<OptionID, ListOfFilms> allLists)
    {
       /* for(Map.Entry<ListID, ListOfFilms> list: allOptions_.entrySet())
        {
            Button listButton = new Button();
            listButton.setText(Consts.listsTitles.get(list.getValue()));
            listButton.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    ShowChoosenListController.showChoosenList(list.getKey());
                    list.getValue().showFilms();
                }
            });
        }*/
    }
    public void showAllOptions()
    {
        //���������� ��� ������
    }
    public void cancel()
    {

    }
}
