package application;

public class employe_d {
	private   String  nom;
	private   String  prenom;
	private   String cin;
	private   String emploi;
	private   String demande;
	private   String date_debut;
	private   String date_fin;
	private    String reponse;
	
	
	
	 
	
	
	
	public employe_d() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*service.getItems().addAll("Valid�","refus�");
	service.setOnAction(event -> {
	
	});*/

	
	
	public employe_d( String nom, String prenom,  String demande,String cin, String emploi, String date_debut,
			String date_fin,String reponse) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.emploi = emploi;
		this.demande = demande;
		this.date_debut =date_debut;
		this.date_fin = date_fin;
		this.reponse=reponse;
	}




	



	public String getReponse() {
		return reponse;
	}



	public void setReponse(String reponse) {
		this.reponse = reponse;
	}



	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getCin() {
		return cin;
	}




	public void setCin(String cin) {
		this.cin = cin;
	}




	public String getEmploi() {
		return emploi;
	}




	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}



	public String getDemande() {
		return demande;
	}




	public void setDemande(String demande) {
		this.demande = demande;
	}




	public String getDate_debut() {
		return date_debut;
	}




	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}




	public String getDate_fin() {
		return date_fin;
	}




	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}












	
	
	 
	


	
}
