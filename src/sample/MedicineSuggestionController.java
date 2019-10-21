package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.SendEmailSMTP;
import util.UserData;

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

        System.out.println("Problems: "+problems.size());

        if (problems.size()==1){
            if(problems.get(0).equals("Head Ache")){
                medicine1.setText("naproxin");
                medicine1Period.setText("1-0-1");

                medicine2.setVisible(false);
                medicine2Period.setVisible(false);

                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
                medicineTotalDays.setText("Take these medicines whenever you have an headache. " +
                        "If after taking the medicine you still have head ache continuously for more than 3 days," +
                        " consult a specialist.");


                String message = "Medicine1: "+medicine1.getText()+ "\t"+"Per Day Use: "+medicine1Period+
                        "\n\n"+medicineTotalDays;
                System.out.println("User name: " +UserData.getUsername());
                //SendEmailSMTP.sendEmail(message,UserData.getUsername());

            }
            else if(problems.get(0).equals("Sleep")){
                medicine1.setText("Filfresh®");
                medicine1Period.setText("- - -");
                /**
                 * suggest only one medicine. So, rest of the medicines are made invisible..
                 */
                medicineTotalDays.setText("Adult: Insomnia: 3-6 mg one hour before bedtime");

                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Vomiting")){
                medicine1.setText("Motifast®");
                medicine1Period.setText("1-1-1");

                medicineTotalDays.setText("1-2 tablet in every 4-8 hours daily 15-30 minutes before meals. Take for 7 days");
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Cough")){
                medicine1.setText("Adovas®");
                medicine1Period.setText("1-1-1");

                medicineTotalDays.setText("Adults: 3 tea spoonfuls (15 ml) 2-3 times a day. " +
                        "In acute cough warm water can be added for better result.\n" +
                        "Children under 12 years of age: 1-2 teaspoonful (5-10 ml) 3 times a day.");
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Cold")){
                medicine1.setText("Neocilor(Desloratadine)");
                medicine1Period.setText("1-0-1");

                medicineTotalDays.setText("As there are no food effects on the bioavailability, Neocilor may be taken without regard to meal.\n" +
                        "Adults and adolescent of 12 years or over : 5 mg once daily.\n" +
                        "Child 6-11 years : 2.5 mg once daily.\n" +
                        "Child 12 months-5 years : 1.25 mg (2.5 ml Neocilor syrup) once daily.\n" +
                        "Child 6 months-11 months : 1 mg (2 ml Neocilor syrup) once daily.\n" +
                        "Patients with liver or renal impairment: A starting dose of one Neocilor tablet (Desloratadine 5 mg) every other day is recommended.\n" +
                        "Pediatric use: The safety and effectiveness of Desloratadine in pediatric patients under 6 months of age has not been established.");
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Body Pain")){
                medicine1.setText("Anadol®");
                medicine1Period.setText("1-1-1");

                medicineTotalDays.setText("Anadol® Capsule: Usual doses are 50 to 100 mg every four to six hours. " +
                        "For acute pain an initial dose of 100 mg is required. " +
                        "For chronic painful conditions an initial dose of 50 mg is recommended. " +
                        "Subsequent doses should be 50 to 100 mg administered 4-6 hourly. " +
                        "The dose level and frequency of dosing will depend on the severity of the pain. " +
                        "The total daily dosage by mouth should not exceed 400 mg.");
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Diarrhoea") || problems.get(0).equals("Loose Motion")){
                medicine1.setText("Imotil®");
                medicine1Period.setText("1-0-1");

                medicineTotalDays.setText("Acute diarrhoea: The initial dose is 2 capsules for adults and 1 capsule for children older than eight; " +
                        "in addition 1 capsule should be taken at any subsequent loose stool. " +
                        "The daily dose should not exceed 8 capsules for adults, for children 4-6 capsules according to age. " +
                        "Chronic diarrhoea Initial dose: Adults: 2 capsules daily. " +
                        "Children: Older than eight: 1 capsule daily.");
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Gastric")){
                medicine1.setText("Ace Plus®");
                medicine1Period.setText("1-1-1");

                medicineTotalDays.setText("Adults: 1-2 tablets every 4-6 hours. Maximum dose: 8 tablets daily. " +
                        "Not recommended for children below 12 years.");
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(problems.get(0).equals("Fever")){
                medicine1.setText("Ciprocin®");
                medicine1Period.setText("1-0-1");

                medicineTotalDays.setText("Urinary Tract Infection : Acute Uncomplicated-100 mg or 250 mg b.i.d. 3 Days, " +
                        "Mild/Moderate and Severe/Complicated-500 mg b.i.d. 7 to 14 Days or XR 1 gm once daily for 7 to 14 days. " +
                        "Severe/Complicated 750 mg twice daily 7 to 14 Days. " +
                        "Lower Respiratory Tract Infection : Mild/Moderate 500 mg b.i.d. or XR 1 gm once daily 7 to 14 Days, " +
                        "Severe/Complicated 750 mg b.i.d 7 to 14 Days. Acute Sinusitis : Mild/Moderate 500 mg b.i.d. or XR 1 gm once daily 10 Days. " +
                        "Infectious Diarrhea : Mild/Moderate/Severe 500 mg b.i.d. or XR 1 gm once daily 5 to 7 Days. " +
                        "Typhoid Fever : Mild/Moderate 500 mg b.i.d. or XR 1 gm once daily 10 Days.\n" +
                        "\n" +
                        "Pediatric Dosage: 10 mg/kg to 20 mg/kg b.i.d. (maximum 750 mg per dose) for 10 to 21 days.");
                medicine2.setVisible(false);
                medicine2Period.setVisible(false);
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
        }
        else if (problems.size()==2){

            String totalProblems = "";
            for (int i=0; i<problems.size(); i++){
                totalProblems+=problems.get(i)+",";
            }

            System.out.println("total problems: "+totalProblems);

            if(totalProblems.contains("Fever") && totalProblems.contains("Cough")){
                medicine1.setText("Ciprocin®");
                medicine1Period.setText("1-0-1");
                medicine2.setText("Fexo");
                medicine2Period.setText("1-0-1");
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
                medicineTotalDays.setText("Take these medicines for 7days. If no improvement then contact specialist.");
            }
            else if(totalProblems.contains("Fever") && totalProblems.contains("Cold")){
                medicine1.setText("Ciprocin®");
                medicine1Period.setText("1-0-1");
                medicine2.setText("Neocilor");
                medicine2Period.setText("1-0-1");
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
                medicineTotalDays.setText("Take these medicines for 7days. If no improvement then contact specialist.");

            }
            else if(totalProblems.contains("Cough") && totalProblems.contains("Cold")){
                medicine1.setText("Tofen");
                medicine1Period.setText("0-0-1");
                medicine2.setText("Neocilor");
                medicine2Period.setText("1-0-1");
                medicine3.setText("Ocof -1ph");
                medicine3Period.setText("1 teaspoon 3 times a day");
                medicineTotalDays.setText("Take these medicines for 7days. If no improvement then contact specialist.");
            }
            else if(totalProblems.contains("Vomiting") && totalProblems.contains("Gastric")){
                medicine1.setText("Motifast®");
                medicine1Period.setText("1-1-1");

                medicine2.setText("Ace Plus®");
                medicine2Period.setText("1-1-1");

                medicineTotalDays.setText("(Ace Plus)-->Adults: 1-2 tablets every 4-6 hours. Maximum dose: 8 tablets daily. " +
                        "Not recommended for children below 12 years."+"\n"+
                        "(Motifast)-->1-2 tablet in every 4-8 hours daily 15-30 minutes before meals.");

                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if((totalProblems.contains("Diarrhoea") || totalProblems.contains("Loose Motion")) && totalProblems.contains("Gastric")){
                medicine1.setText("Imotil®");
                medicine1Period.setText("1-0-1");
                medicine2.setText("Ace Plus®");
                medicine2Period.setText("1-1-1");
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
                medicineTotalDays.setText("(For Imotil)-->Acute diarrhoea: The initial dose is 2 capsules for adults and 1 capsule for children older than eight; " +
                        "in addition 1 capsule should be taken at any subsequent loose stool. " +
                        "The daily dose should not exceed 8 capsules for adults, for children 4-6 capsules according to age. " +
                        "Chronic diarrhoea Initial dose: Adults: 2 capsules daily. " +
                        "Children: Older than eight: 1 capsule daily."+"\n"+
                        "(For Ace Plus)-->Adults: 1-2 tablets every 4-6 hours. Maximum dose: 8 tablets daily. " +
                        "Not recommended for children below 12 years.");
            }
        }
        else if (problems.size()==3){

            String totalProblems = "";
            for (int i=0; i<problems.size(); i++){
                totalProblems+=problems.get(i)+",";
            }

            if(totalProblems.contains("Fever") && totalProblems.contains("Cough") && totalProblems.contains("Cold")){
                medicine1.setText("Ciprocin®");
                medicine1Period.setText("1-0-1");
                medicine2.setText("Neocilor");
                medicine2Period.setText("1-0-1");
                medicine3.setText("Ocof -1ph");
                medicine3Period.setText("1 teaspoon 3 times a day");
                medicineTotalDays.setText("Take these medicines for 7days. If no improvement then contact specialist.");
            }
            else if(totalProblems.contains("Fever") && totalProblems.contains("Cold") && totalProblems.contains("Head Ache")){
                medicine1.setText("Ciprocin®");
                medicine1Period.setText("1-0-1");
                medicine2.setText("Neocilor");
                medicine2Period.setText("1-0-1");

                medicine3.setText("naproxin");
                medicine3Period.setText("1-0-1");

                medicineTotalDays.setText("Take naproxin whenever you have an headache. " +
                        "If after taking the medicine you still have head ache continuously for more than 3 days," +
                        " consult a specialist. Take medicines for about 7 days.");

            }
            else if(totalProblems.contains("Cough") && totalProblems.contains("Cold") && totalProblems.contains("Head Ache")){
                medicine1.setText("Ocof -1ph");
                medicine1Period.setText("1 teaspoon 3 times a day");
                medicine2.setText("Neocilor");
                medicine2Period.setText("1-0-1");

                medicine3.setText("naproxin");
                medicine3Period.setText("1-0-1");

                medicineTotalDays.setText("Take naproxin whenever you have an headache. " +
                        "If after taking the medicine you still have head ache continuously for more than 3 days," +
                        " consult a specialist. Take medicines for about 7 days.");
            }
            else if(totalProblems.contains("Head Ache") && totalProblems.contains("Body Pain") && totalProblems.contains("Fever")){
                medicine1.setText("Anadol®");
                medicine1Period.setText("1-1-1");

                medicineTotalDays.setText("Anadol® Capsule: Usual doses are 50 to 100 mg every four to six hours. " +
                        "For acute pain an initial dose of 100 mg is required. " +
                        "For chronic painful conditions an initial dose of 50 mg is recommended. " +
                        "Subsequent doses should be 50 to 100 mg administered 4-6 hourly. " +
                        "The dose level and frequency of dosing will depend on the severity of the pain. " +
                        "The total daily dosage by mouth should not exceed 400 mg.");
                medicine2.setText("naproxin");
                medicine2Period.setText("1-0-1");
                medicine3.setVisible(false);
                medicine3Period.setVisible(false);
            }
            else if(totalProblems.contains("Diarrhoea") && totalProblems.contains("Loose Motion") && totalProblems.contains("Gastric")){
                medicine1.setText("Imotil®");
                medicine1Period.setText("1-0-1");

                medicine2.setText("Ace Plus®");
                medicine2Period.setText("1-1-1");

                medicine3.setVisible(false);
                medicine3Period.setVisible(false);


                medicineTotalDays.setText("(For Imotil)-->Acute diarrhoea: The initial dose is 2 capsules for adults and 1 capsule for children older than eight; " +
                        "in addition 1 capsule should be taken at any subsequent loose stool. " +
                        "The daily dose should not exceed 8 capsules for adults, for children 4-6 capsules according to age. " +
                        "Chronic diarrhoea Initial dose: Adults: 2 capsules daily. " +
                        "Children: Older than eight: 1 capsule daily."+"\n"+"(For Ace Plus)-->Adults: 1-2 tablets every 4-6 hours. Maximum dose: 8 tablets daily. " +
                        "Not recommended for children below 12 years.");
            }
        }
    }

    @FXML
    void backButtonAction(ActionEvent event)
    {
        try
        {
            main.showFeelingSickPage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
