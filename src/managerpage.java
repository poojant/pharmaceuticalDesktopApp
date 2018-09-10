import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managerpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerpage frame = new managerpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public managerpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagersPage = new JLabel("Managers Page");
		lblManagersPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblManagersPage.setBounds(10, 28, 120, 14);
		contentPane.add(lblManagersPage);
		
		JButton btnEmployeeInformation = new JButton("Employee Information");
		btnEmployeeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(0);
				employeeinfo emplinfo = new employeeinfo();
				emplinfo.setVisible(true);
			}
		});
		btnEmployeeInformation.setBounds(10, 82, 185, 23);
		contentPane.add(btnEmployeeInformation);
		
		JButton btnNewButton = new JButton("Company Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(0);
				companyinfo compinfo = new companyinfo();
				compinfo.frmCompanyinform.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 129, 185, 23);
		contentPane.add(btnNewButton);
		
		JButton btnStockCheck = new JButton("Stock Check");
		btnStockCheck.setBounds(10, 175, 185, 23);
		contentPane.add(btnStockCheck);
		
		JButton btnBackToLogin = new JButton("Back to Login Page");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			contentPane.remove(0);
			
			HelloWorldClass hwc = new HelloWorldClass();
			//hwc.initialize()
			hwc.frmPharmaceuticalShop.setVisible(true);
			}
			
		});
		btnBackToLogin.setBounds(10, 218, 185, 23);
		contentPane.add(btnBackToLogin);
	}
}
