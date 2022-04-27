package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Model.DataBase;
import Model.Recetas;
import view.ConsultarRecetas;
import view.IntroducirRecetas;
import view.WReceta;

public class ControllerApp implements ActionListener {
	
	WReceta w;
	IntroducirRecetas pAdd;
	ConsultarRecetas pSee;
	DataBase datos;
	
	
	
	
	public ControllerApp(WReceta w, IntroducirRecetas pIntroR, ConsultarRecetas showR) {
		this.w = w;
		this.pAdd = pIntroR;
		this.pSee = showR;
		datos = new DataBase();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			
			if (e.getActionCommand().equals(WReceta.ITEM_ADD)) {
				w.cargarPanel(pAdd);
			}else if (e.getActionCommand().equals(WReceta.ITEM_SEE)) {
				w.cargarPanel(pSee);
				pSee.hacerVisible(false);
				
			}else if (e.getActionCommand().equals(WReceta.ITEM_EXIT)) {
				
				int opcion = JOptionPane.showConfirmDialog(w, "Salir del programa ¿Deseas Continuar?","Cerrando App", 
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (opcion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
			
		}else if (e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			if (btn == pAdd.getBtnAdd()) {
				Recetas rc = pAdd.requestData();
				if (rc != null) {
					
					datos.addRecetas(rc);
					
					JOptionPane.showMessageDialog(pAdd, "Receta añadida","Resultado de operación",JOptionPane.INFORMATION_MESSAGE);
					
					pAdd.clearForm();
				}
			}else if (btn == pSee.getBtnShowRecetas()) {
				
				pSee.fillTable(datos.getListaRecetas());
				pSee.hacerVisible(true);
			}
		}
	}

}
