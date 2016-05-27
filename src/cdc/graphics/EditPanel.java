package cdc.graphics;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cdc.entitys.CD;
import cdc.graphics.listeners.SelectedCDListener;
import cdc.graphics.subPanels.EditFieldsPanel;
import cdc.graphics.subPanels.ListPanel;

public class EditPanel {
	private JPanel panel;
	
	private ListPanel listPanel;
	private EditFieldsPanel editFieldsPanel;
	
	public EditPanel(){
		panel = new JPanel();
		listPanel = new ListPanel();
		editFieldsPanel = new EditFieldsPanel();
		
		panel.setLayout(new BorderLayout());
		
		listPanel.setSelectedListener(new SelectedCDListener() {			
			@Override
			public void selected(CD cd) {
				editFieldsPanel.setSelectedCD(cd);				
			}
		});
				
		panel.add(listPanel.getComponent(), BorderLayout.WEST);
		panel.add(editFieldsPanel.getComponent(), BorderLayout.CENTER);		
	}

	public JComponent getPanel() {
		return panel;
	}
}
