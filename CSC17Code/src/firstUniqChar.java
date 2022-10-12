public class firstUniqChar {
    public void SolutionFirstUniqChar(String s) {
        char[] chrString = s.toCharArray();

        for(int i=0; i<s.length();i++){
            if(s.lastIndexOf(chrString[i])==s.indexOf(chrString[i])){
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String args[]) {
        firstUniqChar test = new firstUniqChar(); 
        test.SolutionFirstUniqChar("ilovehofstra");
        test.SolutionFirstUniqChar("abracadabra");
    }
}
