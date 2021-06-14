package dao;

import java.util.List;

import metier.entity.Liste;
import metier.entity.Tâche;
import metier.entity.User;

public interface IListeDeTache {
	void addTache(Tâche t);
	void modifier(Tâche t);
	List<Tâche> getAllTâches();
	List<Tâche> getTacheParNom(String s);
	List<Tâche> getTacheParListe(String s);
	List<Tâche> getTacheParNomEtListe(String n, String l);
	boolean addUser(User e);
	boolean verifierUser(User e);
	boolean verifierTache(Tâche e);
	boolean addListe(Liste l);
	List<String> getListe();
	void suprimerTache();
	void getTacheId(String t);
	
}
