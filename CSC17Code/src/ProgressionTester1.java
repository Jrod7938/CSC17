
// Driver code to test Arithmetic & Fibonacci Progression

public class ProgressionTester1 {
    public static void main(String[] args) {
        // test Arith Progression
        ArithProgression prog = new ArithProgression(1, 1);
        System.out.println("Arithmetic progression with start value " + prog.firstValue() + " and increment " + prog.differenceValue() + ":");
        prog.printProgression(10);

        System.out.println();

        // test Fib Progression
        FibProgression fibprog = new FibProgression(1, 1);
        System.out.println("Fib progression with start value " + fibprog.firstValue() + " and second value " + fibprog.secondValue() + ":");
        fibprog.printProgression(10);
    }
}
