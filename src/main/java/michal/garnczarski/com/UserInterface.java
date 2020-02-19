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
				return chooseAlphabetMenu('e', 'c');
			}
			else if (choice == 1 && encryptDecryptMode == 'd') {
				return chooseAlphabetMenu('d', 'c');
			}
			if (choice == 2 && encryptDecryptMode == 'e') {
				return chooseAlphabetMenu('e', 'v');
			}
			else if (choice == 2 && encryptDecryptMode == 'd') {
				return chooseAlphabetMenu('d', 'v');
			}
			else if (choice == 3) {
				inLoop = false;
			}
		}
		return true;
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
				return typeKeyMenu(encryptDecryptMode, cipherMode, alphabetsList.getAlphabets().get(choice - 1));
			}
			if (choice == menuSize) {
				inLoop = false;
			}
		}
		return true;
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
					return typeTextMenu(encryptDecryptMode, cipher);
				}
				
				catch (IllegalArgumentException e) {
					System.out.println("\nPlease type correct key.");
				}
			}
		}
		return true;
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
						return encryptMenu(cipher, text);
					}
					else {
						System.out.println("\nDecrypted text:\n\n" + cipher.decrypt(text));
						return false;
					}
				}
				
				catch (IllegalArgumentException e) {
					System.out.println("\nPlease type correct text.");
				}
			}
		}
		return true;
	}

	private boolean encryptMenu(Cipher cipher, String text) {
		boolean inLoop = true;
		
		while (inLoop) {
			int choice = uIScanner.scanSelectionList("\nType:\n1 - to maintain spaces and punctuation\n2 - to omit spaces and punctuation\n3 - to return", 1, 2, 3);
			
			if (choice == 1) {
				System.out.println("\nEncrypted text:\n\n" + cipher.encryptWithSpacesAndPunctuation(text));
				return false;
			}
			else if (choice == 2) {
				System.out.println("\nEncrypted text:\n\n" + cipher.encryptOnlyLetters(text));
				return false;
			}
			else if (choice == 3) {
				inLoop = false;
			}
		}
		return true;
	}
}
