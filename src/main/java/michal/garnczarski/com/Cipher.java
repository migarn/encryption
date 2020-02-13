package michal.garnczarski.com;

import java.util.ArrayList;

public abstract class Cipher {
	protected ArrayList<Character> alphabet;
	protected ArrayList<Character> reversedAlphabet;
	
	protected abstract ArrayList<Character> encryptDecryptList(ArrayList<Character> listToEncryptDecrypt, ArrayList<Character> alphabet);
	
	public String encryptWithSpacesAndPunctuation(String textToEncrypt) {
		if (textToEncrypt == null) {
			throw new IllegalArgumentException("Text to convert cannot be null.");
		}
		
		return listToString(encryptDecryptList(stringToList(textToEncrypt), this.alphabet));
	}

	public String encryptOnlyLetters(String textToEncrypt) {
		if (textToEncrypt == null) {
			throw new IllegalArgumentException("Text to convert cannot be null.");
		}
		
		return listToString(encryptDecryptList(onlyLettersToArray(textToEncrypt), this.alphabet));
	}
	
	public String decrypt(String textToDecrypt) {
		if (textToDecrypt == null) {
			throw new IllegalArgumentException("Text to convert cannot be null.");
		}
		
		return listToString(encryptDecryptList(stringToList(textToDecrypt), this.reversedAlphabet));
	}
	
	protected ArrayList<Character> stringToList(String string) {
		ArrayList<Character> stringAsList = new ArrayList<Character>();
		for (int i = 0; i < string.length(); i++) {
			stringAsList.add(Character.toUpperCase(string.charAt(i)));
		}
		return stringAsList;
	}
	
	protected ArrayList<Character> onlyLettersToArray(String string) {
		String onlyLetters = string.replaceAll("[^A-Za-z]+", "");
		return stringToList(onlyLetters);
	}
	
	protected String listToString(ArrayList<Character> listToBeConverted) {
		StringBuilder convertedList = new StringBuilder();
		
		for (char character : listToBeConverted) {
			convertedList.append(character);
		}
		
		return convertedList.toString();
	}
}

