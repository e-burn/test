package designControllers;

import consts.ListID;
import data.ListOfFilms;
import data.UserInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class StartWindowController {

    private UserInfo userInfo = UserInfo.getInstance();

    @FXML
    private Button exitButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button showButton;
    
    @FXML
    private Button addNewFilmButton;

    public StartWindowController() throws IOException {
    }

    @FXML
    public void initialize() throws IOException {
        loginField.setText(userInfo.getLogin());
    }

    @FXML
    void showFilms(MouseEvent event) throws IOException {
        Stage form = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        ListOfFilms list = userInfo.getFilmList(ListID.FAVORITE);
        list.showFilms(form);
      }

    @FXML
    void addNewFilm(MouseEvent event) {
        Stage form = (Stage)((Node)event.getSource()).getScene().getWindow();
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
            buttonText = new String(new String("Add!").getBytes("Windows-1251"), "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        startButton.setText(buttonText);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //добавление фильма в список
                //и отрисовка окна
                String addingFilm = fieldValue.getText();
                ListOfFilms list = userInfo.getFilmList(ListID.FAVORITE);
                list.addFilm(addingFilm);

                Parent startWindow = null;
                try {
                    startWindow = FXMLLoader.load(getClass().getClassLoader().getResource("startWindow.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                userInfo.setPersonalization(userInfo.getPersonalization());
                startWindow.setStyle(userInfo.getPersonalization().getBackgroundColor());

                Scene startWindowScene = new Scene(startWindow);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(startWindowScene);
                window.show();   

            }
        });
        grid.add(startButton, 0, elementsCounter);
        Scene scene = new Scene(grid, 300, 200);
        form.setScene(scene);
        form.setTitle("Searching film");
        form.show(); 
    }

    @FXML
    void exit(MouseEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        //__________________________
        //сохраниние данных о пользователе
        //здесь должна быть сериализация UserInfo в файл
        //__________________________
        window.close();
    }

}
