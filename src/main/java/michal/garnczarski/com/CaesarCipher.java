package michal.garnczarski.com;

import java.util.LinkedList;

public class CaesarCipher implements Cipher {
	private int key;
	private LinkedList<String> alphabet;
	
	public CaesarCipher(int key, LinkedList<String> alphabet) {
		if (key > alphabet.size()) {
			throw new IllegalArgumentException("Key cannot be greater than alphabet length.");
		}
		else {
			this.key = key;
		}
		this.alphabet = alphabet;
	}

	@Override
	public String encrypt(String textToEncrypt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String textToDecrypt) {
		// TODO Auto-generated method stub
		return null;
	}

}