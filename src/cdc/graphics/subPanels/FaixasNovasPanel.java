package cdc.graphics.subPanels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import cdc.entitys.Faixa;

public class FaixasNovasPanel {
	private JPanel panel;
	
	private JList<Faixa> jFaixas;
	private DefaultListModel<Faixa> faixasModel;
	
	private JTextField tipo_gravacao;
	private JTextField descricao;
	private JTextField codigo_compositor;
	private JTextField tipo_composicao;
	
	private JLabel tipo_gravacaoLabel;
	private JLabel descricaoLabel;
	private JLabel codigo_compositorLabel;
	private JLabel tipo_composicaoLabel;
	
	private JButton btnAdicionar;
	private JButton btnExcluir;
	
	private ArrayList<Faixa> faixas;
	
	
	public FaixasNovasPanel(){
		panel = new JPanel();
		
		Dimension dim = panel.getPreferredSize();
		dim.width = 250;
		panel.setPreferredSize(dim);
		
		panel.setBorder(BorderFactory.createTitledBorder("Faixas"));
		
		setFaixas(new ArrayList<>());
		
		tipo_gravacao = new JTextField(8);
		descricao = new JTextField(8);
		codigo_compositor = new JTextField(8);
		tipo_composicao = new JTextField(8);
		
		tipo_gravacaoLabel = new JLabel("Tipo de gravação");
		descricaoLabel = new JLabel("Descrição");
		codigo_compositorLabel = new JLabel("Código do compositor");
		tipo_composicaoLabel = new JLabel("Tipo de composição");
		
		btnAdicionar = new JButton("Adicionar");
		btnExcluir = new JButton("Remover");
		
		tipo_gravacao.addKeyListener(threeDigits(tipo_gravacao));
		
		jFaixas = new JList<Faixa>();
		createListModel();
		createListners();
		createLayout();
	}
	
	private void createLayout() {
		GridBagLayout gbl = new GridBagLayout();
		panel.setLayout(gbl);
		
		GridBagConstraints gc = gbl.getConstraints(panel);
		
		gc.weightx = 1;
		
		////////FIRST LINE//////
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		gc.weighty = 2;
		panel.add(new JScrollPane(jFaixas), gc);
		////////////////////////
		gc.weighty = 0.1;
		gc.gridwidth = 1;
		gc.ipadx = 10;
		
		////////First Colmun///////
		gc.gridx = 0;
		
		//First Line//
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(descricaoLabel , gc);
		
		//Second Line//
		gc.gridy = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(descricao , gc);
		
		//Third Line //
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add( this.tipo_gravacaoLabel , gc);
		
		//Fourth Line//
		gc.gridy = 4;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(tipo_gravacao , gc);
		
		//Fifth Line//
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(btnAdicionar, gc);
		
		////////Second Colmun///////
		gc.gridx = 1;
		
		//First Line//
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add(this.codigo_compositorLabel , gc);
		
		//Second Line//
		gc.gridy = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(codigo_compositor , gc);
		
		//Third Line //
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.SOUTH;
		panel.add( this.tipo_composicaoLabel , gc);
		
		//Fourth Line//
		gc.gridy = 4;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		panel.add(tipo_composicao , gc);
		
		//Fifth Line//
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(btnExcluir, gc);
	}

	private void createListners(){
		btnAdicionar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
				cleanFields();
			}
		});
		btnExcluir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Faixa f = jFaixas.getSelectedValue();
				if(f != null){
					removerFaixa(f);
				}
			}
		});
	}
	
	private void cleanFields() {
		tipo_gravacao.setText("");
		descricao.setText("");       
		codigo_compositor.setText("");
		tipo_composicao.setText("");		
	}

	protected void adicionar() {
		Faixa f = null;
		try{
			String tipo_gravacao = this.tipo_gravacao.getText();
			String descricao = this.descricao.getText();
			int codigo_compositor = Integer.parseInt(this.codigo_compositor.getText());
			int tipo_composicao = Integer.parseInt(this.tipo_composicao.getText());
			
			
			f = new Faixa(
					getFaixaNumero(), 
					tipo_gravacao, 
					descricao, 
					codigo_compositor, 
					tipo_composicao);
			
			adicionarFaixa(f);
		}catch(NumberFormatException ne){
			JOptionPane.showMessageDialog(null, "Um ou mais campos Inválidos");
		}
		
	}
	private KeyAdapter threeDigits(JTextField textField) {
		KeyAdapter a = new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(textField.getText().length() >= 3){
					e.consume();
				}
			}
		};		
		return a ;
	}
	
	private int getFaixaNumero(){
		return faixas.size() + 1;
	}

	protected void removerFaixa(Faixa f) {
		faixas.remove(f);
		faixasModel.removeElement(f);		
	}

	private void adicionarFaixa(Faixa f) {
		faixas.add(f);
		faixasModel.addElement(f);		
	}

	private void createListModel(){
		faixasModel = new DefaultListModel<Faixa>();
		jFaixas.setModel(faixasModel);
	}

	public ArrayList<Faixa> getFaixas() {
		return faixas;
	}

	public void setFaixas(ArrayList<Faixa> faixas) {
		this.faixas = faixas;
	}

	public JPanel getPanel() {
		return panel;
	}

	public Component getComponent() {
		return panel;
	}
}
