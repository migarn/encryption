package michal.garnczarski.com;

public class UserInterface {
	private AlphabetsList alphabetsList;
	private UIScanner uIScanner;
	
	public UserInterface(AlphabetsList alphabetsList) {
		this.alphabetsList = alphabetsList;
		uIScanner = new UIScanner();
	}

	public void mainMenu() {
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

	public boolean encryptDecryptMenu(char encryptDecryptMode) {
		boolean inLoop = true;
		
		while (inLoop) {
			int choice = uIScanner.scanSelectionList("\nType:\n1 - to use Caesar cipher\n2 - to use Vigenere cipher\n3 - to return", 1, 2, 3);
			
			if (choice == 1 && encryptDecryptMode == 'e') {
				if (chooseAlphabetMenu('e', 'c')) {
					return true;
				}
			}
			else if (choice == 1 && encryptDecryptMode == 'd') {
				if (chooseAlphabetMenu('d', 'c')) {
					return true;
				}
			}
			if (choice == 2 && encryptDecryptMode == 'e') {
				if (chooseAlphabetMenu('e', 'v')) {
					return true;
				}
			}
			else if (choice == 2 && encryptDecryptMode == 'd') {
				if (chooseAlphabetMenu('d', 'v')) {
					return true;
				}
			}
			else if (choice == 3) {
				inLoop = false;
			}
		}
		return false;
	}

	private boolean chooseAlphabetMenu(char encryptDecryptMode, char cipherMode) {
		boolean inLoop = true;
		
		while (inLoop) {
			int menuSize = alphabetsList.getAlphabets().size() + 1;
			int[] menuChoices = new int[menuSize];
					
			StringBuilder buildInstruction = new StringBuilder("\nType:");
			for (int i = 0; i < menuSize - 1; i++) {
				menuChoices[i] = i + 1;
				buildInstruction.append("\n" + (i + 1) + " - to use " + alphabetsList.getAlphabetName(i));
			}
			
			menuChoices[menuSize - 1] = menuSize;
			buildInstruction.append("\n" + menuSize + " - to return");
			String instruction = buildInstruction.toString();
			
			int choice = uIScanner.scanSelectionList(instruction, menuChoices);
			
			if (choice > 0 && choice < menuSize) {
				if (typeKeyMenu(encryptDecryptMode, cipherMode, alphabetsList.getAlphabets().get(choice - 1))) {
					return true;
				}
			}
			if (choice == menuSize) {
				inLoop = false;
			}
		}
		return false;
	}

	private boolean typeKeyMenu(char encryptDecryptMode, char cipherMode, Alphabet alphabet) {
		boolean inLoop = true;
		Cipher cipher;
		
		while (inLoop) {
			String key = uIScanner.scanString("\nType key or type -1 to return:");
						
			if (key.equals("-1")) {
				inLoop = false;
			}
			
			else {
				try {
					if (cipherMode == 'c') {
						int intKey = Integer.parseInt(key);
						cipher = new CaesarCipher(intKey, alphabet.getSigns());
					}
					else {
						cipher = new VigenereCipher(key, alphabet.getSigns());
					}
					if (typeTextMenu(encryptDecryptMode, cipher)) {
						return true;
					}
				}
				
				catch (IllegalArgumentException e) {
					System.out.println("\nPlease type correct key.");
				}
			}
		}
		return false;
	}

	private boolean typeTextMenu(char encryptDecryptMode, Cipher cipher) {
		boolean inLoop = true;
		
		while (inLoop) {
			String encryptDecrypt;
			if (encryptDecryptMode == 'e') {
				encryptDecrypt = "encrypt";
			}
			else {
				encryptDecrypt = "decrypt";
			}
			
			String text = uIScanner.scanString("\nType text to " + encryptDecrypt + " or type -1 to return:");
						
			if (text.equals("-1")) {
				inLoop = false;
			}
			
			else {
				try {
					if (encryptDecryptMode == 'e') {
						if (encryptMenu(cipher, text)) {
							return true;
						}
					}
					else {
						System.out.println("\nDecrypted text:\n" + cipher.decrypt(text));
						return true;
					}
				}
				
				catch (IllegalArgumentException e) {
					System.out.println("\nPlease type correct text.");
				}
			}
		}
		return false;
	}

	private boolean encryptMenu(Cipher cipher, String text) {
		boolean inLoop = true;
		
		while (inLoop) {
			int choice = uIScanner.scanSelectionList("\nType:\n1 - to maintain spaces, punctuation and symbols outside the selected alphabet\n2 - to reject spaces, punctuation and symbols outside the selected alphabet\n3 - to return", 1, 2, 3);
			
			if (choice == 1) {
				System.out.println("\nEncrypted text:\n" + cipher.encryptWithSpacesAndPunctuation(text));
				return true;
			}
			else if (choice == 2) {
				System.out.println("\nEncrypted text:\n" + cipher.encryptOnlyLetters(text));
				return true;
			}
			else if (choice == 3) {
				inLoop = false;
			}
		}
		return false;
	}
}
