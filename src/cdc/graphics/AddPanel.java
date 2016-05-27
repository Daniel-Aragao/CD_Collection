package cdc.graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class AddPanel {
	private JPanel panel;
	
	public AddPanel(){
		panel = new JPanel();
	}
	
	public JComponent getPanel(){
		return panel;
	}
}
