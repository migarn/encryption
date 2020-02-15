package michal.garnczarski.com;

public class Main {
	static UIScanner uIScanner = new UIScanner();

	public static void main(String[] args) {
		System.out.println("Program enables encrypting and decrypting a given text by means of two ciphers: Caesar cipher and Vigenere cipher.");
		boolean inLoop = true;

		while (inLoop) {
			int choice = uIScanner.scanSelectionList("\nType:\n1 - to encrypt text\n2 - to decrypt text\n3 - to terminate", 1, 2, 3);
			switch (choice) {
				case 1:
					encrypt();
					break;
				case 2:
					decrypt();
					break;
				case 3:
					inLoop = false;
					break;
			}
		}
	}

	public static void encrypt() {
		int choice = uIScanner.scanSelectionList("\nType:\n1 - to use Caesar cipher\n2 - to use Vigenere cipher\n3 - to return", 1, 2, 3);
		switch (choice) {
			case 1:
				encryptInCaesarCipher();
				break;
			case 2:
				encryptInVigenereCipher();
				break;
			case 3:
				break;
		}
	}
	
	public static void decrypt() {

	}

	private static void encryptInVigenereCipher() {
		// TODO Auto-generated method stub
		
	}

	private static void encryptInCaesarCipher() {
		// TODO Auto-generated method stub
		
	}
}
