
package LiveScores.Models;

import java.util.Date;

/**
 *
 * @author Debug Entity
 */

public class Match {
    public final String id;
    
    //Constructor
    public Match(String id,String token){
        this.id = id;
        this.token = token;
    }
    
    //Authenticate
    public boolean authToken(String str){
        return str.equals(token);
    }
    
    private String token;
    public Date datetime;
    public int innings;
    public Team team1;
    public Team team2;
    public int tossresult;
    public boolean isOver;
    public int matchresult;
    
}
