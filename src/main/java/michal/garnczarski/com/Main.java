package michal.garnczarski.com;

public class Main {
	static UIScanner uIScanner = new UIScanner();

	public static void main(String[] args) {
		boolean inLoop = true;

		while (inLoop) {
			System.out.println("Program enables encrypting and decrypting a given text by means of two ciphers: Caesar cipher and Vigenere cipher.");

			int choice = uIScanner.scanSelectionList("\nType:\n1 - to encrypt text\n2 - to decrypt text\n3 - to terminate", 1, 2, 3);
			switch (choice) {
				case 1:
					encrypt();
				case 2:
					decrypt();
				case 3:
					inLoop = false;
			}
		}
	}

	public static void encrypt() {
		int choice = uIScanner.scanSelectionList("\nType:\n1 - to use Caesar cipher\n2 - to use Vigenere cipher\n3 - to return", 1, 2, 3);
		switch (choice) {
			case 1:
				encryptInCaesarCipher();
			case 2:
				encryptInVigenereCipher();
			case 3:
				//inLoop = false;
	}

	}

	private static void encryptInVigenereCipher() {
		// TODO Auto-generated method stub
		
	}

	private static void encryptInCaesarCipher() {
		// TODO Auto-generated method stub
		
	}

	public static void decrypt() {

	}
}
