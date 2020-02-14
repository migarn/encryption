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
	
	@Test
	public void keyAEncryptWithSpacesAndPunctuationTest() {
		vigenereCipher = new VigenereCipher("a", alphabet);
		Assert.assertEquals("BABA, BABA.", vigenereCipher.encryptWithSpacesAndPunctuation("Baba, baba."));
	}
	
	@Test
	public void keyAaAEncryptWithSpacesAndPunctuationTest() {
		vigenereCipher = new VigenereCipher("AaA", alphabet);
		Assert.assertEquals("BABA, BABA.", vigenereCipher.encryptWithSpacesAndPunctuation("Baba, baba."));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyAlphabetEncryptWithSpacesAndPunctuationTest() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		vigenereCipher = new VigenereCipher("cba", alphabet);
	}
	
	@Test
	public void emptyEncryptWithSpacesAndPunctuationTest() {
		Assert.assertEquals("", vigenereCipher.encryptWithSpacesAndPunctuation(""));
	}
	
	@Test
	public void encryptOnlyLettersTest() {
		Assert.assertEquals("ABBCCAAB", vigenereCipher.encryptOnlyLetters("Baba, baba."));
	}
	
	@Test
	public void keyAEncryptOnlyLettersTest() {
		vigenereCipher = new VigenereCipher("a", alphabet);
		Assert.assertEquals("BABABABA", vigenereCipher.encryptOnlyLetters("Baba, baba."));
	}
	
	@Test
	public void keyAaAEncryptOnlyLettersTest() {
		vigenereCipher = new VigenereCipher("AaA", alphabet);
		Assert.assertEquals("BABABABA", vigenereCipher.encryptOnlyLetters("Baba, baba."));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyAlphabetEncryptOnlyLettersTest() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		vigenereCipher = new VigenereCipher("cba", alphabet);
	}
	
	@Test
	public void emptyEncryptOnlyLettersTest() {
		Assert.assertEquals("", vigenereCipher.encryptOnlyLetters(""));
	}
}
