
package LiveScores.mainUI;

import java.sql.*; //DB operations!


import LiveScores.Services.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;


/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class PlayerController implements Initializable {

    @FXML
    private TextField __name;
    @FXML
    private TextField __jersey;
    @FXML
    private ComboBox<String> __roleSelect;
    @FXML
    private Button __submit;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Batsman","Bowler","Keeper","Allrounder");
        __roleSelect.setItems(list);
    }    

    @FXML
    private void onSubmit(ActionEvent event) {
        try
        {
            DBContext db = new DBContext();
            Connection conn = db.getConnection();
            String role = __roleSelect.getSelectionModel().getSelectedItem();
            String name = __name.getText();
            String jnum = __jersey.getText();
            String pid = KeyGen.generateKey();
            String Query = "INSERT INTO allplayer VALUES('%s','%s','%s','%s')";
            Query = String.format(Query,pid,name,jnum,role);
            Statement statement = conn.createStatement();
            int stat =statement.executeUpdate(Query);
            if(stat == 1){
                __name.setText("");
                __jersey.setText("");
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
