package verger;

public class Verger {
	private String nom;
	private float surface;
	private String location;
	
	public Verger() {
		
	}
	
	public Verger(String nom, float surface, String location) {
		this.nom = nom;
		this.surface = surface;
		this.location = location;
	}
	
	public void setNom (String nom) {
		this.nom = nom;
	}
	
	public void setSurface (float surface) {
		this.surface = surface;
	}
	
	public void setLocation (String location) {
		this.location = location;
	}
	
	public String getNom() {
		return nom;
	}
	
	public float getSurface() {
		return surface;
	}
	
	public String getLocation() {
		return location;
	}

}
