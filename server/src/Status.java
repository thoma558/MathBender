
import java.awt.Color;


/**
 *
 * @author bonnerj
 */
public enum Status {
    PASS(new Color(0,255,0)),
    FAIL(new Color(255,0,0)),
    TESTING(new Color(255,255,255))
    ;
    
    public final Color color;
    
    Status(Color c){
        this.color = c;
    }
}
