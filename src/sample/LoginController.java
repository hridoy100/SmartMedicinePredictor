package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import util.UserData;

import java.io.IOException;

public class LoginController
{

    private Main main;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccount;

    @FXML
    void loginAction(ActionEvent event)
    {
        String username = userText.getText();
        String password = passwordText.getText();

        //if (username.equals(UserData.getUsername()) && password.equals(UserData.getPassword()))
        if (UserData.checkIfUserExists(username,password))
        {
            // successful login
            try
            {
                //show home page..
                main.showHomePage();
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            // failed login , username and password don't match
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }


    @FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }


    @FXML
    void createNewAccount(ActionEvent event){
        try {
            main.createAccountWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
