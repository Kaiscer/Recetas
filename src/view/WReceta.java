package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import Control.ControllerApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Color;

public class WReceta extends JFrame {
	public static final int ALTO = 600;
	public static final int ANCHO = 400;
	
	public static final String ITEM_ADD = "Añadir";
	public static final String ITEM_SEE = "Consultar";
	public static final String ITEM_EXIT = "Salir";
	
	private JMenuItem ItemAdd;
	private JMenuItem ItemSee;
	private JMenuItem ItemExit;
	private JScrollPane scrollContenedor;
	
	
	public WReceta() {
		
		initComponets();
		
		
	}


	


	private void initComponets() {
		WindowCenter();
		
		MenuBar();
		
		
		setSize(ALTO,ANCHO);
		
		setTitle("Cooking is Easy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrollContenedor = new JScrollPane();
		getContentPane().add(scrollContenedor, BorderLayout.CENTER);
	}



	private void MenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		ItemAdd = new JMenuItem(ITEM_ADD);
		ItemAdd.setBackground(Color.GRAY);
		menuBar.add(ItemAdd);
		
		ItemSee = new JMenuItem(ITEM_SEE);
		ItemSee.setBackground(Color.GRAY);
		menuBar.add(ItemSee);
		
		ItemExit = new JMenuItem(ITEM_EXIT);
		ItemExit.setBackground(Color.GRAY);
		menuBar.add(ItemExit);
	}
	
	public void MakingVisible() {
		setVisible(true);
	}

	public void cargarPanel(JPanel panel) {
		
		scrollContenedor.setViewportView(panel);
		
	}

	private void WindowCenter() {
		
		setPreferredSize(new Dimension(ALTO, ALTO));  
		       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		      
		Dimension ventana = this.getPreferredSize();               
		     
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);

	}





	public void setController(ControllerApp control) {
		
		ItemAdd.addActionListener(control);
		ItemSee.addActionListener(control);
		ItemExit.addActionListener(control);
	}
	
	

}
