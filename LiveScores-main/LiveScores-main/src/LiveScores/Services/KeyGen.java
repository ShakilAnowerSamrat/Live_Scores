
package LiveScores.Services;


import java.util.Random;


/**
 *
 * @author Debug Entity
 */

public class KeyGen {
    
    private static final String CHARS = "!@#$%^&*()_+<>?-=ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    
    private static int LENGTH = 50;
    
    public static String generateKey(){
        StringBuilder key = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<LENGTH;i++){
            int index = random.nextInt(CHARS.length());
            key.append(CHARS.charAt(index));
        }        
        return key.toString();
    }
    
    public static void setLength(int length){
        if(length > 0 && length <= 256){
            LENGTH = length;
        }
    }
    
}
