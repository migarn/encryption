package michal.garnczarski.com;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		alphabet.add('A');
		alphabet.add('B');
		alphabet.add('C');
		CaesarCipher caesarCipher = new CaesarCipher(3, alphabet);

	}

}
