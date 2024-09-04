
package LiveScores.mainUI;


import java.sql.*; //SQL classes!

import LiveScores.Services.*;


import javafx.collections.*;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import static java.lang.Integer.parseInt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;




/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class UpdateController implements Initializable {

    String Match_id,team1_id,team2_id;
    ObservableList<String> allPlayersTeam1 = FXCollections.observableArrayList();
    ObservableList<String> allPlayersTeam2 = FXCollections.observableArrayList();
    int tossResult = -1;
    boolean _team1_batting_1st;
    boolean isTossSet = false,_1stInnOver = false,matchOver = false;
    int t1_score = 0,t2_score = 0;
    int inningsCount;
    int overCount = 1,ballCount = 1;
    int t1wicket = 0,t2wicket = 0;
    
    
    
    @FXML
    private Label __over;
    @FXML
    private Label __ball;
    @FXML
    private Label __innings;
    @FXML
    private Button __noball;
    @FXML
    private Button __dotball;
    @FXML
    private Button __toss;
        @FXML
    private Button __six_button;
    @FXML
    private Button __four_button;
    @FXML
    private Button __zero_button;
    @FXML
    private Button __wideball;
    @FXML
    private TextField xtra_runs;
        @FXML
    private Button __wicket;
    @FXML
    private ComboBox<String> batsman__1;
    @FXML
    private ComboBox<String> batsman__2;
    @FXML
    private ComboBox<String> __bowler;
    @FXML
    private RadioButton __b1Out;
    @FXML
    private RadioButton __b2Out;
    @FXML
    private Label __team_1;
    @FXML
    private Label __team_2;
        @FXML
    private TextArea ____log;
    @FXML
    private ToggleGroup __tossOption;
    @FXML
    private ToggleGroup __batsman_wicket;
    @FXML
    private RadioButton __tossOpt_1;
    @FXML
    private RadioButton __tossOpt_2;
    @FXML
    private RadioButton __tossOpt_3;
    @FXML
    private RadioButton __tossOpt_4;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {
            if(Match_id == null)
                return;
            DBContext db = new DBContext();
            Connection conn = db.getConnection();
            String Query = "SELECT * FROM allmatch WHERE match_id = '%s'";
            Query = String.format(Query,Match_id);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(Query);
            while(result.next()){
                team1_id = result.getString("team_1");
                __team_1.setText(result.getString("name_t1"));
                team2_id = result.getString("team_2");
                __team_2.setText(result.getString("name_t2"));
                inningsCount = result.getInt("innings");
            }
            __innings.setText(String.format("%s:1st",inningsCount));
            __over.setText("1");
            __ball.setText("1");
            Query = "SELECT captain,player1,player2,player3,player4,player5,player6,player7,player8,player9,player10 FROM allteam WHERE team_id = '%s'";
            Query = String.format(Query,team1_id);
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam1.add(result.getString("captain"));
                allPlayersTeam1.add(result.getString("player1"));
                allPlayersTeam1.add(result.getString("player2"));
                allPlayersTeam1.add(result.getString("player3"));
                allPlayersTeam1.add(result.getString("player4"));
                allPlayersTeam1.add(result.getString("player5"));
                allPlayersTeam1.add(result.getString("player6"));
                allPlayersTeam1.add(result.getString("player7"));
                allPlayersTeam1.add(result.getString("player8"));
                allPlayersTeam1.add(result.getString("player9"));
                allPlayersTeam1.add(result.getString("player10"));
            }
            Query = String.format(Query,team2_id);
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam2.add(result.getString("captain"));
                allPlayersTeam2.add(result.getString("player1"));
                allPlayersTeam2.add(result.getString("player2"));
                allPlayersTeam2.add(result.getString("player3"));
                allPlayersTeam2.add(result.getString("player4"));
                allPlayersTeam2.add(result.getString("player5"));
                allPlayersTeam2.add(result.getString("player6"));
                allPlayersTeam2.add(result.getString("player7"));
                allPlayersTeam2.add(result.getString("player8"));
                allPlayersTeam2.add(result.getString("player9"));
                allPlayersTeam2.add(result.getString("player10"));
            }
            Query = "SELECT * FROM allplayer WHERE pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s'";
            Query = String.format(Query,
                    allPlayersTeam1.get(0),
                    allPlayersTeam1.get(1),
                    allPlayersTeam1.get(2),
                    allPlayersTeam1.get(3),
                    allPlayersTeam1.get(4),
                    allPlayersTeam1.get(5),
                    allPlayersTeam1.get(6),
                    allPlayersTeam1.get(7),
                    allPlayersTeam1.get(8),
                    allPlayersTeam1.get(9),
                    allPlayersTeam1.get(10)
                );
            allPlayersTeam1.clear();
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam1.add(result.getString("name"));
            }
            Query = String.format(Query,
                    allPlayersTeam2.get(0),
                    allPlayersTeam2.get(1),
                    allPlayersTeam2.get(2),
                    allPlayersTeam2.get(3),
                    allPlayersTeam2.get(4),
                    allPlayersTeam2.get(5),
                    allPlayersTeam2.get(6),
                    allPlayersTeam2.get(7),
                    allPlayersTeam2.get(8),
                    allPlayersTeam2.get(9),
                    allPlayersTeam2.get(10)
                );
            allPlayersTeam2.clear();
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam2.add(result.getString("name"));
            }
        }
        catch(SQLException | NumberFormatException e){
            ____log.appendText("\n"+e.getMessage());
        }
        
        while(!matchOver){
            if(_team1_batting_1st){
                if(t1wicket == 9){
                    _1stInnOver = true;
                    __innings.setText(String.format("%s:2st",inningsCount));
                }
            }
            else{
                if(t2wicket == 9)
                    matchOver = true;
            }
            
            if(matchOver){
                ____log.appendText("\nMatch over!!!\n");
                __noball.setDisable(true);
                __dotball.setDisable(true);
                __wideball.setDisable(true);
                __zero_button.setDisable(true);
                __four_button.setDisable(true);
                __six_button.setDisable(true);
                __wicket.setDisable(true);
                try
                {
                    DBContext db = new DBContext();
                    Connection conn = db.getConnection();
                    String Query = "UPDATE allmatch SET matchover = '%s',matchresult = '%s' WHERE match_id = '%s'";
                    int matchresult;
                    if(t1_score == t2_score) matchresult = 0;
                    else matchresult = t1_score > t2_score ? -1:1;
                    Query = String.format(Query,true,matchresult,Match_id);
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(Query);
                }catch(SQLException e){
                    ____log.appendText("\n"+e.getMessage());
                }
            }
            
            __over.setText(String.format("%s",overCount));
            __ball.setText(String.format("%s",ballCount));
        }
    }    

    @FXML
    private void setTossResult(ActionEvent event) {
        if(!isTossSet){
            toss();
            if(tossResult == -1){return;}
            if(tossResult == 1 || tossResult == 11){
                __bowler.setItems(allPlayersTeam2);
                batsman__1.setItems(allPlayersTeam1);
                batsman__2.setItems(allPlayersTeam1);
                _team1_batting_1st = true;
            }
            else{
                __bowler.setItems(allPlayersTeam1);
                batsman__1.setItems(allPlayersTeam2);
                batsman__2.setItems(allPlayersTeam2);
                _team1_batting_1st = false;
            }
            isTossSet = true;
            __tossOpt_1.setDisable(true);
            __tossOpt_2.setDisable(true);
            __tossOpt_3.setDisable(true);
            __tossOpt_4.setDisable(true);
            __toss.setDisable(true);
            try
            {
                DBContext db = new DBContext();
                Connection conn = db.getConnection();
                String Query = "UPDATE allmatch SET toss = '%s' WHERE match_id = '%s'";
                Query = String.format(Query,tossResult,Match_id);
                Statement statement = conn.createStatement();
                statement.executeUpdate(Query);
                Query = "INSERT INTO livematch ('match_id','toss','innings','name_t1','name_t2') VALUES ('%s','%s','%s','%s','%s')";
                Query = String.format(Query,Match_id,tossResult,
                        inningsCount,__team_1.getText(),__team_2.getText());
                statement.executeUpdate(Query);
            }catch(SQLException e){
                ____log.appendText("\n"+e.getMessage());
            }
            
        }
    }

    @FXML
    private void ____update(ActionEvent event) {
        if(isTossSet){
            try{
                DBContext db = new DBContext();
                Connection conn = db.getConnection();
                Statement statement = conn.createStatement();
                String Query;
                if(_team1_batting_1st && !_1stInnOver){
                    Query = "UPDATE livematch SET ball = '%s',over_count = '%s',c1_score = '%s',c1_wicket = '%s' WHERE match_id = '%s'";
                    Query = String.format(Query,ballCount,overCount,t1_score,t1wicket,Match_id);
                }
                else{
                    Query = "UPDATE livematch SET ball = '%s',over_count = '%s',c2_score = '%s',c2_wicket = '%s' WHERE match_id = '%s'";
                    Query = String.format(Query,ballCount,overCount,t2_score,t2wicket,Match_id);
                }
                statement.executeUpdate(Query);
            }
            catch(SQLException e){
                ____log.appendText("\n"+e.getMessage());
            }
        }
    }
    
    private void __matchUpdate(int run){
        if(isTossSet){
            if(tossResult == 1 || tossResult == 11){
                score(run,t1_score);
                
            }
            else{
                score(run,t2_score);
            }
            ballCount += 1;
            if(ballCount > 6){
                overCount += 1;
                ballCount = 1;
            }
            if(overCount > inningsCount){
                if(!_1stInnOver){
                    overCount = 1;
                    ballCount = 1;
                    if(tossResult == 1 || tossResult == 11){
                        __bowler.setItems(allPlayersTeam1);
                        batsman__1.setItems(allPlayersTeam2);
                        batsman__2.setItems(allPlayersTeam2);
                    }
                    else{
                        __bowler.setItems(allPlayersTeam2);
                        batsman__1.setItems(allPlayersTeam1);
                        batsman__2.setItems(allPlayersTeam1);
                    }
                    _1stInnOver = true;
                }
                else{
                    matchOver = true;
                }
            }
        }
    }
    
    private void score(int run,int teamReference){
        teamReference += run;
    }


    @FXML
    private void __noball_clicked(ActionEvent event) {
        ballCount -= 1;
        if(ballCount == 0 && overCount != 1){
            ballCount = 6;
            overCount -= 1;
        }
    }
    
    @FXML
    private void __wideball_clicked(ActionEvent event) {
        __matchUpdate(1);
    }

    @FXML
    private void __onWicket(ActionEvent event) {
        __matchUpdate(0);
        if(__b1Out.isSelected()){
            String bt = batsman__1.getSelectionModel().getSelectedItem();
            ObservableList<String> list = batsman__1.getItems();
            list.remove(bt);
            batsman__1.getSelectionModel().clearSelection();
            batsman__1.setItems(list);
        }
        if(__b2Out.isSelected()){
            String bt = batsman__2.getSelectionModel().getSelectedItem();
            ObservableList<String> list = batsman__2.getItems();
            list.remove(bt);
            batsman__2.getSelectionModel().clearSelection();
            batsman__2.setItems(list);
        }
        if(tossResult == 1 || tossResult == 11){
            t1wicket += 1;
            
        }
        else{
            t2wicket += 1;
        }
    }

    @FXML
    private void __dotball_clicked(ActionEvent event) {
        __matchUpdate(0);
    }

    @FXML
    private void __sixer(ActionEvent event) {
        __matchUpdate(6);
    }

    @FXML
    private void __boundry(ActionEvent event) {
        int run = parseInt(xtra_runs.getText());
        __matchUpdate(run+4);
        xtra_runs.setText("");
    }

    @FXML
    private void __run_scored(ActionEvent event) {
        int run = parseInt(xtra_runs.getText());
        __matchUpdate(run);
        xtra_runs.setText("");
    }
    
    private void toss(){
        if(__tossOpt_1.isSelected()){
            tossResult = 0;
        }
        else if(__tossOpt_2.isSelected()){
            tossResult = 1;
        }
        else if(__tossOpt_3.isSelected()){
            tossResult = 10;
        }
        else if(__tossOpt_4.isSelected()){
            tossResult = 11;
        }
        else{
            tossResult = -1;
        }
    }
    
}
