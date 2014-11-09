package jotto;

import java.util.Observable;

public class WordListModel extends Observable {

	public static WordList words = new WordList("words.txt");

	WordListModel() {
		setChanged();
	}

	public void getGuess(){
//		System.out.println("Guessed word: " + guess);
		setChanged();
		notifyObservers();
	}

/*
	public void incrementCounter() {
		counter++;
		System.out.println("Model: increment counter to " + counter);
		setChanged();
		notifyObservers();
	}
*/
}
