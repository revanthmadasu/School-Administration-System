import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import microsoft.sql.DateTimeOffset;
public class DataBase1 {
	public static void main(String args[])
	{
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select firstName from Student;");
			while(r.next())
			{
				System.out.println(r.getString(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
