package verger;

public class Produit {
	private String type;
	private int qualite;	//est une valeur entre 0 et 5
	private int prix;
	private int qte;
	
	public Produit() {
		
	}
	
	public Produit(String type, int qualite, int prix, int qte) {
		this.type = type;
		this.qualite = qualite;
		this.prix = prix;
		this.qte = qte;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	public void setQualite (int qualite) {
		this.qualite = qualite;
	}
	
	public void setPrix (int prix) {
		this.prix = prix;
	}
	
	public void setQuantite (int qte) {
		this.qte = qte;
	}
	
	public String getType () {
		return type;
	}
	
	public int getQualite () {
		return qualite;
	}
	
	public int getPrix () {
		return prix;
	}
	
	public int getQuantite () {
		return qte;
	}
	
}
