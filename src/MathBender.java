
import java.applet.Applet;
import java.awt.Graphics;


/**
 *
 * @author bonnerj
 */
public class MathBender extends Applet{
    
    private int score;
    private Problem currentProblem;
    private MathBenderLogic logicThread;
    private int difficulty;
    private boolean isShutdown;
    private MathBlenderKeyListener listener;
    
    public MathBender(){
        score = 0;
        difficulty = 2; //initialy, goes up with time
        logicThread = new MathBenderLogic(this);
        listener = new MathBlenderKeyListener(logicThread);
        logicThread.setMBKeyListener(listener);
        isShutdown = false;
        
    }
    
    @Override
    public void start(){
        this.setVisible(true);
        logicThread.start();
    }
    
    @Override
    public void stop(){
        logicThread.exit();
        shutdown();
    }
    
    public void setProblem(Problem p){
        this.currentProblem = p;
    }
    
    private void shutdown(){
        isShutdown = true;
        //write score to database
    }
    
    public void addScore(int amount){
        this.score = score + amount;
    }
    
    public void gameLost(){
        shutdown();
    }
    
    @Override
    public void paint(Graphics g) {
        //g.setFont(Font.);
        if(isShutdown){
            g.drawString("Refresh the page to try again", 20, 20);
            return;
        }
        g.drawString(currentProblem.toString() + listener.getBuffer(), 120, 120);
        g.drawString("You have 5 seconds per question, Good Luck.                    Score: " + score, 20, 20);
    }
    
    
}
