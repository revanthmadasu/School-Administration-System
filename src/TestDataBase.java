import java.sql.*;
public class TestDataBase {
	Connection con;
	Statement st;
	ResultSet rs;
	TestDataBase()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			 st=con.createStatement();
			System.out.println("Connected to Database");
		}catch(Exception e){e.printStackTrace();}
	}
	void getData1()
	{
		try{
		rs=st.executeQuery("select id,firstName,lastName,administration,april,may,june,july,august,september,october,november,december,january,ferbruary,march from Student where id="+1);
	    while(rs.next())
	    {
	    	System.out.println(rs.getString(2));
	    }
		}catch(Exception e){e.printStackTrace();}
	}
	void getData2()
	{
		try{
		rs=st.executeQuery("select id,firstName,lastName,administration,april,may,june,july,august,september,october,november,december,january,ferbruary,march from Student where id="+1);
	    while(rs.next())
	    {
	    	System.out.println(rs.getString(3));
	    }
		}catch(Exception e){e.printStackTrace();}
	}
}
