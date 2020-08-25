package verger;

import java.util.Date;

public class Employe {
	private int id;
	private String nomV;
	private String prenom;
	private String nom;
	private String date_exp_sejour;
	private int mode;
	
	public Employe() {
		
	}
	
	public Employe(int id, String nomV, String prenom, String nom, String date_exp_sejour,int mode) {
		this.id = id;
		this.nomV = nomV;
		this.prenom = prenom;
		this.nom = nom;
		this.date_exp_sejour = date_exp_sejour;
		this.mode = mode;
	}
	
	public Employe(String nomV, String prenom, String nom, String date_exp_sejour,int mode) {
		this.nomV = nomV;
		this.prenom = prenom;
		this.nom = nom;
		this.date_exp_sejour = date_exp_sejour;
		this.mode = mode;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public void setnomV (String nomV) {
		this.nomV = nomV;
	}
	
	public void setnom (String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setDateExpSejour (String date_exp_sejour) {
		this.date_exp_sejour = date_exp_sejour;
	}

	public void setMode (int mode) {
		this.mode = mode;
	}
	
	public int getId () {
		return id;
	}
	
	public String getnomV () {
		return nomV;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getnom () {
		return nom;
	}
	
	public String getDateExpSejour() {
		return date_exp_sejour;
	}

	public int getMode () {
		return mode;
	}
	
}
