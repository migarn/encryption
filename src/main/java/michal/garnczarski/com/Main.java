package michal.garnczarski.com;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static UIScanner uIScanner = new UIScanner();
	static ArrayList<Character> latinAlphabetSigns = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
	static ArrayList<Character> polishAlphabetSigns = new ArrayList<Character>(Arrays.asList('A', '•', 'B', 'C', '∆', 'D', 'E', ' ', 'F', 'G', 'H', 'I', 'J', 'K', 'L', '£', 'M', 'N', '—', 'O', '”', 'P', 'R', 'S', 'å', 'T', 'U', 'W', 'Y', 'Z', 'è', 'Ø'));
	static ArrayList<Character> polishExtendedAlphabetSigns = new ArrayList<Character>(Arrays.asList('A', '•', 'B', 'C', '∆', 'D', 'E', ' ', 'F', 'G', 'H', 'I', 'J', 'K', 'L', '£', 'M', 'N', '—', 'O', '”', 'P', 'Q', 'R', 'S', 'å', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'è', 'Ø'));
	static Alphabet latinAlphabet = new Alphabet("Latin alphabet", latinAlphabetSigns);
	static Alphabet polishAlphabet = new Alphabet("Polish alphabet", polishAlphabetSigns);
	static Alphabet polishExtendedAlphabet = new Alphabet("Polish extended alphabet", polishExtendedAlphabetSigns);
	static AlphabetsList alphabetsList = new AlphabetsList();

	public static void main(String[] args) {
		alphabetsList.addAlphabet(latinAlphabet);
		alphabetsList.addAlphabet(polishAlphabet);
		alphabetsList.addAlphabet(polishExtendedAlphabet);
		System.out.println("This application enables encrypting and decrypting given text by means of two ciphers: Caesar cipher and Vigenere cipher.");
		mainMenu();
	}
	
	public static void mainMenu() {
		boolean inLoop = true;

		while (inLoop) {
			int choice = uIScanner.scanSelectionList("\nType:\n1 - to encrypt text\n2 - to decrypt text\n3 - to terminate", 1, 2, 3);
			
			if (choice == 1) {
				encryptDecryptMenu('e');
			}
			else if (choice == 2) {
				encryptDecryptMenu('d');
			}
			else if (choice == 3) {
				System.out.println("\nApplication terminated.");
				inLoop = false;
			}
		}
	}

	public static void encryptDecryptMenu(char mode) {
		int choice = uIScanner.scanSelectionList("\nType:\n1 - to use Caesar cipher\n2 - to use Vigenere cipher\n3 - to return", 1, 2, 3);
		
		if (choice == 1 && mode == 'e') {
			encryptMenu("caesar");
		}
		else if (choice == 1 && mode == 'd') {
			decryptMenu("caesar");
		}
		if (choice == 2 && mode == 'e') {
			encryptMenu("vigenere");
		}
		else if (choice == 2 && mode == 'd') {
			decryptMenu("vigenere");
		}
		else if (choice == 3) {
		}
	}

	private static void encryptMenu(String string) {
		// TODO Auto-generated method stub
		
	}
	
	private static void decryptMenu(String string) {
		// TODO Auto-generated method stub
		
	}
}
