
import java.applet.Applet;
import java.awt.*;


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
    private MathBenderKeyListener listener;
    private String username;
    
    public MathBender(){
        try{
            username = this.getParameter("username");
        }catch (NullPointerException e){
            username = "Test_User";
        }
        score = 0;
        difficulty = 2; //initialy, goes up with time
        logicThread = new MathBenderLogic(this);
        listener = new MathBenderKeyListener(logicThread);
        logicThread.setMBKeyListener(listener);
        isShutdown = false;
        this.addKeyListener(listener);
        setFocusable(true);
        requestFocusInWindow();
        setVisible(true);
        setBackground(new Color(0, 255, 255));
    }
    
    @Override
    public void init(){
        this.setVisible(true);
        this.setSize(new Dimension(800, 400));
        logicThread.start();
    }
    
    @Override
    public void destroy(){
        logicThread.exit();
        shutdown();
    }
    
    public void setProblem(Problem p){
        this.currentProblem = p;
    }
    
    private void shutdown(){
        isShutdown = true;
        writeScoretoDB();
        //write score to database
    }

    private void writeScoretoDB(){
        DBConnector connector = new DBConnector();
        connector.addScore(username, score);
    }
    
    public void addScore(int amount){
        this.score = score + amount;
    }
    
    public void gameLost(){
        shutdown();
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        if(isShutdown){
            g.drawString("Final Score = " + score, 20,40);
            g.drawString("Refresh the page to try again", 20, 80);
            return;
        }
        if(currentProblem == null) return;
        g.drawString(currentProblem.toString() + listener.getBuffer(), 120, 180);
        g.drawString("You have 5 seconds per question, Good Luck.                    Score: " + score, 40, 40);
    }
    
    
}
