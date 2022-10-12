public class extFibProgression extends Progression {
    private long incrementNum;
    private boolean flag = false;

    extFibProgression(){
        first = 0;
        cur = 1;
        incrementNum = 1;
    }

    extFibProgression(long first, long cur){
        this.first = first;
        this.cur = cur;
        this.incrementNum = cur;
    }

    public long nextValue(){
        if(flag == true){
            cur = first + incrementNum;
            first = incrementNum;
            incrementNum = cur;  
            return cur;   
        } else {
            flag = true;
            return incrementNum;
        }        
    }
}
