
package LiveScores.mainUI;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

//User defined classes!
import LiveScores.Services.*;


/**
 *
 * @author Debug Entity
 */

public class LiveScores extends Application {

    /**
     * @param args the command line arguments
     */

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("LiveScores - version 1.0.0");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
}
