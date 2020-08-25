package verger;

import java.util.Date;

public class Facture {
	private int id;
	private Date date;
	private int prix_totale;
	private String nom_verger;
	private Produit[] tab_produit;
	private String nom_marche;
	
	public Facture() {
		
	}
	
	public Facture(int id, Date date, int prix_totale, String nom_verger, Produit[] tab_produit) {
		this.id = id;
		this.date = date;
		this.prix_totale = prix_totale;
		this.nom_verger = nom_verger;
		this.tab_produit = tab_produit;
	}
	public void setId (int id) {
		this.id = id;
	}
	
	public void setDate (Date date) {
		this.date = date;
	}
	
	public void setPrixTotal (int prix_totale) {
		this.prix_totale = prix_totale;
	}
	
	public void setNomVerger (String nom_verger) {
		this.nom_verger = nom_verger;
	}
	
	public void setTabProduit (Produit[] tab_produit) {
		this.tab_produit = tab_produit;
	}
	
	public void setNomMarche (String nom_marche) {
		this.nom_marche = nom_marche;
	}
	
	public int getId () {
		return id;
	}
	
	public Date getDate () {
		return date;
	}
	
	public int getPrixTotal () {
		return prix_totale;
	}
	
	public String getNomVerger () {
		return nom_verger;
	}
	
	public Produit[] getTabProduit () {
		return tab_produit;
	}
	
	public String setNomMarche () {
		return nom_marche;
	}

}
