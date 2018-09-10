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

public class employeepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeepage frame = new employeepage();
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
	public employeepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeePage = new JLabel("Employee Page");
		lblEmployeePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeePage.setBounds(22, 38, 114, 14);
		contentPane.add(lblEmployeePage);
		
		JButton btnStockCheck = new JButton("Stock Check");
		btnStockCheck.setBounds(22, 95, 188, 23);
		contentPane.add(btnStockCheck);
		
		JButton btnEditTargetCompleted = new JButton("Edit Target Completed");
		btnEditTargetCompleted.setBounds(22, 152, 188, 23);
		contentPane.add(btnEditTargetCompleted);
		
		JButton btnBackToLogin = new JButton("Back to Login Page");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(0);
				HelloWorldClass hwc = new HelloWorldClass();
				//hwc.initialize()
				hwc.frmPharmaceuticalShop.setVisible(true);
				
			}
		});
		btnBackToLogin.setBounds(22, 260, 188, 23);
		contentPane.add(btnBackToLogin);
		
		JButton btnEditStockLeft = new JButton("Edit Stock Left");
		btnEditStockLeft.setBounds(22, 206, 188, 23);
		contentPane.add(btnEditStockLeft);
	}
}
