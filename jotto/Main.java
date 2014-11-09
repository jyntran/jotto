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
import java.awt.GridLayout;
import java.awt.event.*;	

public class Main{

	public static void main(String[] args){	
		JFrame frame = new JFrame("Jotto");
		
		// create Model and initialize it
		JottoModel model = new JottoModel();
//		CustomTableModel tblmodel = new CustomTableModel();

		// create View, tell it about model (and controller)
		View view = new View(model);
//		CustomTableView view = new CustomTableView(tblmodel);
		// tell Model about View. 
		model.addObserver(view);
		
		// create second view ...
		View2 view2 = new View2(model);
		model.addObserver(view2);
		
		// let all the views know that they're connected to the model
		model.notifyObservers();
//		tblmodel.notifyObservers();
		
		// create the window
		JPanel p = new JPanel(new GridLayout(1,2));
		frame.getContentPane().add(p);
		p.add(view);
		
		p.add(view2);
		
		frame.setPreferredSize(new Dimension(640,480));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} 
}
