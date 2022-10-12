// Program to show Fibonacci Progression

public class FibProgression {
    private long firstNum;
    private long secondNum;
    private long currentNum;

    public FibProgression(long firstNum, long secondNum){
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        
    }

    public long firstValue(){
        return firstNum;
    }

    public long secondValue(){
        return secondNum;
    }

    public long nextValue(){
        currentNum = firstNum + secondNum;
        firstNum = secondNum;
        secondNum = currentNum; 
        return currentNum;
    }

    public void printProgression(int n) {
        System.out.print(firstValue() + " " + secondValue());
        for (int i = 3; i <= n; i++){
            System.out.print(" " + nextValue());
        }
    }
}
