package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class FeelingSickController {

    @FXML
    private TextField temperature;
    @FXML
    private CheckBox vomiting;
    @FXML
    private CheckBox gastric;
    @FXML
    private CheckBox sleep;
    @FXML
    private CheckBox looseMotion;
    @FXML
    private CheckBox diarrhoea;
    @FXML
    private CheckBox headAche;


    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void backButtonAction(ActionEvent event)
    {
        try
        {
            main.showHomePage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void submitButtonAction(ActionEvent event)
    {
        if(temperature.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Field Empty");
            alert.setHeaderText("Please Insert Your Body Temperature for Better Suggestion.");
            alert.setContentText("You must enter your body temperature.");
            alert.showAndWait();
        }
        else if(vomiting.isSelected()==false && gastric.isSelected()==false && sleep.isSelected()==false &&
                looseMotion.isSelected()==false && diarrhoea.isSelected()==false && headAche.isSelected()==false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Checkbox not selected");
            alert.setHeaderText("Please select at least one checkbox.");
            alert.setContentText("You must select what's bothering you.");
            alert.showAndWait();
        }
        else{
            ArrayList<String> selectedProblems = new ArrayList<>();
            if(vomiting.isSelected()){
                selectedProblems.add("Vomiting");
            }
            if(gastric.isSelected()){
                selectedProblems.add("Gastric");
            }
            if(sleep.isSelected()){
                selectedProblems.add("Sleep");
            }
            if(looseMotion.isSelected()){
                selectedProblems.add("Loose Motion");
            }
            if(diarrhoea.isSelected()){
                selectedProblems.add("Diarrhoea");
            }
            if(headAche.isSelected()){
                selectedProblems.add("Head Ache");
            }
            try
            {
                main.showFinalSuggestionPage(selectedProblems);
//            main.showHomePage();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }
}
