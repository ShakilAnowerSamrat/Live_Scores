
package LiveScores.mainUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToMatch(ActionEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResultScreen.fxml"));
            Parent parent = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("LiveScores - version 1.0.0");
            stage.setScene(new Scene(parent));
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void updateMatch(ActionEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateScreen.fxml"));
            Parent parent = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("LiveScores - version 1.0.0");
            stage.setScene(new Scene(parent));
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ____arrange(ActionEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ArrangeScreen.fxml"));
            Parent parent = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("LiveScores - version 1.0.0");
            stage.setScene(new Scene(parent));
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ____newteam(ActionEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TeamCreation.fxml"));
            Parent parent = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("LiveScores - version 1.0.0");
            stage.setScene(new Scene(parent));
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ____addplayer(ActionEvent event) {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlayerCreation.fxml"));
            Parent parent = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("LiveScores - version 1.0.0");
            stage.setScene(new Scene(parent));
            stage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
