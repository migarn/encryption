package michal.garnczarski.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {
	private CaesarCipher caesarCipher;
	private ArrayList<Character> alphabet;
	
	@Before
	public void createCaesarCipherForTheTest() {
		alphabet = new ArrayList<Character>();
		alphabet.add('A');
		alphabet.add('B');
		alphabet.add('C');
		caesarCipher = new CaesarCipher(2, alphabet);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeyGreaterThanAlphabetLength() {
		caesarCipher = new CaesarCipher(4, alphabet);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeyNegative() {
		caesarCipher = new CaesarCipher(-1, alphabet);
	}
	
	@Test
	public void stringToArrayTest() {
		Character[] stringInArray = {'A','L','A',' ','M','A',' ','K','O','T','A','.'};
		List<Character> stringInList = Arrays.asList(stringInArray);
		Assert.assertEquals(stringInList, caesarCipher.stringToList("Ala ma kota."));
	}
	
	@Test
	public void onlyLettersToArrayTest() {
		Character[] stringInArray = {'A','L','A','M','A','K','O','T','A'};
		List<Character> stringInList = Arrays.asList(stringInArray);
		Assert.assertEquals(stringInList, caesarCipher.onlyLettersToArray("Ala ma kota."));
	}
	
	@Test
	public void encryptWithSpacesAndPunctuationTest() {
		Assert.assertEquals("ACAC, ACAC.", caesarCipher.encryptWithSpacesAndPunctuation("Baba, baba."));
	}
	
	@Test
	public void keyZeroEncryptWithSpacesAndPunctuationTest() {
		caesarCipher = new CaesarCipher(0, alphabet);
		Assert.assertEquals("BABA, BABA.", caesarCipher.encryptWithSpacesAndPunctuation("Baba, baba."));
	}
	
	@Test
	public void emptyAlphabetEncryptWithSpacesAndPunctuationTest() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		caesarCipher = new CaesarCipher(0, alphabet);
		Assert.assertEquals("BABA, BABA.", caesarCipher.encryptWithSpacesAndPunctuation("Baba, baba."));
	}
	
	@Test
	public void emptyEncryptWithSpacesAndPunctuationTest() {
		Assert.assertEquals("", caesarCipher.encryptWithSpacesAndPunctuation(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullEncryptWithSpacesAndPunctuationTest() {
		caesarCipher.encryptWithSpacesAndPunctuation(null);
	}
	
	@Test
	public void encryptOnlyLettersTest() {
		Assert.assertEquals("ACACACAC", caesarCipher.encryptOnlyLetters("Baba, baba."));
	}
	
	@Test
	public void keyZeroEncryptOnlyLettersTest() {
		caesarCipher = new CaesarCipher(0, alphabet);
		Assert.assertEquals("BABABABA", caesarCipher.encryptOnlyLetters("Baba, baba."));
	}
	
	@Test
	public void emptyAlphabetEncryptOnlyLettersTest() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		caesarCipher = new CaesarCipher(0, alphabet);
		Assert.assertEquals("BABABABA", caesarCipher.encryptOnlyLetters("Baba, baba."));
	}
	
	@Test
	public void emptyEncryptOnlyLettersTest() {
		Assert.assertEquals("", caesarCipher.encryptOnlyLetters(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullEncryptOnlyLettersTest() {
		caesarCipher.encryptOnlyLetters(null);
	}
	
	@Test
	public void decryptOnlyLettersTest() {
		Assert.assertEquals("BABABABA", caesarCipher.decrypt("ACACACAC"));
	}
	
	@Test
	public void decryptWithSpacesAndPunctuation() {
		Assert.assertEquals("BABA, BABA.", caesarCipher.decrypt("Acac, acac."));
	}
	
	@Test
	public void keyZeroDecryptTest() {
		caesarCipher = new CaesarCipher(0, alphabet);
		Assert.assertEquals("ACACACAC", caesarCipher.decrypt("ACACACAC"));
	}
	
	@Test
	public void emptyAlphabetDecryptTest() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		caesarCipher = new CaesarCipher(0, alphabet);
		Assert.assertEquals("ACACACAC", caesarCipher.decrypt("ACACACAC"));
	}
	
	@Test
	public void emptyDecryptTest() {
		Assert.assertEquals("", caesarCipher.decrypt(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullDecryptTest() {
		caesarCipher.decrypt(null);
	}

}