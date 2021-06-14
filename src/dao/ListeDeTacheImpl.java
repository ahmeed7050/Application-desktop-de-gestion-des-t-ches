package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entity.Liste;
import metier.entity.Tâche;
import metier.entity.User;

public class ListeDeTacheImpl implements IListeDeTache{
	
	@Override
	public void addTache(Tâche t) {
		Connection cx = SingletonConnection.getConnection();
			try {
				PreparedStatement st = cx.prepareStatement("insert into taches(utilisateur_id, liste, description, date_limite) value(?,?,?,?)");
				st.setInt(1, User.id);
				st.setString(2, t.getNomDelisteAjouter());
				st.setString(3, t.getDescription());
				st.setString(4, t.getDateLimite());
				st.executeUpdate();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		
	}
	

	
	@Override
	public boolean addUser(User u) {
		User user = new User(u.getPseudo(), u.getEmail(), u.getMdp());
		if(this.verifierUser(user)) {
			return false;
		}
		
		Connection cx = SingletonConnection.getConnection();
		try {
			PreparedStatement st = cx.prepareStatement("insert into utilisateur(username, password, Email) value(?,?,?)");
			st.setString(1, u.getPseudo());
			st.setString(2, u.getEmail());
			st.setString(3, u.getMdp());
			st.executeUpdate();
			return true;
		}catch(SQLException e1) {
			e1.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean verifierUser(User u) {

		Connection cx = SingletonConnection.getConnection();
		String pseudo = u.getPseudo();
		String mdp = u.getMdp();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from utilisateur");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setPseudo(rs.getString(2));
				u.setMdp(rs.getString(4));
				if(pseudo.equals(u.getPseudo())  && mdp.equals(u.getMdp())) {
					User.id  = rs.getInt(1);
					return true;
				}
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean addListe(Liste l) {

		Connection cx = SingletonConnection.getConnection();
		String nom = l.getNom();
		
		try {
			PreparedStatement ps = cx.prepareStatement("select nom from liste where userid = ? and nom = ?");
			ps.setInt(1, User.id);
			ps.setString(2, nom);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement st = cx.prepareStatement("insert into liste(userid, nom) value(?,?)");
			st.setInt(1, User.id);
			st.setString(2, nom);
			st.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		return true;
	}
	
	public List<String> getListe(){
		Connection cx = SingletonConnection.getConnection();
		List<String> liste = new ArrayList<>();
		
		try {
			PreparedStatement ps = cx.prepareStatement("select nom from liste where userid = ?");
			ps.setInt(1, User.id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				liste.add(rs.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Tâche> getAllTâches() {
		// TODO Auto-generated method stub
		Connection cx = SingletonConnection.getConnection();
		List<Tâche> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from taches where utilisateur_id = ?");
			ps.setInt(1, User.id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tâche e = new Tâche();
				e.setNomDelisteAjouter(rs.getString(3));
				e.setDescription(rs.getString(4));
				e.setDateLimite(rs.getString(5));
				e.setEtat(rs.getString(6));
				liste.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}



	@Override
	public void modifier(Tâche t) {
		Connection cx = SingletonConnection.getConnection();
			try {
				PreparedStatement st = cx.prepareStatement("update taches set liste=?, description=?, date_limite=?, etat=? where id=?");
				st.setString(1, t.getNomDelisteAjouter());
				st.setString(2, t.getDescription());
				st.setString(3, t.getDateLimite());
				st.setString(4, t.getEtat());
				st.setInt(5, Tâche.id);
				st.executeUpdate();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		
		
	}
	@Override
	public void suprimerTache() {
		// TODO Auto-generated method stub
		Connection cx = SingletonConnection.getConnection();
		try {
			PreparedStatement st = cx.prepareStatement("delete from taches where id=?");
			st.setInt(1, Tâche.id);
			st.executeUpdate();
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void getTacheId(String t) {
		Connection cx = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from taches where utilisateur_id = ?");
			ps.setInt(1, User.id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(4).equals(t)) {
					Tâche.id  = rs.getInt(1);
				}
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
	}



	@Override
	public boolean verifierTache(Tâche t) {
		Connection cx = SingletonConnection.getConnection();
		String liste = t.getNomDelisteAjouter();
		String description = t.getDescription();

		try {
			PreparedStatement ps = cx.prepareStatement("select * from taches where utilisateur_id = ?");
			ps.setInt(1, User.id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t.setDescription(rs.getString(4));
				t.setNomDelisteAjouter(rs.getString(3));
				if(liste.equals(t.getNomDelisteAjouter())  && description.equals(t.getDescription())) {
					return false;
				}
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
		return true;
	}



	@Override
	public List<Tâche> getTacheParNom(String s) {
		Connection cx = SingletonConnection.getConnection();
		List<Tâche> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from taches where description like ? && utilisateur_id = ?");
			ps.setString(1 , "%" + s + "%");
			ps.setInt(2 , User.id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tâche e = new Tâche();
				e.setNomDelisteAjouter(rs.getString(3));
				e.setDescription(rs.getString(4));
				e.setDateLimite(rs.getString(5));
				e.setEtat(rs.getString(6));
				liste.add(e);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
	}



	@Override
	public List<Tâche> getTacheParListe(String s) {
		Connection cx = SingletonConnection.getConnection();;
		List<Tâche> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from taches where liste = ? && utilisateur_id = ?");
			ps.setString(1 ,s);
			ps.setInt(2 , User.id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tâche e = new Tâche();
				e.setNomDelisteAjouter(rs.getString(3));
				e.setDescription(rs.getString(4));
				e.setDateLimite(rs.getString(5));
				e.setEtat(rs.getString(6));
				liste.add(e);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
	}



	@Override
	public List<Tâche> getTacheParNomEtListe(String n, String l) {
		Connection cx = SingletonConnection.getConnection();;
		List<Tâche> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from taches where description like ? && liste = ? && utilisateur_id = ?");
			ps.setString(1 , "%" + n + "%");
			ps.setString(2 , l);
			ps.setInt(3 , User.id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tâche e = new Tâche();
				e.setNomDelisteAjouter(rs.getString(3));
				e.setDescription(rs.getString(4));
				e.setDateLimite(rs.getString(5));
				e.setEtat(rs.getString(6));
				liste.add(e);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
		}
	
	
	
	
}
