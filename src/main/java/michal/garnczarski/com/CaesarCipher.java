package michal.garnczarski.com;

import java.util.ArrayList;

public class CaesarCipher extends Cipher {
	private int key;
	private ArrayList<Character> reversedAlphabet;
	
	public CaesarCipher(int key, ArrayList<Character> alphabet) {
		int alphabetLength = alphabet.size();
		if (key > alphabetLength || key < 0) {
			throw new IllegalArgumentException("Key cannot be greater than alphabet length nor negative.");
		}
		
		this.key = key;
		this.alphabet = new ArrayList<Character>();
		this.reversedAlphabet = new ArrayList<Character>();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < alphabetLength; j++) {
				this.alphabet.add(alphabet.get(j));
				this.reversedAlphabet.add(alphabet.get(alphabetLength - 1 - j));
			}
		}
	}

	@Override
	public String encryptWithSpacesAndPunctuation(String textToEncrypt) {
		if (textToEncrypt == null) {
			throw new IllegalArgumentException("Text to convert cannot be null.");
		}
		
		return listToString(encryptDecryptList(stringToList(textToEncrypt), this.alphabet));
	}

	@Override
	public String encryptOnlyLetters(String textToEncrypt) {
		if (textToEncrypt == null) {
			throw new IllegalArgumentException("Text to convert cannot be null.");
		}
		
		return listToString(encryptDecryptList(onlyLettersToArray(textToEncrypt), this.alphabet));
	}
	
	@Override
	public String decrypt(String textToDecrypt) {
		if (textToDecrypt == null) {
			throw new IllegalArgumentException("Text to convert cannot be null.");
		}
		
		return listToString(encryptDecryptList(stringToList(textToDecrypt), this.reversedAlphabet));
	}
	
	private ArrayList<Character> encryptDecryptList(ArrayList<Character> listToEncryptDecrypt, ArrayList<Character> alphabet) {
		ArrayList<Character> encryptedDecryptedList = new ArrayList<Character>();
		
		for (int i = 0; i < listToEncryptDecrypt.size(); i++) {
			char currentCharacter = listToEncryptDecrypt.get(i);
			
			if (alphabet.contains(currentCharacter)) {
				int indexOfCurrentCharacter = alphabet.indexOf(currentCharacter);
				encryptedDecryptedList.add(alphabet.get(indexOfCurrentCharacter + this.key));
			}
			else {
				encryptedDecryptedList.add(currentCharacter);
			}
		}
		
		return encryptedDecryptedList;
	}
}