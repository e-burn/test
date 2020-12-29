package data;

import consts.Consts;
import consts.ListID;
import gui.FilmButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListOfFilms  implements Serializable
{
	private FilmsArray filmsInTheList;
	private ListID listID;
	private ArrayList<FilmButton> films;
	public ListOfFilms(ListID listID)
	{
		this.listID = listID;
		filmsInTheList = new FilmsArray();
        films = new ArrayList<FilmButton>();
	}
	public void showFilms(Stage stage)//вероятно, эта функция должна принимать Stage, на которой должна отобразить список
    {
        FlowPane container = new FlowPane();
        //отобразить список кнопок-фильмов
        if (null != films) {
            for (FilmButton film : films) {
                //film.getFilmTitle();

                //Button button = new Button(film.getFilmTitle());
                //button.setPrefSize(350, 100);//нужный размер!
                container.getChildren().add(film.getButton());
            }

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(container);
            scrollPane.setPannable(true);
            Scene scene = new Scene(scrollPane, 550, 200);//нужный размер!
            stage.setScene(scene);
            stage.show();
        }
}

	public void addFilm(String filmTitle)
	{
        Integer filmID = 0;
	    if(null != films) {
	        filmID = films.size();
	    }
		FilmButton newFilmButton = new FilmButton(filmID, filmTitle);
		films.add(newFilmButton);
	}
}