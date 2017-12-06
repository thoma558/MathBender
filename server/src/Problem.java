
import java.util.Random;



/**
 *
 * @author bonnerj
 */
public class Problem {
    
    private int num1;
    private int num2;
    private Operator operator;
    
    public Problem(int num1, int num2, Operator operator){
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
    
    public int getNum1(){
        return this.num1;
    }
    
    public int getNum2(){
        return this.num2;
    }
    
    public Operator getOperator(){
        return this.operator;
    }
    
    public boolean checkAnswer(int answer){
        return answer == operator.evaluate(num1, num2);
    }
    
    public static Problem generateProblem(int difficulty){
        Random ann = new Random();
        int num1 = ann.nextInt(difficulty);
        int num2 = ann.nextInt(difficulty);
        Operator op = generateOperater();
        return new Problem(num1, num2, op);
    }
    
    private static Operator generateOperater(){
        Random ann = new Random();
        if(ann.nextBoolean()){
            return Operator.ADD;
        }else if(ann.nextBoolean()){
            return Operator.SUBTRACT;
        }else if(ann.nextBoolean()){
            return Operator.MULTIPLY;
        }else if(ann.nextBoolean()){
            return Operator.DIVID;
        }else{
            return Operator.MOD;
        }
    }

    public String toString(){
        return (num1 + operator.stringRep + num2);
    }
    
}
