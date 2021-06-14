package metier.entity;

public class Liste {
	private int userId;
	private String nom;
	
	public Liste(int userId, String nom) {
		this.userId = userId;
		this.nom = nom;
	}
	public Liste() {
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getUserId() {
		return userId;
	} 

	public void  setUserId(int userId) {
		this.userId = userId;
	}
	
}
