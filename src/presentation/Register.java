package presentation;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.IListeDeTache;
import dao.ListeDeTacheImpl;
import metier.entity.User;

public class Register extends JFrame implements ActionListener{
	Container container = getContentPane();
    JLabel userLabel = new JLabel("PSEUDO:");
    JLabel emailLabel = new JLabel("EMAIL:");
    JLabel passwordLabel = new JLabel("MOT DE PASSE:");
    JLabel repeatPasswordLabel = new JLabel("RÉPÉTER LE MOT DE PASSE :");
    JLabel label = new JLabel("Êtes vous membre?");
    JLabel loginLabel = new JLabel("Connecte-toi");
    JTextField userTextField = new JTextField();
    JTextField emailTextField = new JTextField(); 
    JPasswordField passwordField = new JPasswordField();
    JPasswordField repeatPasswordField = new JPasswordField();
    JButton signUpButton = new JButton("S'INSCRIRE");
    JButton resetButton = new JButton("REINITIALISER");

	IListeDeTache action = new ListeDeTacheImpl();
    
    


	
	
	public Register() {
		super("ToDo");
		container.setLayout(null);
		userLabel.setBounds(50, 100, 100, 30);
		emailLabel.setBounds(50, 170, 100, 30);
        passwordLabel.setBounds(50, 240, 100, 30);
        repeatPasswordLabel.setBounds(50, 310, 100, 30);
        
        userTextField.setBounds(150, 100, 150, 30);
        emailTextField.setBounds(150, 170, 150, 30);
        passwordField.setBounds(150, 240, 150, 30);
        repeatPasswordField.setBounds(150, 310, 150, 30);
        
        signUpButton.setBounds(50, 400, 100, 30);
        resetButton.setBounds(200, 400, 100, 30);
        
        JPanel loginLabelPanel = new JPanel();
        loginLabelPanel.add(label);
        loginLabelPanel.add(loginLabel);
        loginLabelPanel.setBounds(75, 450, 200, 30);

        signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        
        container.add(userLabel);
        container.add(emailLabel);
        container.add(passwordLabel);
        container.add(repeatPasswordLabel);
        container.add(userTextField);
        container.add(emailTextField);
        container.add(passwordField);
        container.add(repeatPasswordField);
        container.add(signUpButton);
        container.add(resetButton);
        container.add(loginLabelPanel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(580,150,370,600);
		setVisible(true);
		
		signUpButton.addActionListener(this);
        resetButton.addActionListener(this);

		Font font = loginLabel.getFont();
	    Map attributes = font.getAttributes();
	    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    loginLabel.setFont(font.deriveFont(attributes));
	    
	    
		loginLabel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Login();
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
        
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            String pseudo = userTextField.getText();
            String email = emailTextField.getText();
            String mdp = passwordField.getText();
            String repeatMdp = repeatPasswordField.getText();
            if(!mdp.equals(repeatMdp)){
            	 JOptionPane.showMessageDialog(this, "erreur de saisie");
            }else {
            	if (action.addUser(new User(pseudo, email, mdp))) {
                    JOptionPane.showMessageDialog(this, "Inscription réussie ");
                    new Login();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Ce compte existe déjà");
                }
            }
            
            
        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            emailTextField.setText("");
            passwordField.setText("");
            repeatPasswordField.setText("");
        }
      
    }
}
