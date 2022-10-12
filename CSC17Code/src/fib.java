public class fib {
    
    public static void main(String[] args) {
        fib myobject = new fib();
        myobject.fibseq(20);
    }

    public void fibseq(int n){
        for(int i = 1; i <= n; i++){
            System.out.print(fib1(i) + " ");
        }
    }

    private int fib1(int n){
        // Error handling
        if(n < 0){
            System.out.println("N should be positive");
            return -1;
        }

        if(n <= 2){
            System.out.print(n);
            return n;
        } else {
            int a = 0,
                b = 1,
                c = -1;

            for(int i = 3; i <= n; i++){
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
