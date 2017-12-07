
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author bonnerj
 */
public class MathBenderKeyListener implements KeyListener{
    
    private MathBenderLogic logicThread;
    private String buffer;
    private final Object BUFFER_LOCK = new Object();
    
    public MathBenderKeyListener(MathBenderLogic logicThread){
        this.logicThread = logicThread;
        buffer = "";
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        synchronized(BUFFER_LOCK){
            char c = e.getKeyChar();
            System.out.println("Key event: " + c + " Buffer: " + buffer);
            if((c >= '0' && c <= '9') || (c == '-' && buffer.length() == 0)){
                buffer = buffer + c;
            }
            System.out.println("Buffer after: " + buffer);
        }
        logicThread.forceRepaint();
    }
    
    public String getBuffer(){
        synchronized(BUFFER_LOCK){
            System.out.println("getting buffer: " + buffer);
            return buffer;
        }
    }
    
    public String getAndClearBuffer(){
        synchronized(BUFFER_LOCK){
            String temp = buffer;
            buffer = "";
            System.out.println("(cleared) Buffer: " + temp);
            return temp;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        synchronized(BUFFER_LOCK){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                logicThread.interrupt(); //hopefully this hits during the 5000 ms sleep
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
