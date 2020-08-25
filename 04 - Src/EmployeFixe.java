package verger;

public class EmployeFixe extends Employe{
	private int montant_par_mois;
	private String date_payement;
	
	public EmployeFixe() {
		
	}
	
	public EmployeFixe(Employe e, int montant_par_mois, String date_payement) {
		super(e.getId(), e.getnomV(), e.getPrenom(), e.getnom(), e.getDateExpSejour(),e.getMode());
		this.montant_par_mois = montant_par_mois;
		this.date_payement = date_payement;
	}
	
	public EmployeFixe(int id, String nomV, String prenom, String nom, String date_payement, String date_exp_sejour, int mode, int montant_par_mois) {
		super(id, nomV, prenom, nom, date_exp_sejour,mode);
		this.montant_par_mois = montant_par_mois;
		this.date_payement = date_payement;
	}
	
	public void setMontant (int montant_par_mois) {
		this.montant_par_mois = montant_par_mois;
	}

	public void setDateDePayement (String date_payement) {
		this.date_payement = date_payement;
	}
	
	public int getMontant() {
		return montant_par_mois;
	}

	public String getDateDePayement () {
		return date_payement;
	}
	
}
