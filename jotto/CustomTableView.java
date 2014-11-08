package jotto;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.Observable;
import java.util.Observer;

class CustomTableView extends JPanel implements Observer {
	private CustomTableModel model;

	public CustomTableView(CustomTableModel model) {
        super(new GridLayout(1,0));
        this.model = model;

        JTable table = new JTable(model.getTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

        // Observer interface 
        @Override
        public void update(Observable arg0, Object arg1) {
                System.out.println("View: update");
//                button.setText(Integer.toString(model.getCounterValue()));     $
        }

}
