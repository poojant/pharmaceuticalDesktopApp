import java.awt.EventQueue;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;



public class HelloWorldClass {
	 

	JFrame frmPharmaceuticalShop;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldClass window = new HelloWorldClass();
					window.frmPharmaceuticalShop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	/**
	 * Create the application.
	 */
	public HelloWorldClass() {
		con = sqlconnector.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmaceuticalShop = new JFrame();
		frmPharmaceuticalShop.setTitle("Pharmaceutical Company");
		frmPharmaceuticalShop.setBounds(100, 100, 533, 355);
		frmPharmaceuticalShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPharmaceuticalShop.getContentPane().setLayout(null);
		
		JButton btnGo = new JButton("Login");
		btnGo.setBackground(new Color(0, 204, 255));
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try
				{	int count =0;
					String query = "select * from data where username =? and password =? ";
				    PreparedStatement pst = con.prepareStatement(query);
				    pst.setString(1,textField.getText());
				    pst.setString(2,passwordField.getText());
				    
				    ResultSet rs = pst.executeQuery();
				    rs.next();
				    int usn = rs.getInt(1);
				    if(usn == 101)
				    {
				    	JOptionPane.showMessageDialog(null, "Manager Login Successful");
				    	frmPharmaceuticalShop.dispose();
				    	managerpage mngp = new managerpage();
				    	mngp.setVisible(true);
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "Employee Login Successful");
				    	frmPharmaceuticalShop.dispose();
				    	employeepage empl = new employeepage();
				    	empl.setVisible(true);
				    }
				    
				    rs.close();
				    pst.close();
				    
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
				}

			}
		});
		btnGo.setBounds(169, 241, 89, 23);
		frmPharmaceuticalShop.getContentPane().add(btnGo);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(94, 151, 60, 14);
		frmPharmaceuticalShop.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(169, 148, 133, 20);
		frmPharmaceuticalShop.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(94, 196, 60, 14);
		frmPharmaceuticalShop.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 193, 133, 20);
		frmPharmaceuticalShop.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/company.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(169, 11, 133, 118);
		frmPharmaceuticalShop.getContentPane().add(lblNewLabel);
	}
}
