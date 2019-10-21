package sample;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MedicineSuggestionController {
    @FXML
    private Label medicine1;
    @FXML
    private Label medicine1Period;
    @FXML
    private Label medicine2;
    @FXML
    private Label medicine2Period;
    @FXML
    private Label medicine3;
    @FXML
    private Label medicine3Period;
    @FXML
    private Label medicineTotalDays;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }


    public void load(ArrayList<String> problems) {
        /// if there's only one disease..
        if (problems.size()==1){
            if(problems.get(0).equals("Head Ache")){
                medicine1.setText("Paracetamol");
                medicine1Period.setText("1-0-1");
                medicine2.setText("Napa");
                medicine2Period.setText("0-0-1");
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Sleep")){
                medicine1.setText("Sleeping Pill");
                medicine1Period.setText("0-0-1");
                /**
                 * suggest only one medicine. So, rest of the medicines are made invisible..
                 */
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
        }
        /// if patient has two diseases..
        if (problems.size()==2){
            if(problems.get(0).equals("Fever")){
                medicine1.setText("Napa Extra");
                medicine1Period.setText("1-0-1");
            }
            if(problems.get(1).equals("Cough")){
                medicine2.setText("Fexo");
                medicine2Period.setText("0-0-1");
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(1).equals("Vomiting")){
                medicine2.setText("Fexo");
                medicine2Period.setText("0-0-1");
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
        }
    }
}
