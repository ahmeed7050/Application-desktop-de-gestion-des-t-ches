package dao;

import java.util.List;

import metier.entity.Liste;
import metier.entity.T�che;
import metier.entity.User;

public interface IListeDeTache {
	void addTache(T�che t);
	void modifier(T�che t);
	List<T�che> getAllT�ches();
	List<T�che> getTacheParNom(String s);
	List<T�che> getTacheParListe(String s);
	List<T�che> getTacheParNomEtListe(String n, String l);
	boolean addUser(User e);
	boolean verifierUser(User e);
	boolean verifierTache(T�che e);
	boolean addListe(Liste l);
	List<String> getListe();
	void suprimerTache();
	void getTacheId(String t);
	
}
