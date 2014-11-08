package jotto;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

class View extends JPanel implements Observer {

	private JTable guessTable;

	// the model that this view is showing
	private WordListModel model;

	String[][] wordarr = new String[20][3];

	View(WordListModel model_) {
		// create UI
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		//set table headings
		String[] columnNames = {"Word",
			"Exact",
			"Partial"};
		//set possible words
//		System.out.println(model.words.getWord(0));

//		WordList words = new WordList("words.txt");


		for (int i=0; i<20; i++) {
			Word word = model.words.getWord(i);
			String wordstring = word.getWord();
			wordarr[i][0] = wordstring;
		}

		guessTable = new JTable(wordarr,columnNames);
//		add(new JScrollPane(guessTable));
		this.add(guessTable);

		// set the model
		model = model_;

		// setup the event to go to the "controller"
		// (this anonymous class is essentially the controller)
		addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					model.getGuess();
				}
		});
	}

	// Observer interface
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("View: updateView");
		// just displays an 'X' for each counter value
//		if (model.getGuess > 0)
			//
	}
}

