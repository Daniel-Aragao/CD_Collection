package cdc.graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class EditPanel {
	private JPanel panel;
	
	public EditPanel(){
		panel = new JPanel();
	}

	public JComponent getPanel() {
		return panel;
	}
}
