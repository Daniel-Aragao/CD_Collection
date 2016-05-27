package cdc.graphics;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class TabbedPane {
	
	JTabbedPane tabbedPane;
	
	public TabbedPane(){
		this.tabbedPane = new JTabbedPane();
		
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public void addTab(String titulo, Icon icon, JComponent component, String hint){
		tabbedPane.addTab(titulo, icon, component, hint);
	}
	

}
