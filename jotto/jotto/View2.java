package jotto;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

class View2 extends JPanel implements Observer {

	// the view's main user interface
	private JButton button;
	private JTextField inputField;
	private JLabel message;

	// the model that this view is showing
	private JottoModel model;

	View2(JottoModel model_) {
		// create the view UI
		button = new JButton("Submit");
		message = new JLabel("Enter a word to guess.",
			SwingConstants.CENTER);

		this.setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());

		inputField = new JTextField();
		inputField.setColumns(10);
		inputPanel.add(inputField);
		inputPanel.add(button);
		this.add(inputPanel, BorderLayout.NORTH);
		this.add(message, BorderLayout.CENTER);

		// set the model
		model = model_;

		// setup the event to go to the "controller"
		// (this anonymous class is essentially the controller)
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				model.submitGuess(input.toUpperCase());
			}
		});
	}

	// Observer interface
	@Override
	public void update(Observable arg0, Object arg1) {
//		System.out.println("View2: update");
		message.setText(model.message);
		model.message = "";
	}


}

