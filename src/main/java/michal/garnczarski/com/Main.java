package michal.garnczarski.com;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ArrayList<Character> latinAlphabetSigns = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
		ArrayList<Character> polishAlphabetSigns = new ArrayList<Character>(Arrays.asList('A', '•', 'B', 'C', '∆', 'D', 'E', ' ', 'F', 'G', 'H', 'I', 'J', 'K', 'L', '£', 'M', 'N', '—', 'O', '”', 'P', 'R', 'S', 'å', 'T', 'U', 'W', 'Y', 'Z', 'è', 'Ø'));
		ArrayList<Character> polishExtendedAlphabetSigns = new ArrayList<Character>(Arrays.asList('A', '•', 'B', 'C', '∆', 'D', 'E', ' ', 'F', 'G', 'H', 'I', 'J', 'K', 'L', '£', 'M', 'N', '—', 'O', '”', 'P', 'Q', 'R', 'S', 'å', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'è', 'Ø'));
		Alphabet latinAlphabet = new Alphabet("Latin alphabet", latinAlphabetSigns);
		Alphabet polishAlphabet = new Alphabet("Polish alphabet", polishAlphabetSigns);
		Alphabet polishExtendedAlphabet = new Alphabet("Polish extended alphabet", polishExtendedAlphabetSigns);
		AlphabetsList alphabetsList = new AlphabetsList();
		alphabetsList.addAlphabet(latinAlphabet);
		alphabetsList.addAlphabet(polishAlphabet);
		alphabetsList.addAlphabet(polishExtendedAlphabet);
		
		System.out.println("This application enables encrypting and decrypting given text by means of two ciphers: Caesar cipher and Vigenere cipher.");
				
		UserInterface userInterface = new UserInterface(alphabetsList);
		userInterface.mainMenu();
	}
}
