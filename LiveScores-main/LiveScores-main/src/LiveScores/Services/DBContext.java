
package LiveScores.Services;


import java.sql.*; //DB operations!

//User defined classes!

/**
 *
 * @author Debug Entity
 */

public class DBContext {
    public Connection getConnection() throws SQLException{
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livescores","root", "--mySQL");
        return connection;
    }
    
}
