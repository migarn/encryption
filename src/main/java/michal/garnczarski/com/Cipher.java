package michal.garnczarski.com;

import java.util.ArrayList;

public abstract class Cipher {
	protected ArrayList<Character> alphabet;
	
	public abstract String encryptWithSpacesAndPunctuation(String textToEncrypt);
	public abstract String encryptOnlyLetters(String textToEncrypt);	
	public abstract String decrypt(String textToDecrypt);
	
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
		
		for (Character character : listToBeConverted) {
			convertedList.append(character);
		}
		
		return convertedList.toString();
	}
}

