package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    Stage stage;

    /**
     *
     * stage is a global variable which denotes the window. We kept it as global because
     * we don't want it to pop up on different events. We will simply be changing the scene
     * on different events.
     * This function is called at first. This further calls in showLoginPage() function which loads
     * the login page.
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showLoginPage();
    }

    /**
     * Loads FXML view of login.fxml
     * The controller class for login.fxml is LoginController.
     * @throws Exception
     */
    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("User Login Window");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * this function is called from the login window when create new account button is pressed.
     * it changes the scene to createAccountView.fxml on the same window or stage.
     * it also changes the controller to CreateAccountController.
     * @throws IOException
     */

    public void createAccountWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("createAccountView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        CreateAccountController controller = loader.getController();
        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Create Customer Account");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showHomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomePageController controller = loader.getController();
        //controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showFeelingSickPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("feelingSickView.fxml"));
        Parent root = loader.load();

        // Loading the controller
        FeelingSickController controller = loader.getController();
//        controller.load();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Feeling Sick");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showFinalSuggestionPage(ArrayList<String> problems) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("medicineSuggestionView.fxml"));
        Parent root = loader.load();
        // Loading the controller
        MedicineSuggestionController controller = loader.getController();
        controller.load(problems);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Medicine Suggestion");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * main function is called at the start of the program..
     * launch(args) calls start(Stage primaryStage) function..
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
