package gui;

import data.FilmInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import serverInteraction.FilmDescriptionController;


import java.io.IOException;

public class FilmButton
{
    Integer filmID_;
    Button filmButton_;

    public String getFilmTitle()
    {
        return filmTitle_;
    }

    public Button getButton() { return filmButton_; }

    String filmTitle_;
    public FilmButton(Integer filmId, String filmTitle)
    {
        filmID_  = filmId;
        filmTitle_ = filmTitle;
        filmButton_ = new Button();
        filmButton_.setText(filmTitle);
        filmButton_.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String result = "Film not found...";
                    FilmInfo filmInfo = FilmDescriptionController.requestFilmDescription(filmTitle_);
                    if(filmInfo != null)
                    {
                        result = filmInfo.toString();
                    }
                    FilmDescriptionController.showResult(filmInfo.getTitle(), result);
                    //filmButton_.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
