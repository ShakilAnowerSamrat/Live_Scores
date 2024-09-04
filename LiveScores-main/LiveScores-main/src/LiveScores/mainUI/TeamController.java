
package LiveScores.mainUI;


import LiveScores.Services.*;

import java.sql.*;
import javafx.fxml.Initializable;
import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;


/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class TeamController implements Initializable {


    @FXML
    private TextField __captain;
    @FXML
    private TextField __team_name;
    @FXML
    private TextField __p1;
    @FXML
    private TextField __p2;
    @FXML
    private TextField __p3;
    @FXML
    private TextField __p4;
    @FXML
    private TextField __p5;
    @FXML
    private TextField __p6;
    @FXML
    private TextField __p7;
    @FXML
    private TextField __p8;
    @FXML
    private TextField __p9;
    @FXML
    private TextField __p10;
    @FXML
    private Button __submit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ____onSubmit(ActionEvent event) {
        try
        {
            DBContext db = new DBContext();
            Connection conn = db.getConnection();
            String team = __team_name.getText();
            String cap = __captain.getText();
            String p1 = __p1.getText();
            String p2 = __p2.getText();
            String p3 = __p3.getText();
            String p4 = __p4.getText();
            String p5 = __p5.getText();
            String p6 = __p6.getText();
            String p7 = __p7.getText();
            String p8 = __p8.getText();
            String p9 = __p9.getText();
            String p10 = __p10.getText();
            ObservableList<String> list = FXCollections.observableArrayList(cap,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
            int count;
            for(String str1:list){
                count = 0;
                for(String str2:list){
                    if(str1.equals(str2)){
                        count += 1;
                    }    
                }
                if(count > 1){
                    System.out.println("Player encountered twice!");
                    return;
                }
            }
            String tid = KeyGen.generateKey();
            String Query = "INSERT INTO allteam VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
            Query = String.format(Query,tid,team,cap,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
            Statement statement = conn.createStatement();
            int stat = statement.executeUpdate(Query);
            if(stat == 1){
                __captain.setText("");
                __team_name.setText("");
                __p1.setText("");
                __p2.setText("");
                __p3.setText("");
                __p4.setText("");
                __p5.setText("");
                __p6.setText("");
                __p7.setText("");
                __p8.setText("");
                __p9.setText("");
                __p10.setText("");
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
