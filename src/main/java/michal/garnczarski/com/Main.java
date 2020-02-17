package michal.garnczarski.com;

public class Main {
	static UIScanner uIScanner = new UIScanner();

	public static void main(String[] args) {
		System.out.println("This application enables encrypting and decrypting given text by means of two ciphers: Caesar cipher and Vigenere cipher.");
		mainMenu();
	}
	
	public static void mainMenu() {
		boolean inLoop = true;

		while (inLoop) {
			int choice = uIScanner.scanSelectionList("\nType:\n1 - to encrypt text\n2 - to decrypt text\n3 - to terminate", 1, 2, 3);
			
			if (choice == 1) {
				encryptDecryptMenu("encrypt");
			}
			else if (choice == 2) {
				encryptDecryptMenu("decrypt");
			}
			else if (choice == 3) {
				System.out.println("\nApplication terminated.");
				inLoop = false;
			}
		}
	}

	public static void encryptDecryptMenu(String mode) {
		int choice = uIScanner.scanSelectionList("\nType:\n1 - to use Caesar cipher\n2 - to use Vigenere cipher\n3 - to return", 1, 2, 3);
		
		if (choice == 1 && mode.equals("encrypt")) {
			encryptMenu("caesar");
		}
		else if (choice == 1 && mode.equals("decrypt")) {
			decryptMenu("caesar");
		}
		if (choice == 2 && mode.equals("encrypt")) {
			encryptMenu("vigenere");
		}
		else if (choice == 2 && mode.equals("decrypt")) {
			decryptMenu("vigenere");
		}
		else if (choice == 3) {
		}
	}

	private static void decryptMenu(String string) {
		// TODO Auto-generated method stub
		
	}

	private static void encryptMenu(String string) {
		// TODO Auto-generated method stub
		
	}
}
