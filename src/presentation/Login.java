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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import metier.entity.User;
import dao.*;

public class Login extends JFrame implements ActionListener{
	Container container = getContentPane();
    JLabel userLabel = new JLabel("PSEUDO");
    JLabel passwordLabel = new JLabel("MOT DE PASSE");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("CONNEXION"); 
    JButton resetButton = new JButton("RÉINITIALISER");
    JLabel register = new JLabel("S'inscrire");
    JCheckBox showPassword = new JCheckBox("Montrer le mdp");
 
	IListeDeTache action = new ListeDeTacheImpl();

	
	
	public Login() {
		super("ToDo");
		container.setLayout(null);
		userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(190, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        register.setBounds(240, 340, 100, 30);
        
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Font font = register.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        register.setFont(font.deriveFont(attributes));
        
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(register);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(580,150,370,600);
		setVisible(true);
		
		
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        
        
        register.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Register();
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
		        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}


			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String pseudo = userTextField.getText();
            String mdp = passwordField.getText();
            if (action.verifierUser(new User(pseudo, mdp))) {
                JOptionPane.showMessageDialog(this, "Connexion réussie");
                new LesTâches();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nom d'utilisateur ou mot de passe invalide");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
	
	public static void main(String[] args) {
		new Login();
	}
	
}
