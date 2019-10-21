package sample;

import com.sun.xml.internal.ws.util.StringUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import util.UserData;

import java.time.LocalDate;
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
    private DatePicker birthDatePicker;
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
        String birthDate = String.valueOf(birthDatePicker.getValue());
        String address = addressField.getText();
        String phoneNo = phoneNoField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();


        if(name.length()==0 || birthDate.length()==0 || address.length()==0 || phoneNo.length()==0
                || email.length()==0 || gender.length()==0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Field Empty");
            alert.setHeaderText("Field can't be empty.");
            alert.setContentText("You must Fill up every field.");
            alert.showAndWait();
        }
        else if(UserData.checkIfUsernameAlreadyExists(email)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Already Exists");
            alert.setHeaderText("Email address already exists.");
            alert.setContentText("This email id already exists. Please insert another email address.");
            alert.showAndWait();
        }
        else if(isNumeric(phoneNo) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Mobile No");
            alert.setHeaderText("Decimal value required");
            alert.setContentText("You must enter decimal value in phoneNo field.");
            alert.showAndWait();
        }
        else if(phoneNo.length()<11){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Mobile No");
            alert.setHeaderText("Invalid Length");
            alert.setContentText("Mobile No must be 11 digits.");
            alert.showAndWait();
        }
        else
        {
//            List<String > customerList = new ArrayList<>();
//            customerList.add(name);
//            customerList.add(age);
//            customerList.add(address);
//            customerList.add(phoneNo);
//            customerList.add(email);
//            customerList.add(password);
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

            //create new account. add it to accountData file..
            String fullData = name+":"+birthDate+":"+address+":"+phoneNo+":"+email+":"+password;
            UserData.writeToFile(fullData, "accountData.txt");

            //write only username and password in loginData file..
            UserData.writeToFile(email+":"+password,"loginData.txt");

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

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

}
