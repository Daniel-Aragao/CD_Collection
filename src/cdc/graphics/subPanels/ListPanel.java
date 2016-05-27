package cdc.graphics.subPanels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cdc.Infra.RepositorioCD;
import cdc.entitys.CD;
import cdc.graphics.listeners.SelectedCDListener;

public class ListPanel {
	private JPanel panel;
	
	private JTextField searchBox;
	private JButton btnSearch;
	
	private JList<CD> jlist;
	private DefaultListModel<CD> model;
	
	private SelectedCDListener selectedListener;
	
	public ListPanel(){
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Busca"));
				
		Dimension dim = panel.getPreferredSize();
		dim.width = 200;
		panel.setPreferredSize(dim);
		
		jlist = new JList<CD>();
		searchBox = new JTextField();
		btnSearch = new JButton("Buscar");	
		
		createListeners();
		createListModel();
		createLayout();
	}
	private void createListeners() {
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<CD> cds = new RepositorioCD().get(searchBox.getText());
				
				alterModel(cds);
			}
		});
		
		jlist.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(selectedListener != null)
				selectedListener.selected(jlist.getSelectedValue());
				
			}
		});
		
	}
	protected void alterModel(ArrayList<CD> cds) {
		this.model = new DefaultListModel<CD>();
		
		for(CD cd : cds){
			model.addElement(cd);
		}
		
		jlist.setModel(this.model);
		
	}
	private void createListModel(){
		 this.model = new DefaultListModel<CD>();
		 
		 		
		jlist.setModel(this.model);
	}
	
	private void createLayout(){
		GridBagLayout gl = new GridBagLayout();
		panel.setLayout(gl);
		
		GridBagConstraints gc = gl.getConstraints(panel);
		
//		gc.fill = GridBagConstraints.;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		/////////////////////FIRST LINE//////////////////
		
		gc.gridy = 0;		
		gc.gridx = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
//		gc.anchor = GridBagConstraints.CENTER;
		panel.add(searchBox, gc);
		
		////////////////////SECOND LINE//////////////////

		gc.gridy = 1;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(btnSearch, gc);		
		
		////////////////////THIRD LINE//////////////////
		
		gc.gridy = 2;
		gc.weighty = 2;
		
		gc.gridx = 0;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(new JScrollPane(jlist), gc);
		
	}

	public Component getComponent() {
		return panel;
	}
	public SelectedCDListener getSelectedListener() {
		return selectedListener;
	}
	public void setSelectedListener(SelectedCDListener selectedListener) {
		this.selectedListener = selectedListener;
	}
}











