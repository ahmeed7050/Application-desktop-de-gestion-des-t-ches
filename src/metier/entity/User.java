package metier.entity;

public class User {
	public static int id;
	private String pseudo;
	private String email;
	private String mdp;
	
	public User(int id, String pseudo, String email, String mdp) {
		User.id = id;
		this.pseudo = pseudo;
		this.email = email; 
		this.mdp = mdp;
	}
	public User(String pseudo, String mdp) {
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	public User(String pseudo, String email, String mdp) {
		this.pseudo = pseudo;
		this.email = email;
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		User.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
