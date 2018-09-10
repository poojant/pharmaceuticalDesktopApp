import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class employeeinfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeinfo frame = new employeeinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	/**
	 * Create the frame.
	 */
	public employeeinfo() {
		con = sqlconnector.dbConnector();
		setDefaultCloseOperation(employeeinfo.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeList = new JLabel("Employee List");
		lblEmployeeList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmployeeList.setBounds(20, 26, 101, 14);
		contentPane.add(lblEmployeeList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 85, 452, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadData = new JButton("Press to Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "Select * from data";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
					
				}
				catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null, ae);
			    }
				
				}
		});
		btnLoadData.setBounds(161, 51, 162, 23);
		contentPane.add(btnLoadData);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(0);
				managerpage mngp = new managerpage();
				mngp.setVisible(true);
				
			}
		});
		btnBack.setBounds(393, 11, 89, 23);
		contentPane.add(btnBack);
	}
}
