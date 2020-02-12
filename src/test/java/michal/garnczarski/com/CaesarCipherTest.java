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

}