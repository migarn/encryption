package michal.garnczarski.com;

public class CaesarCipher extends Cipher {
	
	public CaesarCipher(int key, char[] alphabet) {
		int alphabetLength = alphabet.length;
		if (key > alphabetLength) {
			throw new IllegalArgumentException("Key cannot be greater than alphabet length.");
		}
		else {
			this.key = key;
		}
		this.alphabet = new char[2 * alphabetLength];
		
		for (int i = 0; i < alphabetLength; i++) {
			this.alphabet[i] = alphabet[i];
			this.alphabet[alphabetLength + i] = alphabet[i];		
		}
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