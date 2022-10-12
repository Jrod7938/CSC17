// Program to show Arithmetic Progression
public class ArithProgression {
    private long firstNum;
    private long currentNum;
    private long difference;

    public ArithProgression(long first, long diff){
        firstNum = first;
        currentNum = first;
        difference = diff;
    }

    public long nextValue() {
        currentNum += difference;
        return currentNum; 
   }

   public long firstValue(){
        return firstNum;
   }

   public long differenceValue(){
        return difference;
}

   public void printProgression(int n) {
        System.out.print(firstValue());
        for (int i = 2; i <= n; i++){
            System.out.print(" " + nextValue());
        }
    }
}
