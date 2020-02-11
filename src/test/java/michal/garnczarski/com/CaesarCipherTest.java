package michal.garnczarski.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {
	private CaesarCipher caesarCipher;
	
	@Before
	public void createCaesarCipherForTheTest() {
		char[] alphabet = {'A', 'B', 'C'};
		caesarCipher = new CaesarCipher(2, alphabet);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeyGreaterThanAlphabetLength() {
		char[] alphabet = {'A', 'B', 'C'};
		caesarCipher = new CaesarCipher(4, alphabet);
	}
	
	@Test
	public void stringToArrayTest() {
		char[] array = {'A','L','A',' ','M','A',' ','K','O','T','A','.'};
		
		Assert.assertArrayEquals(array, caesarCipher.stringToArray("Ala ma kota."));
	}
	
	@Test
	public void onlyLettersToArrayTest() {
		char[] array = {'A','L','A','M','A','K','O','T','A'};
		
		Assert.assertArrayEquals(array, caesarCipher.onlyLettersToArray("Ala ma kota."));
	}

}