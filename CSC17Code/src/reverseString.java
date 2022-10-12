public class reverseString {
	public String SolutionReverseString(String s) {
		char ch;
        String str = "";

        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            str = ch+str;
        }
		return str;
	}
	
	public static void main(String args[]) {
		reverseString test = new reverseString();
		System.out.println(test.SolutionReverseString("hello"));
		System.out.println(test.SolutionReverseString("A man, a plan, a canal: Panama"));
	}
}