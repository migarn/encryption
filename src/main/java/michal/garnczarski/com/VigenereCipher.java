package michal.garnczarski.com;

import java.util.ArrayList;

public class VigenereCipher extends Cipher {
	private String key;
	private ArrayList<Integer> keyList;
	private ArrayList<Character> reversedAlphabet;

	public VigenereCipher(String key, ArrayList<Character> alphabet) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null.");
		}
		
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
	protected ArrayList<Character> encryptDecryptList(ArrayList<Character> listToEncryptDecrypt,
			ArrayList<Character> alphabet) {
		ArrayList<Character> encryptedDecryptedList = new ArrayList<Character>();

		int keyIndex = 0;
		for (int i = 0; i < listToEncryptDecrypt.size(); i++) {
			char currentCharacter = listToEncryptDecrypt.get(i);

			if (alphabet.contains(currentCharacter)) {
				int indexOfCurrentCharacter = alphabet.indexOf(currentCharacter);
				int currentKey = keyList.get(keyIndex);
				encryptedDecryptedList.add(alphabet.get(indexOfCurrentCharacter + currentKey));
				keyIndex++;
			} else {
				encryptedDecryptedList.add(currentCharacter);
			}
			if (keyIndex == keyList.size()) {
				keyIndex = 0;
			}
		}

		return encryptedDecryptedList;
	}
}
