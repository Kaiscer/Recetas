package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.SpinnerNumberModel;


import Control.ControllerApp;
import Model.Recetas;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class IntroducirRecetas extends JPanel {
	
	//private static final int RESTA_ANCHO = WReceta.ANCHO -15;
	//private static final int RESTA_ALTO = WReceta.ALTO - 70;
	
	private static final String []DIFICULTAD = {" ","Baja","Media","Alta"};
	
	private JTextField txtName;
	private JTextArea txtDescripcion;
	private JComboBox<String> cmbDificultad;
	private JButton btnAdd;
	private JSpinner spnTime;
	public IntroducirRecetas() {
		Init();
	}
	private void Init() {
		setLayout(null);
		
		JLabel lblNameReceta = new JLabel("Nombre de la Receta");
		lblNameReceta.setBounds(6, 34, 170, 16);
		lblNameReceta.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		add(lblNameReceta);
		
		txtName = new JTextField();
		txtName.setBounds(172, 30, 272, 26);
		add(txtName);
		txtName.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(133, 68, 88, 16);
		lblDescripcion.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		add(lblDescripcion);
		
		JScrollPane scrollDescripcion = new JScrollPane();
		scrollDescripcion.setBounds(32, 94, 399, 94);
		add(scrollDescripcion);
		
		txtDescripcion = new JTextArea();
		scrollDescripcion.setViewportView(txtDescripcion);
		
		JLabel lblTime = new JLabel("Tiempo de Ejcución");
		lblTime.setBounds(23, 202, 153, 16);
		lblTime.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		add(lblTime);
		
		spnTime = new JSpinner();
		spnTime.setEditor(new JSpinner.DefaultEditor(spnTime));
		spnTime.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spnTime.setBounds(188, 198, 45, 26);
		add(spnTime);
		
		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setBounds(240, 203, 81, 16);
		lblDificultad.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		add(lblDificultad);
		
		cmbDificultad = new JComboBox<String>();
		cmbDificultad.setModel(new DefaultComboBoxModel<String>(DIFICULTAD));
		cmbDificultad.setBounds(321, 200, 123, 27);
		cmbDificultad.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		add(cmbDificultad);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(153, 249, 117, 29);
		btnAdd.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		add(btnAdd);
		
		
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setController(ControllerApp control) {
		
		btnAdd.addActionListener(control);
		
		
	}
	public Recetas requestData() {
		Recetas rc = null;
		
		String name = txtName.getText().trim();
		
		if (name.isBlank()) {
			JOptionPane.showConfirmDialog(this, "Debes Introducir el nombre de la receta","Error de datos",JOptionPane.ERROR_MESSAGE);
		}else {
			
			String descrip = txtDescripcion.getText();
			
			int time = (int) spnTime.getValue();
			
			if (time <= 0) {
				JOptionPane.showConfirmDialog(this, "El timepo de la receta debe ser mayor que cero", "Error de tiempo",JOptionPane.ERROR_MESSAGE);
			}else {
				
				String difc = (String) cmbDificultad.getSelectedItem();
				
				if (difc.equals(" ")) {
					JOptionPane.showConfirmDialog(this, "Debes elegir la dificultad de la receta", "Error de difultad", JOptionPane.ERROR_MESSAGE);
				}else {
					
					rc = new Recetas(name, descrip, time, difc);
				}
			}
			
			
			
		}
		
		
		return rc;
	}
	public void clearForm() {
		
		txtName.setText("");
		txtDescripcion.setText("");
		spnTime.setValue(0);
		cmbDificultad.setSelectedItem(DIFICULTAD[0]);
		
		
		
		
	}
	
	
	
	
	
	
}
