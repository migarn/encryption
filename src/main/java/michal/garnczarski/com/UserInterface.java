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

	public void encryptDecryptMenu(char encryptDecryptMode) {
		int choice = uIScanner.scanSelectionList("\nType:\n1 - to use Caesar cipher\n2 - to use Vigenere cipher\n3 - to return", 1, 2, 3);
		
		if (choice == 1 && encryptDecryptMode == 'e') {
			chooseAlphabetMenu('e', 'c');
		}
		else if (choice == 1 && encryptDecryptMode == 'd') {
			chooseAlphabetMenu('d', 'c');
		}
		if (choice == 2 && encryptDecryptMode == 'e') {
			chooseAlphabetMenu('e', 'v');
		}
		else if (choice == 2 && encryptDecryptMode == 'd') {
			chooseAlphabetMenu('d', 'v');
		}
		else if (choice == 3) {
		}
	}

	private void chooseAlphabetMenu(char encryptDecryptMode, char cipherMode) {
		int menuSize = alphabetsList.getAlphabets().size() + 1;
		int[] menuChoices = new int[menuSize];
		
		StringBuilder buildInstruction = new StringBuilder("\nType:");
		for (int i = 0; i < menuSize - 1; i++) {
			menuChoices[i] = i;
			buildInstruction.append("\n" + (i + 1) + " - to use " + alphabetsList.getAlphabetName(i));
		}
		buildInstruction.append("\n" + menuSize + " - to return");
		
		String instruction = buildInstruction.toString();

		
		int choice = uIScanner.scanSelectionList(instruction, menuChoices);
		 
		
	}

	private void typeTextMenu(char encryptDecryptMode, char cipherMode) {
		int choice = uIScanner.scanSelectionList("\nType:\n1 - to type text\n2 - to return", 1, 2);
		
		if (choice == 1) {
			String textToEncryptDecrypt = uIScanner.scanString("/nPlease type text to convert:");
			
			if (encryptDecryptMode == 'e' && cipherMode == 'c') {
				
			}
			
		}
		else if (choice == 2) {
		}		
	}

	private static void encryptMenu(char mode) {
		// TODO Auto-generated method stub
		
	}
	
	private static void decryptMenu(char mode) {
		// TODO Auto-generated method stub
		
	}

}
