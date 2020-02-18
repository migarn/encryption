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

	public void setAlphabets(ArrayList<Alphabet> alphabets) {
		this.alphabets = alphabets;
	}



	public String getAlphabetName(int alphabetIndex) {
		return alphabets.get(alphabetIndex).getName();
	}
	
	public void addAlphabet(Alphabet alphabet) {
		this.alphabets.add(alphabet);
	}
	
	public int[] alphabetsIndices() {
		int arraySize = this.alphabets.size();
		int[] indices = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			indices[i] = i;
		}
		
		return indices;
	}
}
