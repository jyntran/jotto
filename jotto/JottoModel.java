package jotto;

import java.util.Observable;

public class JottoModel extends Observable {

	public static int NUM_LETTERS = 5;
	public static final String[] LEVELS = {
	  "Easy", "Medium", "Hard", "Any Difficulty"};

	private String mystery;
	private String guess;

	JottoModel() {
		setChanged();
	}

	public String getMystery() {
		return mystery;
	}

	public String getGuess() {
		return guess;
	}

	public boolean isGuessCorrect() {
		return (guess == mystery);
	}

	public void findExact(String guess){
		int exactTotal = 0;
		String mystery = getMystery();
		for (int i = 0; i < mystery.length(); i++){
    			char cg = guess.charAt(i);
    			char cm = mystery.charAt(i);
			if (cg == cm) {
				exactTotal++;
			}
		}
		setChanged();
		notifyObservers();
	}

	public void findPartial(String guess){
		int partialTotal = 0;
		String mystery = getMystery();
		for (int i = 0; i < mystery.length(); i++){
    			char cm = mystery.charAt(i);
			for (int j = 0; j < guess.length(); j++){
    				char cg = guess.charAt(i);
				if (i != j && cg == cm) {
					partialTotal++;
				}
			}
		}
		setChanged();
		notifyObservers();
	}

	public void submitGuess() {
	}
}
