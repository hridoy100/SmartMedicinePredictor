package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class HomePageController {
    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void FeelingSickView(ActionEvent event){
        try {
            main.showFeelingSickPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void logOutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
