package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.ControllerApp;
import Model.Recetas;

import javax.swing.JButton;

public class ConsultarRecetas extends JPanel {
	private JScrollPane scrollTable;
	private JTable tableReceta;
	private JButton btnShowRecetas;
	private DefaultTableModel tModel;
	public ConsultarRecetas() {
		
		Init();
	}

	private void Init() {
		setLayout(null);
		
		scrollTable = new JScrollPane();
		scrollTable.setVisible(false);
		scrollTable.setBounds(37, 71, 381, 175);
		add(scrollTable);
		
		tableReceta = new JTable();
		configTable();
		scrollTable.setViewportView(tableReceta);
		
		JLabel lblMsgRecetas = new JLabel("Listado de Recetas");
		lblMsgRecetas.setBounds(23, 29, 147, 16);
		add(lblMsgRecetas);
		
		btnShowRecetas = new JButton("Consultar Recetario");
		btnShowRecetas.setBounds(222, 24, 167, 29);
		add(btnShowRecetas);
	}

	private void configTable() {
		
		tModel = new DefaultTableModel() {
			
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		
		tableReceta.setModel(tModel);
		
		tModel.addColumn("Nombre");
		tModel.addColumn("Descripción");
		tModel.addColumn("Tiempo Ejec");
		tModel.addColumn("Dificultad");
		
		tableReceta.getColumn("Nombre").setPreferredWidth(75);
		tableReceta.getColumn("Descripción").setPreferredWidth(90);
		tableReceta.getColumn("Tiempo Ejec").setPreferredWidth(75);
		tableReceta.getColumn("Dificultad").setPreferredWidth(75);
	
		
	}
	
	
	public void fillTable(ArrayList<Recetas> listadoRecetas) {
		
		tModel.getDataVector().clear();
		
		
		Object [] row = new Object [4];
		
		
		
		for (Recetas rc : listadoRecetas) {
			
			row [0] = rc.getName();
			row [1] = rc.getDescription();
			row [2] = rc.getTime();
			row [3] = rc.getDifficulty();
			
			tModel.addRow(row);
			
			
			
		}
		
	}
	
	public void hacerVisible(boolean b) {
		
		scrollTable.setVisible(b);
	}

	public JButton getBtnShowRecetas() {
		return btnShowRecetas;
	}

	public void setController(ControllerApp control) {
		
		
		btnShowRecetas.addActionListener(control);
	}
	
	
	
	
}
