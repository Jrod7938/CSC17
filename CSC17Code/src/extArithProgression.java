public class extArithProgression extends Progression {
    private long incrementNum;

    extArithProgression(){
        first = 0;
        cur = 1;
        incrementNum = 1;
    }

    extArithProgression(long first, long cur){
        this.first = first;
        this.cur = cur;
        this.incrementNum = cur;
    }

    public long nextValue() {
        cur += incrementNum;
        return cur; 
   }
}
