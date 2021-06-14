package presentation;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.IListeDeTache;
import dao.ListeDeTacheImpl;
import metier.entity.Tâche;

public class LesTâches extends JFrame implements ActionListener{
	
	
	Container container = getContentPane();
    JLabel chercheLabel = new JLabel("Recherche par :");
    JLabel deconnecterLabel = new JLabel("Déconnecter");
    JComboBox<String> liste=new JComboBox<String>(new String[] {});
    JTextField descriptionTxt = new JTextField();
    
    
    JButton ajouterButton = new JButton("Ajouter/Modifier");
    JButton rechercheButton = new JButton("Recherche");
    JButton deconnecter = new JButton("");
    
    JRadioButton parListe = new JRadioButton("liste");
    JRadioButton parNom = new JRadioButton("Description");
    JRadioButton parLesDeux = new JRadioButton("Les Deux");
    
	TableModele me = new TableModele();
	JTable table = new JTable(me);
	JScrollPane jsp = new JScrollPane(table);
	

	IListeDeTache action = new ListeDeTacheImpl();

	public LesTâches() {
		super("ToDo");
		jsp.setBounds(0, 0, 520, 400);
        
		
		chercheLabel.setBounds(60, 450, 200, 30);
		parListe.setBounds(180, 450, 50, 30);
		parNom.setBounds(250, 450, 100, 30);
		parLesDeux.setBounds(350, 450, 100, 30);

		ButtonGroup bg=new ButtonGroup();
		bg.add(parListe);
	    bg.add(parNom);
	    bg.add(parLesDeux);

		liste.setBounds(100, 510, 150, 30);
		descriptionTxt.setBounds(100, 510, 150, 30);

		ajouterButton.setBounds(200, 610, 120, 30);
        rechercheButton.setBounds(280, 510, 100, 30);

		deconnecterLabel.setBounds(7, 625, 60, 50);
		deconnecter.setBounds(0, 600, 50, 50);

		
        
        deconnecter.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Pictures\\log-out.png"));
		deconnecter.setBorder(BorderFactory.createEmptyBorder());
		deconnecter.setContentAreaFilled(false);
		deconnecter.setFocusable(false);
		
		container.setLayout(null);
		container.add(jsp);
		container.add(chercheLabel);
		container.add(liste);
		container.add(deconnecter);
		container.add(deconnecterLabel);
		container.add(parNom);
		container.add(parListe);
		container.add(parLesDeux);
		container.add(descriptionTxt);
		
		ajouterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rechercheButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deconnecter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
		descriptionTxt.setVisible(false);
		liste.setVisible(false);
		rechercheButton.setVisible(false);
		
		container.add(ajouterButton);
		container.add(rechercheButton);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(520,80,520,700);
		setVisible(true);
		
		ajouterButton.addActionListener(this);
        rechercheButton.addActionListener(this);
		

		deconnecter.addActionListener(this);
		parListe.addActionListener(this);
		parNom.addActionListener(this);
		parLesDeux.addActionListener(this);
		rechercheButton.addActionListener(this);
		
		
		
		List<String> list = action.getListe();
		ajouAuCombo(list);
		
		
		me.chargerTable(action.getAllTâches());
		

		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == deconnecter) {
	        	int res=JOptionPane.showConfirmDialog(this, 
	    				"voulez-vous vraiment vous déconnecter? ",
	    				"Confirmation",JOptionPane.YES_NO_OPTION );	
	        	if(res==0) {
	            	new Login();
	            	dispose();
	        	}
	        }
		 if (e.getSource() == parListe) {
			 liste.setVisible(true);
			 descriptionTxt.setVisible(false);
			 rechercheButton.setVisible(true);
		     rechercheButton.setBounds(280, 510, 100, 30);
			 
	     }
		 if (e.getSource() == parNom) {
			 liste.setVisible(false);
			 descriptionTxt.setVisible(true);
			 rechercheButton.setVisible(true);
		     rechercheButton.setBounds(280, 510, 100, 30);
			 descriptionTxt.setBounds(100, 510, 150, 30);
	     }
		 if (e.getSource() == parLesDeux) {
			 liste.setVisible(true);
			 descriptionTxt.setVisible(true);
			 rechercheButton.setVisible(true);
			 descriptionTxt.setBounds(100, 550, 150, 30);
		     rechercheButton.setBounds(280, 530, 100, 30);
	     }
		 if (e.getSource() == rechercheButton) {
			 if(parNom.isSelected()) {
				 List<Tâche> res = action.getTacheParNom(descriptionTxt.getText());
				 me.chargerTable(res);
			 }
			 if(parListe.isSelected()) {
				 List<Tâche> res = action.getTacheParListe((String) liste.getSelectedItem());
				 me.chargerTable(res);
			 }
			 if(parLesDeux.isSelected()) {
				 List<Tâche> res = action.getTacheParNomEtListe(descriptionTxt.getText(), (String) liste.getSelectedItem());
				 me.chargerTable(res);
			 }
	     }
		 if (e.getSource() == ajouterButton) {
			 new AddTâche();
			 dispose();
	     }
		
	}
	
	private void ajouAuCombo(List<String> list) {
		liste.addItem("Par Défaut");
		for (String nom : list) {
			liste.addItem(nom);
		}
	}
	public static void main(String[] args) {
		new LesTâches();
	}
}
