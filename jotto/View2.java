package jotto;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

class View2 extends JPanel implements Observer {

	// the view's main user interface
	private JButton button;
	private JTextField inputField;

	// the model that this view is showing
	private JottoModel model;

	View2(JottoModel model_) {
		// create the view UI
		button = new JButton("Submit");
		button.setMaximumSize(new Dimension(100, 30));
		button.setPreferredSize(new Dimension(100, 30));
		// a GridBagLayout with default constraints centres
		// the widget in the window
		this.setLayout(new GridBagLayout());
		this.add(button, new GridBagConstraints());
		inputField = new JTextField();
		inputField.setColumns(10);
		inputField.setMaximumSize(new Dimension(500, 500));
		this.add(inputField);
		this.add(button);

		// set the model
		model = model_;

		// setup the event to go to the "controller"
		// (this anonymous class is essentially the controller)
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				model.submitGuess(input);
			}
		});
	}

	// Observer interface 
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("View2: update");
//		button.setText(Integer.toString(model.getCounterValue()));
	}


}

