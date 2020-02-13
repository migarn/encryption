package michal.garnczarski.com;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VigenereCipherTest {
	private VigenereCipher vigenereCipher;
	private ArrayList<Character> alphabet;
	
	@Before
	public void createVigenereCipherForTheTest() {
		alphabet = new ArrayList<Character>();
		alphabet.add('A');
		alphabet.add('B');
		alphabet.add('C');
		vigenereCipher = new VigenereCipher("baba", alphabet);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeyNotContainedInAlphabet() {
		vigenereCipher = new VigenereCipher("ala", alphabet);
	}

}
