// HelloMVC: a simple MVC example
// the model is just a counter 
// inspired by code by Joseph Mack, http://www.austintek.com/mvc/

/**
 *  Two views with integrated controllers.  Uses java.util.Observ{er, able} instead
 *  of custom IView.
 */

package jotto;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Main{

	public static void main(String[] args){
		JFrame frame = new JFrame("Jotto");

		// create Model and initialize it
		JottoModel model = new JottoModel();

		// create View, tell it about model (and controller)
		View view = new View(model);

		// tell Model about View.
		model.addObserver(view);

		// create second view ...
		View2 view2 = new View2(model);
		model.addObserver(view2);

		// create third view ...
		View3 view3 = new View3(model);
		model.addObserver(view3);

		// create fourth view ...
		View4 view4 = new View4(model);
		model.addObserver(view4);

		// let all the views know that they're connected to the model
		model.notifyObservers();

		// create the window
		JPanel p = new JPanel(new BorderLayout());
		frame.getContentPane().add(p);
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(view);
		p2.add(view2);
		p2.add(view3);
		p.add(p2, BorderLayout.CENTER);
		p.add(view4, BorderLayout.EAST);

		frame.setPreferredSize(new Dimension(480,400));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
