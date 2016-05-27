package cdc.graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frame {
	public static final Dimension screen = new Dimension(500,400);
	private JFrame frame;
	
	public Frame(){
		createFrame();
	}
	
	public void createFrame(){
		frame = new JFrame("CD Collection");
		frame.setSize(screen);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void addComponent(JComponent component){
		frame.add(component);
	}
	
	public void setVisible(boolean visible){
		frame.setVisible(visible);
	}
	public void setColor(Color color){
		frame.setBackground(color);
	}
}
