package verger;

import java.util.Date;

public class Entree {
	private int id;
	private Date date;
	private String expediteur;
	private String fournisseur;
	private int montant;
	private String note;
	
	public Entree() {
		
	}
	
	public Entree(int id, Date date, String expediteur, String fournisseur, int montant, String note) {
		this.id = id;
		this.date = date;
		this.expediteur = expediteur;
		this.fournisseur = fournisseur;
		this.montant = montant;
		this.note = note;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public void setDate (Date date) {
		this.date = date;
	}
	
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	
	public void setFournisseur (String fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	public void setMontant (int montant) {
		this.montant = montant;
	}
	
	public void setNote (String note) {
		this.note = note;
	}
	
	public int getId () {
		return id;
	}
	
	public Date getDate () {
		return date;
	}
	
	public String getExpediteur() {
		return expediteur;
	}
	
	public String getFournisseur () {
		return fournisseur;
	}
	
	public int getMontant () {
		return montant;
	}
	
	public String getNote () {
		return note;
	}
	
}
