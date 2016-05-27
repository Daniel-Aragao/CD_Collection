package cdc.graphics.subPanels;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cdc.Infra.RepositorioCD;
import cdc.entitys.CD;
import cdc.graphics.listeners.SalvarListener;

public class EditFieldsPanel {
	private JPanel panel;
	
	private JTextField codigo;
	private JTextField cod_label;
	private JTextField data_gravacao;
	private JTextField data_compra;
	private JTextField descricao;
	private JTextField preco_compra;
	
	private JLabel codigoLabel;
	private JLabel cod_labelLabel;
	private JLabel data_gravacaoLabel;
	private JLabel data_compraLabel;
	private JLabel descricaoLabel;
	private JLabel preco_compraLabel;
	
	private JButton btnSalvar;
	private JButton btnCancelar;	
	
	private CD selectedCD;
	
	private SalvarListener salvarListener;
		
	public EditFieldsPanel(){
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Edição"));
		
		codigo = new JTextField(8);
		cod_label = new JTextField(8);
		data_gravacao = new JTextField(8);  
		data_compra = new JTextField(8);
		descricao = new JTextField(8);
		preco_compra = new JTextField(8); 
		
		codigoLabel = new JLabel("Código");
		cod_labelLabel = new JLabel("Código da Gravadora");
		data_gravacaoLabel = new JLabel("Data da gravação"); 
		data_compraLabel = new JLabel("Data da compra");
		descricaoLabel = new JLabel("Descrição");
		preco_compraLabel = new JLabel("Preço de Compra");
		
		btnSalvar = new JButton("Salvar");
		btnCancelar = new JButton("Cancelar");
		
		codigo.setEditable(false);
		codigo.addKeyListener(digitOnlyAdapter());
		cod_label.addKeyListener(digitOnlyAdapter());
		
		createListeners();
		createLayout();
	}
	
	private void createListeners() {
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cleanFields();
				
			}
		});
	}	

	private void createLayout(){
		
		GridBagLayout gbl = new GridBagLayout();
		panel.setLayout(gbl);

		GridBagConstraints gc = gbl.getConstraints(panel);

		gc.fill = GridBagConstraints.NONE;
		
		/////////////////FIRST COLUMN//////////////
		
		// FIRST LINE
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(codigoLabel, gc);
		
		// SECOND LINE
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(codigo, gc);
		
		// THIRD LINE
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(cod_labelLabel, gc);
		// FOURTH LINE
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(cod_label, gc);

		// FIFTH LINE
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(data_gravacaoLabel, gc);
		// SIXTH LINE
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(data_gravacao, gc);
		
		// SEVENTH LINE
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(btnSalvar, gc);
		
		////////////////SECOND COLUMN/////////////
		gc.weighty = 0.1;
		gc.gridx = 1;
		// FIRST LINE
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(data_compraLabel, gc);
		// SECOND LINE
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(data_compra, gc);

		// THIRD LINE
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(descricaoLabel, gc);
		// FOURTH LINE
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(descricao, gc);

		// FIFTH LINE
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(preco_compraLabel, gc);
		// SIXTH LINE
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(preco_compra, gc);
		
		// SEVENTH LINE
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(btnCancelar, gc);
	}

	public Component getComponent() {
		return panel;
	}

	public void setSelectedCD(CD cd) {
		selectedCD = cd;
		fillFields(cd);		
	}
	
	private void fillFields(CD cd){
		codigo.setText(cd.getCodigo() +"");       
		cod_label.setText(cd.getCod_label() +"");
		
		Calendar aux = cd.getData_gravacao();
		data_gravacao.setText(aux.get(Calendar.DAY_OF_MONTH)+"/"+aux.get(Calendar.MONTH)+"/"+aux.get(Calendar.YEAR));
		aux = cd.getData_compra();
		data_compra.setText(aux.get(Calendar.DAY_OF_MONTH)+"/"+aux.get(Calendar.MONTH)+"/"+aux.get(Calendar.YEAR));  
		
		descricao.setText(cd.getDescricao() +"");    
		preco_compra.setText(cd.getPreco_compra() +""); 
	}
	
	private void cleanFields(){
		selectedCD = new CD();
		
		codigo.setText("");       
		cod_label.setText("");
		data_gravacao.setText("");
		data_compra.setText("");  
		descricao.setText("");    
		preco_compra.setText(""); 
	}
	
	private KeyAdapter digitOnlyAdapter() {
		KeyAdapter a = new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				
				if(!Character.isDigit(e.getKeyChar())){
					e.consume();
				}
			}
		};		
		return a ;
	}

	private void salvar() {
		if(selectedCD != null){
			
			selectedCD.setCod_label(Integer.parseInt(this.cod_label.getText()));
			selectedCD.setDescricao(this.descricao.getText());    
			selectedCD.setPreco_compra(Double.parseDouble(this.preco_compra.getText())); 
			
			
			String[] dtGrav = this.data_gravacao.getText().split("/");
			String[] dtComp = this.data_compra.getText().split("/");
			
			Calendar aux = Calendar.getInstance();
			aux.set(Integer.parseInt(dtGrav[2]), 
					Integer.parseInt(dtGrav[1]), 
					Integer.parseInt(dtGrav[0]));
			selectedCD.setData_gravacao(aux);
			
			aux.set(Integer.parseInt(dtComp[2]), 
					Integer.parseInt(dtComp[1]), 
					Integer.parseInt(dtComp[0]));
			selectedCD.setData_compra(aux);
			
			if(salvarListener != null){
				salvarListener.saveClicked(selectedCD);			
			}else{
				System.err.println("salvarListener null");
			}			
		}else{
			throw new RuntimeException("EditFieldsPanel.selectedCD - não inicializado");
		}
	}

	public SalvarListener getSalvarListener() {
		return salvarListener;
	}

	public void setSalvarListener(SalvarListener salvarListener) {
		this.salvarListener = salvarListener;
	}

	public CD getSelectedCD() {
		return selectedCD;
	}
	public void setNewCD(){
		cleanFields();
	}
	
}
