package michal.garnczarski.com;

import java.util.ArrayList;

import org.junit.Assert;
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
		vigenereCipher = new VigenereCipher("cba", alphabet);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeyNotContainedInAlphabet() {
		vigenereCipher = new VigenereCipher("ala", alphabet);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullKey() {
		vigenereCipher = new VigenereCipher(null, alphabet);
	}
	
	@Test
	public void encryptWithSpacesAndPunctuationTest() {
		Assert.assertEquals("ABBC, CAAB.", vigenereCipher.encryptWithSpacesAndPunctuation("Baba, baba."));
	}

}
