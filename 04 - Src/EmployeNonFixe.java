package verger;

public class EmployeNonFixe extends Employe{
	private int nbh_abscent;
	private int nbh_plus;
	private int nbj_travaille;
	private int montant_par_jour;
	private String date_payement;
	
	public EmployeNonFixe() {
		
	}
	
	public EmployeNonFixe(Employe e, int nbh_abscent, int nbh_plus, int nbj_travaille, int montant_par_jour, String date_payement) {
		super(e.getId(), e.getnomV(), e.getPrenom(), e.getnom(), e.getDateExpSejour(),e.getMode());
		this.nbh_abscent = nbh_abscent;
		this.nbh_plus = nbh_plus;
		this.nbj_travaille = nbj_travaille;
		this.montant_par_jour = montant_par_jour;
		this.date_payement = date_payement;
	}
	
	public EmployeNonFixe(int id, String nomV, String prenom, String nom, String date_exp_sejour, int mode, int nbh_abscent, int nbh_plus, int nbj_travaille, int montant_par_jour, String date_payement) {
		super(id, nomV, prenom, nom, date_exp_sejour,mode);
		this.nbh_abscent = nbh_abscent;
		this.nbh_plus = nbh_plus;
		this.nbj_travaille = nbj_travaille;
		this.montant_par_jour = montant_par_jour;
		this.date_payement = date_payement;
	}
	
	public void setNBHAbscrnt(int nbh_abscent) {
		this.nbh_abscent = nbh_abscent;
	}
	
	public void setNBHPlus (int nbh_plus) {
		this.nbh_plus = nbh_plus;
	}
	
	public void setNBJTravaille (int nbj_travaille) {
		this.nbj_travaille = nbj_travaille;
	}
	
	public void setMontant (int montant_par_jour) {
		this.montant_par_jour = montant_par_jour;
	}

	public void setDateDePayement (String date_payement) {
		this.date_payement = date_payement;
	}
	
	public int getNBHAbscrnt() {
		return nbh_abscent;
	}
	
	public int getNBHPlus () {
		return nbh_plus;
	}
	
	public int getNBJTravaille () {
		return nbj_travaille;
	}
	
	public int getMontant () {
		return montant_par_jour;
	}

	public String getDateDePayement () {
		return date_payement;
	}
	
}
