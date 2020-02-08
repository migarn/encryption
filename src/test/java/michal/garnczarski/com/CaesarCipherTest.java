package michal.garnczarski.com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeyGreaterThanAlphabetLength() {
		LinkedList<String> alphabet = new LinkedList<String>();
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		CaesarCipher caesarCipher = new CaesarCipher(4, alphabet);
	}

}