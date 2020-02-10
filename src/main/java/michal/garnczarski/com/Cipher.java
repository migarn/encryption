package michal.garnczarski.com;

public abstract class Cipher {
	public abstract String encrypt(String textToEncrypt);
	public abstract String decrypt(String textToDecrypt);
	
	public char[] stringToArray(String string) {
		char[] stringAsArray = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			stringAsArray[i] = Character.toUpperCase(string.charAt(i));
		}
		return stringAsArray;
	}
}

