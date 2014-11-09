package jotto;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

class View3 extends JPanel implements Observer {

	// the view's main user interface
	private JLabel guessedHead, guessed, notGuessedHead, notGuessed;

	// the model that this view is showing
	private JottoModel model;

	View3(JottoModel model_) {
		// create the view UI
		guessedHead = new JLabel("Guessed Letters: ");
		notGuessedHead = new JLabel("Remaining Letters: ");
		guessed = new JLabel();
		notGuessed = new JLabel();
		this.setLayout(new GridLayout(2,1));

		JPanel guessedPanel = new JPanel();
		JPanel notGuessedPanel = new JPanel();
		guessedPanel.setLayout(new FlowLayout());
		notGuessedPanel.setLayout(new FlowLayout());
		guessedPanel.add(guessedHead);
		guessedPanel.add(guessed);
		notGuessedPanel.add(notGuessedHead);
		notGuessedPanel.add(notGuessed);
		this.add(guessedPanel);
		this.add(notGuessedPanel);

		// set the model
		model = model_;

		// setup the event to go to the "controller"
		// (this anonymous class is essentially the controller)
/*		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				model.submitGuess(input);
			}
		});
*/	}

	// Observer interface
	@Override
	public void update(Observable arg0, Object arg1) {
//		System.out.println("View3: update");
		guessed.setText(model.printGuessedLetters());
		notGuessed.setText(model.printNotGuessedLetters());
	}
}

