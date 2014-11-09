package jotto;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

class View4 extends JPanel implements Observer {

	// the view's main user interface
	private JTextArea text;
	private JLabel label;

	// the model that this view is showing
	private JottoModel model;

	View4(JottoModel model_) {
		// create the view UI
		label= new JLabel("Dictionary");
		text = new JTextArea("");
		text.setEditable(false);

		this.setLayout(new BorderLayout());

		this.add(label, BorderLayout.NORTH);
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(80,280));
		JScrollPane scrollFrame = new JScrollPane(text);
		textPanel.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(100,300));
		scrollFrame.add(textPanel);
		this.add(scrollFrame,BorderLayout.CENTER);

		// set the model
		model = model_;

		text.setText(model.printWords());

	}

	// Observer interface
	@Override
	public void update(Observable arg0, Object arg1) {
//		System.out.println("View4: update");
	}


}

