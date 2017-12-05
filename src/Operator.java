
/**
 *
 * @author bonnerj
 */
public enum Operator {
    ADD     ("+", (int num1, int num2) -> num1 + num2),
    SUBTRACT("-", (int num1, int num2) -> num1 - num2),
    MULTIPLY("X", (int num1, int num2) -> num1 * num2),
    DIVID   ("/", (int num1, int num2) -> num1 / num2),
    MOD     ("%", (int num1, int num2) -> num1 % num2)
    ;
    
    public final String stringRep;
    private final Eval evalFunc;
    
    Operator(String strRep, Eval tester){
        this.stringRep = strRep;
        this.evalFunc = tester;
    }
    
    public int evaluate(int numOne, int numTwo){
        return evalFunc.eval(numOne, numTwo);
    }
    
    private interface Eval{
        public int eval(int num1, int num2);
    }
}
