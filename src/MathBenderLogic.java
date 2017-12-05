
/**
 *
 * @author bonnerj
 */
public class MathBenderLogic extends Thread{
    
    private MathBender applet;
    private boolean keepRunning;
    private int difficulty;
    private MathBlenderKeyListener listener;
    
    public MathBenderLogic(MathBender mb){
        this.applet = mb;
        keepRunning = false;
        difficulty = 2;
    }
    
    public void setMBKeyListener(MathBlenderKeyListener listener){
        this.listener = new MathBlenderKeyListener(this);
    }
    
    @Override
    public void run(){
        keepRunning = true;
        while(keepRunning){
            Problem p = Problem.generateProblem(difficulty);
            difficulty++;
            applet.setProblem(p);
            applet.repaint();
            delay(5000);
            int answer = Integer.decode(listener.getAndClearBuffer());
            boolean result = p.checkAnswer(answer);
            if(!result){
                keepRunning = false;
                applet.gameLost();
            }else{
                applet.addScore(difficulty + answer / 2);
            }
        }
    }
    
    private void delay(long time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            
        }
    }
    
    public void exit(){
        this.keepRunning = false;
    }
    
    
}
