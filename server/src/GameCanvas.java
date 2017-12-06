
import java.awt.Canvas;
import java.awt.Graphics;


/**
 *
 * @author bonnerj
 */
public class GameCanvas extends Canvas{
    
    private Problem currentProblem;
    private Status status;
    
    public GameCanvas(){
        super();
        //this.addKeyListener(l);
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
    }
    
    public void setProblem(Problem p){
        this.currentProblem = p;
    }
    
    public void setStatus(Status stat){
        this.status = stat;
    }
    
    public void update(){
        this.repaint();
    }

    public Problem getCurrentProblem() {
        return currentProblem;
    }
    public Status getStatus() {
        return status;
    }
}
