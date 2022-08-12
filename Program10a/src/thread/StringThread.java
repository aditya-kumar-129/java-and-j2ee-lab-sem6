package thread;
import java.util.*;

public class StringThread extends Thread {
	Scanner sc = new Scanner(System.in);
	public void run() {
		System.out.println("Enter the string:- ");
		String input_string = sc.nextLine();
		String vowels = "aeiou";
		int count=0;
		for(char c : input_string.toCharArray()) {
			for(char vowel : vowels.toCharArray()) {
				if(c == vowel) {
					count++;
				}
			}
		}
		
		System.out.println("The number of vowels present in the input string is :- " + count);
	}
}	
