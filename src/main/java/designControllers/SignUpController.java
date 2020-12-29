package designControllers;

import data.Personalization;
import data.PropertiesGetter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import data.UserInfo;
import javafx.stage.Stage;

import java.io.*;

public class SignUpController {

    private UserInfo userInfo = UserInfo.getInstance();
    private Personalization personalization = Personalization.getInstance();

    ObservableList<String> backgroundColors = FXCollections
            .observableArrayList("lightblue", "lightgreen", "white", "lightgrey");

    @FXML
    private Button okSignUpButton;

    @FXML
    private Button exitSignUpButton;

    @FXML
    private TextField loginSignUpField;

    @FXML
    private ChoiceBox backgroundColorBox;

    @FXML
    private Button setNewColorButton;

    public SignUpController() throws IOException {
    }

    @FXML
    public void initialize() {
        backgroundColorBox.setItems(backgroundColors);
    }

    @FXML
    void setNewColor(MouseEvent event) throws IOException {
        Parent newColorView = FXMLLoader.load(getClass().getClassLoader().getResource("signUp.fxml"));

        String backgroundColor = backgroundColorBox.getValue().toString();
        String style = "-fx-background-color: "+ backgroundColor+ ";";
        newColorView.setStyle(style);
        personalization.setBackgroundColor(style);

        Scene newColorViewScene = new Scene(newColorView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newColorViewScene);
        window.show();

    }

    @FXML
    void checkUserInput(MouseEvent event) throws IOException {
        userInfo.setLogin(loginSignUpField.getText());

        Parent startWindow = FXMLLoader.load(getClass().getClassLoader().getResource("startWindow.fxml"));

        userInfo.setPersonalization(personalization);
        startWindow.setStyle(personalization.getBackgroundColor());

        Scene startWindowScene = new Scene(startWindow);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(startWindowScene);

        //__________________________
        //сохраниние данных о пользователе
        //здесь должна быть сериализация UserInfo в файл
        saveUserInfo();
        //__________________________
        window.show();
    }

    @FXML
    void closeApp(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        //__________________________
        //сохраниние данных о пользователе
        //здесь должна быть сериализация UserInfo в файл
        saveUserInfo();
        //__________________________
        window.close();
    }

    void saveUserInfo () throws IOException {

        PropertiesGetter properties = new PropertiesGetter();
        String pathToFile = properties.getProperty("PATH_TO_SERIALIZED_DATA");
        File userInfoFile = new File(pathToFile);
        FileOutputStream outputStream = new FileOutputStream(userInfoFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(userInfo);

        objectOutputStream.close();
    }

}