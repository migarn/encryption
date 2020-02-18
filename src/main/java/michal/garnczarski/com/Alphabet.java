package michal.garnczarski.com;

import java.util.ArrayList;

public class Alphabet {
	private String name;
	private ArrayList<Character> signs;
	
	public Alphabet(String name, ArrayList<Character> signs) {
		this.name = name;
		this.signs = signs;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Character> getSigns() {
		return signs;
	}
}
