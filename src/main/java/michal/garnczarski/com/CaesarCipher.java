package michal.garnczarski.com;

import java.util.ArrayList;

public class CaesarCipher extends Cipher {
	
	public CaesarCipher(int key, ArrayList<Character> alphabet) {
		int alphabetLength = alphabet.size();
		if (key > alphabetLength) {
			throw new IllegalArgumentException("Key cannot be greater than alphabet length.");
		}
		else {
			this.key = key;
			this.alphabet = new ArrayList<Character>();
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < alphabetLength; j++) {
					this.alphabet.add(alphabet.get(j));
				}
			}
		}
	}

	@Override
	public String encryptWithSpacesAndPunctuation(String textToEncrypt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encryptOnlyLetters(String textToEncrypt) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String decrypt(String textToDecrypt) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private char[] encryptArray(char[] arrayToEncrypt) {
//		char[] encryptedArray = new char[arrayToEncrypt.length];
//		for (int i = 0; i < arrayToEncrypt.length; i++) {
//			encryptedArray[i] = 
//		}
//	}
}