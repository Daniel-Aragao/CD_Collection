package cdc.graphics;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cdc.entitys.CD;
import cdc.graphics.listeners.SalvarListener;
import cdc.graphics.subPanels.EditFieldsPanel;

public class AddPanel {
	private JPanel panel;
	
	private EditFieldsPanel editFieldsPanel; 
	
	public AddPanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		editFieldsPanel = new EditFieldsPanel();
		editFieldsPanel.setNewCD();
		
		editFieldsPanel.setSalvarListener(new SalvarListener() {			
			@Override
			public void saveClicked(CD cd) {
				saveCD(cd);
			}
		});
		
		panel.add(editFieldsPanel.getComponent(), BorderLayout.CENTER);
	}
	
	private void saveCD(CD cd){
//		new RepositorioCD.
		throw new RuntimeException("AddPanel.saveCD() - Não implementado");
	}
	
	public JComponent getPanel(){
		return panel;
	}
}
