
package LiveScores.mainUI;

import java.sql.*; //Database connectivity classes!

import LiveScores.Services.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class ResultController implements Initializable {

    @FXML
    private Label __team_1;
    @FXML
    private Label __team_2;
    @FXML
    private Label __innings;
    @FXML
    private Label __batting;
    @FXML
    private Label __tossResult;
    @FXML
    private Label __defending;
    @FXML
    private Label __stat;
    @FXML
    private Label __runStat;
    
    
    private String Match_id;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(Match_id == null) return;
        
        try
        {
            DBContext db = new DBContext();
            Connection conn = db.getConnection();
            Statement statement;
            statement = conn.createStatement();
            String Query = "SELECT * FROM livematch WHERE match_id = '%s'";
            Query = String.format(Query,Match_id);
            ResultSet result;
            for(int counter = 0;counter % 100 == 0;++counter){                
                result = statement.executeQuery(Query);
                while(result.next()){
                    __team_1.setText(result.getString("name_t1"));
                    __team_2.setText(result.getString("name_t2"));
                    __innings.setText(String.format("%s",result.getInt("innings")));
                    int toss = result.getInt("toss");
                    if(toss == -1) continue;
                    switch(toss){
                        case 0:
                            __tossResult.setText(
                                String.format(
                                    "%s has won the toss and choose to ball",
                                    __team_1.getText()
                                )
                            );
                        break;
                        case 1:
                            __tossResult.setText(
                                String.format(
                                    "%s has won the toss and choose to bat",
                                    __team_1.getText()
                                )
                            );
                            break;
                        case 10:
                            __tossResult.setText(
                                String.format(
                                    "%s has won the toss and choose to ball",
                                    __team_2.getText()
                                )
                            );
                        break;
                        case 11:
                            __tossResult.setText(
                                String.format(
                                    "%s has won the toss and choose to bat",
                                    __team_2.getText()
                                )
                            );
                        break;
                    }

                    boolean _1st = result.getBoolean("innings_1st");

                    if(_1st){
                        __innings.setText("1st");
                    }
                    else{
                        __innings.setText("2nd");
                    }


                    if(_1st && (toss == 1 || toss == 11)){
                        __batting.setText(result.getString("name_t1"));
                        __runStat.setText(String.format("%s | %s",result.getInt("t1_score"),result.getInt("t1_wicket")));
                    }
                    else{
                        __batting.setText(result.getString("name_t2"));
                        __runStat.setText(String.format("%s | %s",result.getInt("t2_score"),result.getInt("t2_wicket")));
                    }

                    __stat.setText(String.format("%s | %s",result.getInt("over_count"),result.getInt("ball")));
                    
                    if(counter >= 10000) counter = 0;
                    
                }
            }
            //Thread.sleep(500);
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }    

    @FXML
    private void __summary(ActionEvent event) {
    }
    
}
