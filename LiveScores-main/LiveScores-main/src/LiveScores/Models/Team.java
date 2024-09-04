
package LiveScores.Models;

/**
 *
 * @author Debug Entity
 */

public class Team {
    public final String tid;
    
    //Constructor
    public Team(String name,String tid){
        this.tid = tid;
        this.name = name;
    }
    
    //Team name
    public String name;
    //Captain
    public Player captain;
    //Players
    public Player player1;
    public Player player2;
    public Player player3;
    public Player player4;
    public Player player5;
    public Player player6;
    public Player player7;
    public Player player8;
    public Player player9;
    public Player player10;
}
