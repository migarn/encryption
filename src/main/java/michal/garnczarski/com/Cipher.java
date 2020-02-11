package michal.garnczarski.com;

public abstract class Cipher {
	protected int key;
	protected char[] alphabet;
	
	public abstract String encryptWithSpacesAndPunctuation(String textToEncrypt);
	public abstract String encryptOnlyLetters(String textToEncrypt);	
	public abstract String decrypt(String textToDecrypt);
	
	protected char[] stringToArray(String string) {
		char[] stringAsArray = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			stringAsArray[i] = Character.toUpperCase(string.charAt(i));
		}
		return stringAsArray;
	}
	
	protected char[] onlyLettersToArray(String string) {
		
		String onlyLetters = string.replaceAll("[^A-Za-z]+", "");
		return stringToArray(onlyLetters);
	}
}

