package michal.garnczarski.com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String scanString(String instruction) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println(instruction);
        return scanner.nextLine();
    }

}
