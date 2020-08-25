package verger;

import java.util.Date;

public class Depence {
	private int id;
	private String date;
	private String paye_pour;
	private String article;
	private float montant;
	private String machine;
	private String location;
	private String note;
	
	public Depence() {
		
	}
	
	public Depence(int id, String location, String date,  String paye_pour, String article, float montant, String machine, String note) {
		this.id = id;
		this.date = date;
		this.paye_pour = paye_pour;
		this.article = article;
		this.montant = montant;
		this.machine = machine;
		this.location = location;
		this.note = note;
	}
	
	public Depence(String location, String date, String paye_pour, String article, float montant, String machine, String note) {
		this.date = date;
		this.paye_pour = paye_pour;
		this.article = article;
		this.montant = montant;
		this.machine = machine;
		this.location = location;
		this.note = note;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public void setDate (String date) {
		this.date = date;
	}
	
	public void setPayePour(String paye_pour) {
		this.paye_pour = paye_pour;
	}
	
	public void setArticle (String article) {
		this.article = article;
	}
	
	public void setMontant (float montant) {
		this.montant = montant;
	}
	
	public void setMachine (String machine) {
		this.machine = machine;
	}
	
	public void setLocation (String location) {
		this.location = location;
	}
	
	public void setNote (String note) {
		this.note = note;
	}
	
	public int getId () {
		return id;
	}
	
	public String getDate () {
		return date;
	}
	
	public String getPayePour() {
		return paye_pour;
	}
	
	public String getArticle () {
		return article;
	}
	
	public float getMontant () {
		return montant;
	}
	
	public String getMachine () {
		return machine;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getNote () {
		return note;
	}
	
}
