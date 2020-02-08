package michal.garnczarski.com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {
	private CaesarCipher caesarCipher;
	
	@Before
	public void createCaesarCipherForTheTest() {
		LinkedList<String> alphabet = new LinkedList<String>();
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		caesarCipher = new CaesarCipher(2, alphabet);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeyGreaterThanAlphabetLength() {
		LinkedList<String> alphabet = new LinkedList<String>();
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		CaesarCipher caesarCipher = new CaesarCipher(4, alphabet);
	}
	
	@Test
	public void stringToArrayTest() {
		char[] array = {'A','l','a',' ','m','a',' ','k','o','t','a','.'};
		
		Assert.assertArrayEquals(array, caesarCipher.stringToArray("Ala ma kota."));
	}

}