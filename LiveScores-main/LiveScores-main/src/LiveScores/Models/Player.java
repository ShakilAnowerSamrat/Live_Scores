/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package LiveScores.Models;

/**
 *
 * @author Debug Entity
 */

enum MatchRoll{
    BOWLER,
    BATSMAN,
    KEEPER,
    ALLROUNDER
}


public class Player {
    public final String pid;
    
    //Constructor
    public Player(String name,String pid,String key){
        this.pid = pid;
        this.name = name;
        secretKey = key;
    }
    
    public boolean matchKey(String key){
        return key.equals(secretKey);
    }
    private String secretKey;
    public String name;
    public int jerseyNum;
    public MatchRoll matchRoll;
}
