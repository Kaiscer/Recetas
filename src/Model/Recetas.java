package Model;

public class Recetas {
	
	private String name;
	private String description;
	private int time;
	private String difficulty;
	
	
	public Recetas(String name, String description, int time, String difficulty) {
		this.name = name;
		this.description = description;
		this.time = time;
		this.difficulty = difficulty;
	}


	@Override
	public String toString() {
		return  name + " Description: " + description + " Tiempo de ejecución: " + time + "Dicultad: "
				+ difficulty ;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public int getTime() {
		return time;
	}


	public String getDifficulty() {
		return difficulty;
	}
	
	
	
	
	

}
