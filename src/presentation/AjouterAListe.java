package presentation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.IListeDeTache;
import dao.ListeDeTacheImpl;
import metier.entity.Liste;
import metier.entity.User;

public class AjouterAListe extends JFrame implements ActionListener{
	Container container = getContentPane();
    JLabel ajouLabel = new JLabel("Ajouter à la liste:");
    JTextField ajouTextField = new JTextField();
    JButton ajouterButton = new JButton("AJOUTER");
    JButton retourButton = new JButton("RETOUR");
    
	IListeDeTache action = new ListeDeTacheImpl();
    
    JPanel p1 = new JPanel();
    
    public AjouterAListe() {
    	super("To Do");
		
		 
		
		container.setLayout(null);
		ajouLabel.setBounds(30, 20, 200, 90);
		ajouTextField.setBounds(200, 50, 150, 30);
		ajouterButton.setBounds(100, 100, 100, 30);
		retourButton.setBounds(200, 100, 100, 30);
		
		container.add(ajouLabel);
		container.add(ajouTextField);
		
		container.add(ajouterButton);
		container.add(retourButton);
		
		
		ajouterButton.addActionListener(this);
		retourButton.addActionListener(this);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(580,560,400,200);
		setVisible(true); 
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ajouterButton) {
            String txt = ajouTextField.getText();
            if (action.addListe(new Liste(User.id, txt))) {
                JOptionPane.showMessageDialog(this, "Ajout réussi!!");
                ajouTextField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Ce nom existe déjà");
            }

        }
        if (e.getSource() == retourButton) {
        	dispose();
        }
    }
    
    public static void main(String[] args) {
		new AjouterAListe();
	}
}
