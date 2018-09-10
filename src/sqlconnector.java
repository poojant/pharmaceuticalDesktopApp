import java.sql.*;
import javax.swing.*;
public class sqlconnector {
	
	Connection conn = null;
	public static Connection dbConnector()
	{
		String url = "jdbc:mysql://localhost:3306/company";
		String userName = "root";
		String password = "12345";
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url,userName,password);
			JOptionPane.showMessageDialog(null,"Connection Successful");
			return conn;
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
