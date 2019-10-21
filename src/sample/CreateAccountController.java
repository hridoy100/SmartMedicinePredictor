package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.*;
import javafx.scene.control.*;
import util.UserData;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountController {

    private Main main;
    @FXML
    private Button backBtn;
    @FXML
    private Button createBtn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNoField;
    @FXML
    private TextField passwordField;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private ToggleGroup toggleGroup;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void backButtonAction(ActionEvent event)
    {
        try
        {
            main.showLoginPage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    String gender;
    @FXML
    void createAccount(ActionEvent event)
    {
        String name = nameField.getText();
        String age = ageField.getText();
        String address = addressField.getText();
        String phoneNo = phoneNoField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();


        if(name.length()==0 || age.length()==0 || address.length()==0 || phoneNo.length()==0
                || email.length()==0 || gender.length()==0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Field Empty");
            alert.setHeaderText("Field can't be empty.");
            alert.setContentText("You must Fill up every field.");
            alert.showAndWait();
        }
        else
        {
            List<String > customerList = new ArrayList<>();
            customerList.add(name);
            customerList.add(age);
            customerList.add(address);
            customerList.add(phoneNo);
            customerList.add(email);
            customerList.add(password);
//            boolean success=new DBInsertCustomer().validateInsert(customerList);
//            if(success)
//            {
//                new DBGetCustomer().showCustomerID(phoneNo,email,password);
//                nameField.setText(null);
//                ageField.setText(null);
//                phoneNoField.setText(null);
//                emailField.setText(null);
//                addressField.setText(null);
//                passwordField.setText(null);
//            }
            UserData.setUsername(name);
            UserData.setPassword(password);
            try {
                main.showLoginPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void load() {
        //        // create a toggle group
//        ToggleGroup tg = new ToggleGroup();
        toggleGroup = new ToggleGroup();
        // add radiobuttons to toggle group
        male.setToggleGroup(toggleGroup);
        female.setToggleGroup(toggleGroup);


        // add a change listener
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)toggleGroup.getSelectedToggle();

                if (rb != null) {
                    gender = rb.getText();

                }
            }
        });
    }

}
