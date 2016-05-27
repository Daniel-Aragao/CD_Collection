package cdc.main;

import java.awt.Color;

import cdc.graphics.AddPanel;
import cdc.graphics.EditPanel;
import cdc.graphics.Frame;
import cdc.graphics.TabbedPane;

public class Controller {
	private Frame frame;
	private TabbedPane tabbedPane;
	private EditPanel editPanel;
	private AddPanel addPanel;
	
	public Controller(){
		this.frame = new Frame();
		this.tabbedPane = new TabbedPane();
		this.editPanel = new EditPanel();
		this.addPanel = new AddPanel();
		
		this.tabbedPane.addTab("Editar CD's", null, editPanel.getPanel(),"Busca e edição de CD's");
		this.tabbedPane.addTab("Adicionar CD", null, addPanel.getPanel(), "Adição de novos CD's");
		
		this.frame.setColor(Color.black);
		
		frame.addComponent(tabbedPane.getTabbedPane());
		frame.setVisible(true);
	}
}
