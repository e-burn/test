package designControllers;

import consts.ListID;
import data.ListOfFilms;
import data.UserInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindowController {

    private UserInfo userInfo = UserInfo.getInstance();

    @FXML
    private Button exitButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button addNewFilmButton;

    public StartWindowController() throws IOException {
    }

    @FXML
    public void initialize() throws IOException {
        loginField.setText(userInfo.getLogin());
        ListOfFilms list = userInfo.getFilmList(ListID.FAVORITE);
        list.showFilms();
    }

    @FXML
    void addNewFilm(MouseEvent event) {

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
