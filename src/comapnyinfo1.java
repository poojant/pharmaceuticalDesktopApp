import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class comapnyinfo1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comapnyinfo1 frame = new comapnyinfo1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	private JTextField Year1;
	private JTextField Year2;
	private JTextField Year3;

	/**
	 * Create the frame.
	 */
	public comapnyinfo1() {
		setTitle("companyinform");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Year1 = new JTextField();
		Year1.setBounds(59, 54, 100, 30);
		contentPane.add(Year1);
		Year1.setColumns(10);
		
		Year2 = new JTextField();
		Year2.setBounds(287, 54, 100, 30);
		contentPane.add(Year2);
		Year2.setColumns(10);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBackground(Color.YELLOW);
		lblFrom.setForeground(Color.GRAY);
		lblFrom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFrom.setBounds(69, 94, 69, 23);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.GRAY);
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTo.setBackground(Color.YELLOW);
		lblTo.setBounds(323, 100, 46, 14);
		contentPane.add(lblTo);
		
		Year3 = new JTextField();
		Year3.setText("");
		Year3.setBounds(175, 185, 114, 30);
		contentPane.add(Year3);
		Year3.setColumns(10);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblYear.setForeground(Color.GRAY);
		lblYear.setBackground(Color.YELLOW);
		lblYear.setBounds(189, 226, 100, 23);
		contentPane.add(lblYear);
		
		
		JButton btnNewButton = new JButton("Profit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String y1 = Year1.getText();
					int f = new Integer(y1);
					String y2 = Year2.getText();
					int t = new Integer(y2);
					String query="SELECT `Year`, `Net  Profit(+)/Loss(-)` FROM `balance` WHERE `Year` BETWEEN "+f+" AND "+t+" ";
					JDBCCategoryDataset dcd = new JDBCCategoryDataset(sqlconnector.dbConnector(),query);
					JFreeChart chart = ChartFactory.createLineChart("Balance chart", "Year", "Profit", dcd,PlotOrientation.VERTICAL,false,true,true);
					BarRenderer r = null;
					CategoryPlot plot = null;
					r = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query Chart",chart);
					frame.setVisible(true);
					frame.setSize(350, 300);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(189, 120, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnShare = new JButton("Share");
		btnShare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                try {
					String y3 = Year3.getText();
					int y = new Integer(y3);
					String query1="SELECT `Month` , `Price` FROM `shares` WHERE `Year` = "+y+"";
					JDBCCategoryDataset dcd1 = new JDBCCategoryDataset(sqlconnector.dbConnector(),query1);
					JFreeChart chart1 = ChartFactory.createLineChart("Share's Price in 2001", "Month", "Price", dcd1,PlotOrientation.VERTICAL,false,true,true);
					BarRenderer r = null;
					CategoryPlot plot = null;
					r = new BarRenderer();
					ChartFrame frame1 = new ChartFrame("Query Chart",chart1);
					frame1.setVisible(true);
					frame1.setSize(350, 300);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnShare.setBackground(Color.MAGENTA);
		btnShare.setForeground(Color.BLUE);
		btnShare.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnShare.setBounds(189, 276, 89, 23);
		contentPane.add(btnShare);

	}

}
