public class Person {
    private String name;
    public Person(String name){ this.name = name; }
    public String toString(){ return name; }
    public boolean isAsleep(int hr){
        return 22 < hr || 7 > hr;
    }
    public void status(int hr){
        if(this.isAsleep(hr)){
            System.out.println("Now Offline: " + this);
        }else{
            System.out.println("Now Online: " + this);
        }
    }
}

