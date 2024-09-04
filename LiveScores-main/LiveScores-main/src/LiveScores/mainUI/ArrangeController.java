
package LiveScores.mainUI;

import java.sql.*;

import LiveScores.Services.*;

import javafx.collections.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class ArrangeController implements Initializable {

    @FXML
    private DatePicker __date;
    @FXML
    private PasswordField __accessToken;
    @FXML
    private TextField __team_1;
    @FXML
    private TextField __team_1_id;
    @FXML
    private TextField __team_2;
    @FXML
    private TextField __team_2_id;
    @FXML
    private TextField __innings;
    @FXML
    private Button __submit;
    
    ObservableList list1,list2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ____submit(ActionEvent event) {
        try
        {
            DBContext db = new DBContext();
            Connection conn = db.getConnection();
            String name_t1 = __team_1.getText();
            String name_t2 = __team_2.getText();
            String team_1 = __team_1_id.getText();
            String team_2 = __team_2_id.getText();
            String token = __accessToken.getText();
            String date = __date.getValue().toString();
            String innings = __innings.getText();
            if(java.lang.Integer.parseInt(innings) <= 0){
                System.out.println("Invalid value for match innings!");
                return;
            }
            String mid = KeyGen.generateKey();
            String Query = "SELECT * FROM allteam WHERE team_id = '%s'";
            String Query1 = String.format(Query,team_1);
            Statement statement;
            statement = conn.createStatement();
            ResultSet result;
            result = statement.executeQuery(Query1);
            
            while(result.next()){
                list1 = FXCollections.observableArrayList(
                         result.getString("captain"),
                         result.getString("player1"),
                         result.getString("player2"),
                         result.getString("player3"),
                         result.getString("player4"),
                         result.getString("player5"),
                         result.getString("player6"),
                         result.getString("player7"),
                         result.getString("player8"),
                         result.getString("player9"),
                         result.getString("player10")
                    );
            }
            String Query2 = String.format(Query,team_2);
            result = statement.executeQuery(Query2);
            while(result.next()){
                list2 = FXCollections.observableArrayList(
                         result.getString("captain"),
                         result.getString("player1"),
                         result.getString("player2"),
                         result.getString("player3"),
                         result.getString("player4"),
                         result.getString("player5"),
                         result.getString("player6"),
                         result.getString("player7"),
                         result.getString("player8"),
                         result.getString("player9"),
                         result.getString("player10")
                    );
            }
            
            if(list1 != null && list2 != null){
                for(var str1:list1){
                    for(var str2:list2){
                        if(str1 == str2){
                            System.out.println("Player encountered twice!");
                            return;
                        }
                    }
                }
            }
            
            Query = "INSERT INTO allmatch "
                    + "('match_id','accesstoken','datetime','innings','team_1','name_t1','team_2','name_t2','toss')"
                    + " VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','-1')";
            Query = String.format(Query,mid,token,date,innings,team_1,name_t1,team_2,name_t2);
            int stat = statement.executeUpdate(Query);
            if(stat == 1){
                __team_1.setText("");
                __team_2.setText("");
                __team_1_id.setText("");
                __team_2_id.setText("");
                __accessToken.setText("");
                __innings.setText("");
            }
                
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
