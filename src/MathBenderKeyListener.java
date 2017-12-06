
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author bonnerj
 */
public class MathBenderKeyListener implements KeyListener{
    
    private MathBenderLogic logicThread;
    private String buffer;
    
    public MathBenderKeyListener(MathBenderLogic logicThread){
        this.logicThread = logicThread;
        buffer = "";
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            logicThread.interrupt(); //hopefully this hits during the 5000 ms sleep
        }
        if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
            buffer = buffer + e.getKeyChar();
        }
    }
    
    public String getBuffer(){
        return this.buffer;
    }
    
    public String getAndClearBuffer(){
        String temp = buffer;
        buffer = "";
        return temp;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            logicThread.interrupt(); //hopefully this hits during the 5000 ms sleep
        }
        if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
            buffer = buffer + e.getKeyChar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
