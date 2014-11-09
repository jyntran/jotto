package jotto;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.Observable;
import java.util.Observer;

class View extends JPanel implements Observer {
	private JottoModel model;

	JTable table;

	public View(JottoModel model) {
        super(new GridLayout(1,0));
        this.model = model;

        table = new JTable(model.getTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(200, 200));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
	}

        // Observer interface
        @Override
        public void update(Observable arg0, Object arg1) {
//                System.out.println("View: update");
		table.revalidate();
		table.repaint();
        }

}
