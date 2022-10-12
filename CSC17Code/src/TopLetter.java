public class TopLetter {
	
	static char getMostFrequentChar(String str){
		char max = ' ';
		int counter = 0;
		int[] charcnt = new int[Character.MAX_VALUE+1];

		for (int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);

			charcnt[ch]++;
			if (charcnt[ch] >= counter){
				counter = charcnt[ch];
				max = ch;
			} 
		}
				
	    return max;
	}
  
 public static void main(String[] args)
 {
     String str1 = "abracadabra";
     String str2 = "Supercalifragilisticexpialidocious";
     System.out.println(getMostFrequentChar(str1));
     System.out.println(getMostFrequentChar(str2));
 }
}