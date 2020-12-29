package serverInteraction;

import data.FilmInfo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class FilmDescriptionController //extends Application
{
    static HashMap <String, FilmInfo> films_;
    private static IFilmsServer filmsServer_;
    public FilmDescriptionController()
    {
        films_ = new HashMap<>();
        filmsServer_ = new FilmsServer();
    }

    public static void showFormToEnterFilm() throws Exception
    {
        Stage form = new Stage();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        int elementsCounter = 0;

        String labelText = null;
        try {
            labelText = new String(new String("Enter film title:").getBytes("Windows-1251"), "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //createLabelWithUserField(labelText, elementsCounter, grid);
        Label fieldName = new Label(labelText);
        grid.add(fieldName, 0, elementsCounter);
        elementsCounter++;
        TextField fieldValue = new TextField();
        grid.add(fieldValue, 0, elementsCounter);
        elementsCounter++;

        Button startButton = new Button();
        startButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        String buttonText = null;
        try {
            buttonText = new String(new String("Find!").getBytes("Windows-1251"), "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        startButton.setText(buttonText);
        startButton.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event) {
                //startButton.setText("plaese wait...");
                //Stage loadingStage = showLoadingStage();
                String searchQuery = fieldValue.getText();
                try {
                    String result = "Film not found...";
                    FilmInfo filmInfo = requestFilmDescription(searchQuery);
                    if(filmInfo != null)
                    {
                        result = filmInfo.toString();
                    }
                    //loadingStage.close();
                    form.close();
                    showResult(filmInfo.getTitle(), result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        grid.add(startButton, 0, elementsCounter);
        Scene scene = new Scene(grid, 300, 200);
        form.setScene(scene);
        form.setTitle("Searching film");
        form.show();
    }

    public static FilmInfo requestFilmDescription(String filmTitle) throws IOException
    {
        //load user info
        //find this film
        if(films_.containsKey(filmTitle.toLowerCase()))
        {
            return films_.get(filmTitle);
        }
        else
        {
            boolean found = filmsServer_.searchFilm(filmTitle);
            if(found)
            {
                FilmInfo result = filmsServer_.getFilmDesc();
                films_.put(result.getTitle(), result);
                return result;
            }
            else
            {
                return null;
            }
        }
    }
   /* public void showFormToEnterFilm()
    {
        //Application.launch();
    }*/
    public static void showResult(String title, String result)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        int elementsCounter = 0;

        Label labelFilmTitle = new Label(title);
        labelFilmTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        //createLabelWithUserField(labelText, elementsCounter, grid);
        grid.add(labelFilmTitle, 0, elementsCounter);
        elementsCounter++;
        //createLabelWithUserField(labelText, elementsCounter, grid);
        Label resultLabel = new Label(result);
        resultLabel.setWrapText(true);
        grid.add(resultLabel, 0, elementsCounter);
        Stage stage = new Stage();
        Scene scene = new Scene(grid, 500, 600);
        //stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Searching film");
        stage.show();
    }
}
