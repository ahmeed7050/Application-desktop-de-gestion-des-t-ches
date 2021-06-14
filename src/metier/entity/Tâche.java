 package metier.entity;

public class Tâche {
	
	public String getEtat() {
		return etat;
	} 

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public static int id;
	private String nomDelisteAjouter;
	private String description;
	private String dateLimite;
	private String etat;
	public Tâche() {
		// TODO Auto-generated constructor stub
	}
	
	public Tâche(String nomDelisteAjouter, String description, String dateLimite, String etat) {
		this.nomDelisteAjouter = nomDelisteAjouter;
		this.description = description;
		this.dateLimite = dateLimite;
		this.etat = etat;
		
	}
	public Tâche(String nomDelisteAjouter, String description, String dateLimite) {
		this.nomDelisteAjouter = nomDelisteAjouter;
		this.description = description;
		this.dateLimite = dateLimite;
		
	}
	public Tâche(String description) {
		this.description = description;
		
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateLimite() {
		return dateLimite;
	}

	public void setDateLimite(String dateLimite) {
		this.dateLimite = dateLimite;
	}

	public String getNomDelisteAjouter() {
		return nomDelisteAjouter;
	}

	public void setNomDelisteAjouter(String nomDelisteAjouter) {
		this.nomDelisteAjouter = nomDelisteAjouter;
	}

	
}
