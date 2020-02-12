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
	
	private ArrayList<Character> encryptList(ArrayList<Character> listToEncrypt) {
		ArrayList<Character> encryptedList = new ArrayList<Character>();
		
		for (int i = 0; i < listToEncrypt.size(); i++) {
			char currentCharacter = listToEncrypt.get(i);
			
			if (this.alphabet.contains(currentCharacter)) {
				int indexOfCurrentCharacter = alphabet.indexOf(currentCharacter);
				encryptedList.add(alphabet.get(indexOfCurrentCharacter + this.key));
			}
			else {
				encryptedList.add(currentCharacter);
			}
		}
		
		return encryptedList;
	}
}