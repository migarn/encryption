package michal.garnczarski.com;

import java.util.ArrayList;

public class AlphabetsList {
	private ArrayList<Alphabet> alphabets;

	public AlphabetsList() {
		this.alphabets = new ArrayList<Alphabet>();
	}

	public ArrayList<Alphabet> getAlphabets() {
		return alphabets;
	}

	public String getAlphabetName(int alphabetIndex) {
		return alphabets.get(alphabetIndex).getName();
	}
	
	public void addAlphabet(Alphabet alphabet) {
		this.alphabets.add(alphabet);
	}
}
