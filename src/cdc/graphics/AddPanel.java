package cdc.graphics;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cdc.Infra.RepositorioCD;
import cdc.entitys.CD;
import cdc.graphics.listeners.SalvarListener;
import cdc.graphics.subPanels.EditFieldsPanel;
import cdc.graphics.subPanels.FaixasNovasPanel;

public class AddPanel {
	private JPanel panel;
	
	private EditFieldsPanel editFieldsPanel; 
	private FaixasNovasPanel faixasNovasPanel;
	
	public AddPanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		editFieldsPanel = new EditFieldsPanel();
		editFieldsPanel.setNewCD();
		faixasNovasPanel = new FaixasNovasPanel();
		
		editFieldsPanel.setSalvarListener(new SalvarListener() {			
			@Override
			public void saveClicked(CD cd) {
				cd.setFaixas(faixasNovasPanel.getFaixas());
				saveCD(cd);
			}
		});
		
		panel.add(faixasNovasPanel.getComponent(), BorderLayout.WEST);
		panel.add(editFieldsPanel.getComponent(), BorderLayout.CENTER);
	}
	
	private void saveCD(CD cd){
		if(cd.getFaixas() == null || cd.getFaixas().isEmpty()){
			JOptionPane.showMessageDialog(null, "Adicione novas faixas para o cd antes de salva-lo");
		}else{
			new RepositorioCD().adicionar(cd);
			JOptionPane.showMessageDialog(null, "Salvo!");
		}
//		throw new RuntimeException("AddPanel.saveCD() - Não implementado");
	}
	
	public JComponent getPanel(){
		return panel;
	}
}
