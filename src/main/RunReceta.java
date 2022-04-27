 package main;

import java.awt.EventQueue;

import Control.ControllerApp;
import view.ConsultarRecetas;
import view.IntroducirRecetas;
import view.WReceta;


public class RunReceta {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				WReceta w = new WReceta();
				IntroducirRecetas pAdd = new IntroducirRecetas();
				ConsultarRecetas pSee = new ConsultarRecetas();
				
				
				ControllerApp control = new ControllerApp(w, pAdd, pSee);
				
				w.setController(control);
				pAdd.setController(control);
				pSee.setController(control);
				
				
				
				w.MakingVisible();
				
			}
		});

	}

}
