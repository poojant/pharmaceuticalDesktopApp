import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;

public class SalesData extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldStkAvailable;
	private JTextField textFieldStkSold;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesData frame = new SalesData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTextField textFieldCp;
	public void refreshTable()
	{
		try
		{
			String query="select * from `stock`";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
		}
		catch(Exception ex1)
		{
			ex1.printStackTrace();
			
		}
	}
	/**
	 * Create the frame.
	 */
	public SalesData() {
		conn=sqlconnector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loadTable = new JButton("LOAD SALES TABLE");
		loadTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		loadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="select * from `stock`";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
				}
				catch(Exception ex1)
				{
					ex1.printStackTrace();
					
				}
			}
		});
		loadTable.setBounds(383, 11, 247, 31);
		contentPane.add(loadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 63, 445, 379);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton Save = new JButton("SAVE");
		Save.setFont(new Font("Tahoma", Font.BOLD, 15));
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String query="insert into `stock` (`medId`, `medName`, `stockAvailable`, `stockSold`, `perCost`) values (?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textFieldId.getText());
					pst.setString(2, textFieldName.getText());
					pst.setString(3, textFieldStkAvailable.getText());
					pst.setString(4, textFieldStkSold.getText());
					pst.setString(5, textFieldCp.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "DATA SAVED!!!!");
					
					pst.close();
					
				}
				catch(Exception ex2)
				{
					ex2.printStackTrace();
				}
				refreshTable();
			}
		});
		Save.setBounds(67, 284, 129, 32);
		contentPane.add(Save);
		
		JButton Delete = new JButton("DELETE");
		Delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="delete from `stock` where `medId`='"+textFieldId.getText()+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "DATA DELETED!!!!");
					
					pst.close();
					
				}
				catch(Exception ex3)
				{
					ex3.printStackTrace();
				}
				refreshTable();
			}
		});
		Delete.setBounds(67, 327, 129, 35);
		contentPane.add(Delete);
		
		JButton Update = new JButton("UPDATE");
		Update.setFont(new Font("Tahoma", Font.BOLD, 15));
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="update from `stock` set `medId`='"+textFieldId.getText()+"' ,`medName`='"+textFieldName.getText()+"' ,`stockAvailable`='"+textFieldStkAvailable.getText()+"' ,`stockSold`='"+textFieldStkSold.getText()+"' ,`perCost`='"+textFieldCp.getText()+"' where `medId`='"+textFieldId.getText()+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "DATA UPDATED!!!!");
					
					pst.close();
					
				}
				catch(Exception ex4)
				{
					ex4.printStackTrace();
				}
				refreshTable();
			}
		});
		Update.setBounds(67, 373, 129, 31);
		contentPane.add(Update);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(138, 88, 129, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(138, 122, 129, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldStkAvailable = new JTextField();
		textFieldStkAvailable.setBounds(138, 160, 129, 20);
		contentPane.add(textFieldStkAvailable);
		textFieldStkAvailable.setColumns(10);
		
		textFieldStkSold = new JTextField();
		textFieldStkSold.setBounds(138, 194, 129, 20);
		contentPane.add(textFieldStkSold);
		textFieldStkSold.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("STOCK SOLD:-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 197, 119, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STOCK AVAILABLE:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 163, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MEDICINE NAME:-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 125, 119, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MEDICINE ID:-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 91, 118, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CP PER STOCK:-");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 232, 119, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldCp = new JTextField();
		textFieldCp.setBounds(138, 229, 129, 20);
		contentPane.add(textFieldCp);
		textFieldCp.setColumns(10);
		
		refreshTable();
	}
}