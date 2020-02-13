package michal.garnczarski.com;

import java.util.ArrayList;

public class VigenereCipher extends Cipher {
	private String key;
	private ArrayList<Integer> keyList;
	private ArrayList<Character> reversedAlphabet;
	
	public VigenereCipher(String key, ArrayList<Character> alphabet) {
		this.keyList = new ArrayList<Integer>();
		for (int i = 0; i < key.length(); i++) {
			char keyCharacter = Character.toUpperCase(key.charAt(i));
			if (!alphabet.contains(keyCharacter)) {
				throw new IllegalArgumentException("All key characters must be contained in given alphabet.");
			}
			this.keyList.add(alphabet.indexOf(keyCharacter));
		}
		
		this.key = key;
		this.alphabet = new ArrayList<Character>();
		this.reversedAlphabet = new ArrayList<Character>();
		int alphabetLength = alphabet.size();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < alphabetLength; j++) {
				this.alphabet.add(alphabet.get(j));
				this.reversedAlphabet.add(alphabet.get(alphabetLength - 1 - j));
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


}
