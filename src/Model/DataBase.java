package Model;

import java.util.ArrayList;

public class DataBase {
	
	private ArrayList<Recetas> listaRecetas;

	
	
	public DataBase() {
		
		listaRecetas = new ArrayList<Recetas>();
		
	}



	public ArrayList<Recetas> getListaRecetas() {
		return listaRecetas;
	}
	
	public void addRecetas(Recetas receta) {
		
		listaRecetas.add(receta);
	}

}
