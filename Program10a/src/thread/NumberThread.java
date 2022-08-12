package thread;
import java.util.*;

public class NumberThread extends Thread {
	Scanner sc = new Scanner(System.in);
	public void run() {
		System.out.println("Enter a number");
		String number = sc.nextLine();
		String digit [] = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String res = "";
		for(char c : number.toCharArray())
			res+= (digit[c-'0'] + " ");
		
		System.out.println("Resultant number is :- " + res);
	}
}