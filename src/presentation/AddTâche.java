package presentation;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.IListeDeTache;
import dao.ListeDeTacheImpl;
import metier.entity.Tâche;

public class AddTâche extends JFrame implements ActionListener{
	
	
	Container container = getContentPane();
    JLabel toDoLabel = new JLabel("Qu'est-ce qui devrait");
    JLabel toDoLabel2 = new JLabel("être fait?:");
    JLabel dateLabel = new JLabel("Date limite:");
    JLabel deconnecterLabel = new JLabel("Déconnecter");
    JLabel listeLabel = new JLabel("Ajouter a la liste de:");
    JButton retourBnt = new JButton("Retour");
    JTextArea toDoArea = new JTextArea(); 
    JComboBox<String> liste=new JComboBox<String>(new String[] {});
    
    JTextField txtDate = new JTextField();
    
	String txtarea;
	String date ;
	String listeCombo;
	boolean checkBox;
    JButton ajouterButton = new JButton("AJOUTER");
    JButton resetButton = new JButton("REINITIALISER");
    JButton addListe = new JButton("");
    JButton deconnecter = new JButton("");
    JButton reload = new JButton();
    JButton modifier = new JButton("Modifier");
    JButton supprimer = new JButton("supprimer");
    JCheckBox check = new JCheckBox("Tâche est terminée?");
    
	TableModele me = new TableModele();
	JTable table = new JTable(me);
	JScrollPane jsp = new JScrollPane(table);

	IListeDeTache action = new ListeDeTacheImpl();

	public AddTâche() {
		super("Add Tâche");
		jsp.setBounds(0, 0, 520, 400);
        
		
		toDoLabel.setBounds(60, 410, 200, 30);
		toDoLabel2.setBounds(60, 430, 200, 30);
		dateLabel.setBounds(60, 480, 100, 30);
		deconnecterLabel.setBounds(7, 625, 60, 50);
		listeLabel.setBounds(60, 550, 150, 30);
		
		toDoArea.setBounds(210, 410, 200, 50);
		txtDate.setBounds(210, 480, 150, 30);
		
		
		liste.setBounds(210, 550, 150, 30);
		addListe.setBounds(330, 550, 150, 30);
		deconnecter.setBounds(0, 600, 50, 50);

		ajouterButton.setBounds(80, 610, 100, 30);
        resetButton.setBounds(210, 610, 100, 30);
        reload.setBounds(425, 620, 100, 30);
        retourBnt.setBounds(340, 610, 100, 30);
        modifier.setBounds(100, 670, 100, 30);
        supprimer.setBounds(210, 670, 100, 30);
        check.setBounds(340, 670, 200, 30);
		
		
		container.setLayout(null);
		container.add(reload);
		container.add(retourBnt);
		container.add(jsp);
		container.add(toDoLabel);
		container.add(toDoLabel2);
		container.add(dateLabel);
		container.add(listeLabel);
		container.add(toDoArea);
		container.add(txtDate);
		container.add(liste);
		container.add(addListe);
		container.add(deconnecter);
		container.add(deconnecterLabel);
		container.add(check);
		
		ajouterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        retourBnt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        supprimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        modifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addListe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deconnecter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		reload.setVisible(false);
		
		modifier.setVisible(false);
		
		supprimer.setVisible(false);
		
		addListe.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Pictures\\list-text.png"));
		addListe.setBorder(BorderFactory.createEmptyBorder());
		addListe.setContentAreaFilled(false);
		addListe.setFocusable(false);
		
		reload.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Pictures\\reload.png"));
		reload.setBorder(BorderFactory.createEmptyBorder());
		reload.setContentAreaFilled(false);
		reload.setFocusable(false);
		
		deconnecter.setIcon(new ImageIcon("C:\\Users\\Ahmed\\Pictures\\log-out.png"));
		deconnecter.setBorder(BorderFactory.createEmptyBorder());
		deconnecter.setContentAreaFilled(false);
		deconnecter.setFocusable(false);
		
		container.add(ajouterButton);
		container.add(resetButton);
		container.add(modifier);
		container.add(supprimer);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(520,80,520,700);
		setVisible(true);
		
		ajouterButton.addActionListener(this);
        resetButton.addActionListener(this);
        addListe.addActionListener(this);
		reload.addActionListener(this);
		retourBnt.addActionListener(this);
		modifier.addActionListener(this);
		supprimer.addActionListener(this); 
		deconnecter.addActionListener(this); 
		
		
		
		txtDate.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_SLASH)))        
			      {
			        JOptionPane.showMessageDialog(null, "Veuillez entrer valide");
			        e.consume();
			      }
			    }
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 
		    
		  });
		List<String> list = action.getListe();
		ajouAuCombo(list);
		
		
		me.chargerTable(action.getAllTâches());
		

		table.addMouseListener(new MouseListener() {
	        @Override
	        public void mouseReleased(MouseEvent e) {
	        }
	        @Override
	        public void mousePressed(MouseEvent e) {
	            
	        }
	        @Override
	        public void mouseExited(MouseEvent e) {
	        }
	        @Override
	        public void mouseEntered(MouseEvent e) {
	        }
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if(table.getSelectedRow() != -1) {

	    			int row = table.getSelectedRow();
	    			toDoArea.setText(table.getModel().getValueAt(row, 1).toString());
	    			txtDate.setText(table.getModel().getValueAt(row, 2).toString());
	    			liste.setSelectedItem(table.getModel().getValueAt(row, 0).toString());
	    			check.setSelected(false);
	    			if(table.getModel().getValueAt(row, 3).toString().equals("Tâche terminée")) {
	    				check.setSelected(true);
	    			}
	    			
	    			txtarea =toDoArea.getText();
	    			date = txtDate.getText();
	    			listeCombo = (String) liste.getSelectedItem();
	    			checkBox = check.isSelected();
	    		}
	    		setBounds(520,80,520,750);
	    		deconnecterLabel.setBounds(7, 675, 60, 50);
	    		deconnecter.setBounds(0, 650, 50, 50);

	    		modifier.setVisible(true);
	    		
	    		supprimer.setVisible(true);
	        }
	    });
		
	}
	public static void main(String[] args) { 
		new AddTâche();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ajouterButton) {
			if (txtDate.getText().equals("") || toDoArea.getText().equals("")) 
				JOptionPane.showMessageDialog(this,  "erreur de saisie");
			else if(action.verifierTache(new Tâche((String) liste.getSelectedItem(),toDoArea.getText(), txtDate.getText())) == false) {
				JOptionPane.showMessageDialog(this,  "Cette tache existe déjà");
			}
			else {
				Tâche t = new Tâche((String) liste.getSelectedItem(),toDoArea.getText(), txtDate.getText());
				
				
	    		int res=JOptionPane.showConfirmDialog(this, 
	    				"liste: "+t.getNomDelisteAjouter()
	    				+"\n Description:  "+ t.getDescription()
	    				+"\n date limite:   "+ t.getDateLimite()
	    				,date, JOptionPane.YES_NO_OPTION );				
	    				
	    				
	    		if(res==0) {		
	    			action.addTache(t);
					me.chargerTable(action.getAllTâches());
	    		}
			}
        }
		

		if (e.getSource() == modifier) {
			if (txtDate.getText().equals(date) && toDoArea.getText().equals(txtarea) && liste.getSelectedItem().equals(listeCombo) && check.isSelected() == checkBox) 
				JOptionPane.showMessageDialog(this,  "S'il vous plaît changer votre tâche ");
			else {
	        	action.getTacheId(txtarea);
	        	String ok;
				if(check.isSelected()) 
					ok = "Tâche terminée";
				else
					ok = "tâche non terminée";
					
				action.modifier(new Tâche((String) liste.getSelectedItem(), toDoArea.getText(), txtDate.getText(), ok));
				me.chargerTable(action.getAllTâches());
			}
        }
		
        if (e.getSource() == resetButton) {
        	toDoArea.setText("");
        	txtDate.setText("");
        	liste.setSelectedIndex(0);
        }
        
        if(table.getSelectedRow() != -1) {

			int row = table.getSelectedRow();
			toDoArea.setText(table.getModel().getValueAt(row, 1).toString());
			txtDate.setText(table.getModel().getValueAt(row, 2).toString());
		}
        

        if (e.getSource() == reload) {
			liste.removeAllItems();
    		List<String> list = action.getListe();
    		ajouAuCombo(list);
        }
        
        if (e.getSource() == addListe) {
    		new AjouterAListe();
    		
    		reload.setVisible(true);
        }
        if (e.getSource() == supprimer) {
        	action.getTacheId(txtarea);
        	action.suprimerTache();
			me.chargerTable(action.getAllTâches());
        }
        if (e.getSource() == deconnecter) {
        	int res=JOptionPane.showConfirmDialog(this, 
    				"voulez-vous vraiment vous déconnecter? ",
    				"Confirmation",JOptionPane.YES_NO_OPTION );	
        	if(res==0) {
            	new Login();
            	dispose();
        	}
        }
        if (e.getSource() == retourBnt) {
        	new LesTâches();
        	dispose();
        	
        }
	}
	
	private void ajouAuCombo(List<String> list) {
		liste.addItem("Par Défaut");
		for (String nom : list) {
			liste.addItem(nom);
		}
	}
}
