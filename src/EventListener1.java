import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import com.microsoft.sqlserver.jdbc.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EventListener1{
	
	DataBase1 data;
    String id,doj,firstName,lastName,fatherName,motherName,dob,gender,aadhaar,hno,street,place,city,state,pin,contactNo1,contactNo2,classJoining,presentClass,previousSchool;
    int dues;
	String sql;
	Connection con;
	Statement st;
	Basic2 b;
	EventListener1(){}
	EventListener1(Basic2 b1)
	{
		b=b1;
			try
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			Statement st=con.createStatement();
			JOptionPane.showMessageDialog(b.newStudPane, "Connected ", "Database Connection State", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(b.newStudPane, "Cannot Connect to the Database");
			JLabel error=new JLabel(e.toString());
		    JScrollPane scroll=new JScrollPane(error);
		    JFrame f =new JFrame();
		    f.setSize(500, 500);
		    f.add(scroll);
		    f.setVisible(true);
		}
	}
	void enterIntoDatabase(Basic2 b)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(id) from Student;");
			while(rs.next())
			{
			   int t =Integer.parseInt(rs.getString(1));
			   ++t;
			   id=Integer.toString(t);
			}
			doj=b.date.t.getText();
			firstName=b.firstName.t.getText();
			lastName=b.lastName.t.getText();
			fatherName=b.fatherName.t.getText();
			dob=b.dob.t.getText();
			gender=b.gender.t.getText();
			aadhaar=b.aadhaar.t.getText();
			hno=b.hno.t.getText();
			street=b.street.t.getText();
			place=b.place.t.getText();
			city=b.city.t.getText();
			state=b.state.t.getText();
			pin=b.pin.t.getText();
			contactNo1=b.contactNo1.t.getText();
			contactNo2=b.contactNo2.t.getText();
			classJoining=b.classJoining.t.getText();
			presentClass=classJoining;
			previousSchool=b.previousSchool.t.getText();
			dues=0;
			sql="insert into student(id,dateOfJoining,firstName,lastName,fathersName,MothersName,DateofBirth,gender,aadhar,hno,street,place,city,state,pin,contactNo1,contactNo2,classJoining,class,previousSchool,dues)"
					+ "values ("+"'"+id+"', '"+doj +"', '"+firstName+"', '"+lastName+"', '"+fatherName+"', '"+motherName+"', '"+dob+"', '"+gender+"', '"+aadhaar+"', '"+hno+"', '"+street+"', '"+place+"', '"+city+"', '"+state+"', '"+pin+"', '"+contactNo1+"', '"+contactNo2+"', '"+classJoining+"', '"+presentClass+"', '"+previousSchool+"', "+dues+");";
			                                      //id,doj,firstName,lastName,fatherName,motherName,dob,gender,aadhaar,hno,street,place,city,state,pin,contactNo1,contactNo2,classJoining,presentClass,previousSchool,dues;
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(b.newStudPane, "Entered Successfully");
		}catch(Exception e){
			JOptionPane.showMessageDialog(b.newStudPane,"Entry Unsuccessful");
		}
	}
	boolean isIdPresent(int id1)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			  Statement st=con.createStatement();
			  int id2=id1+1;
			  ResultSet rs=st.executeQuery("select id from Student where id = "+id1+";");
		     //(code for sqlite db ) ResultSet rs=st.executeQuery("select id from Student where id > "+id1+"<"+id2+";");
		      if(rs.next())
		      return true;
		      else return false;
		}catch(Exception e){
			System.out.println("False returned by catch block  ");
			e.printStackTrace();
		
			return false;}
	}
	
	JTable printStudentFeeHistory(int id1)
	{
		JTable feeHistory=null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			  Statement st=con.createStatement();
		      ResultSet rs=st.executeQuery("select id,firstName,lastName,administration,april,may,june,july,august,september,october,november,december,january,ferbruary,march from Student where id="+id1);
		      ResultSetMetaData metaData = rs.getMetaData();

		      // names of columns
		      Vector<String> columnNames = new Vector<String>();
		      int columnCount = 16;
		     /* for (int column = 1; column <= columnCount; column++) {
		          columnNames.add(metaData.getColumnName(column));
		      }*///this modified to below
		      {
		    	  columnNames.add("id");
		    	  columnNames.add("firstName");
		    	  columnNames.add("lastName");columnNames.add("administration");columnNames.add("april");columnNames.add("may");columnNames.add("june");columnNames.add("july");columnNames.add("august");columnNames.add("september");columnNames.add("october");columnNames.add("november");
		    	  columnNames.add("december");columnNames.add("January");columnNames.add("February");columnNames.add("March");
		      }

		      // data of the table
		      Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		      while (rs.next()) {
		          Vector<Object> vector = new Vector<Object>();
		          for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		              vector.add(rs.getObject(columnIndex));
		          }
		          data.add(vector);
		      }

		      feeHistory=new JTable(new DefaultTableModel(data, columnNames));
		      JScrollPane scroll=new JScrollPane(feeHistory);
		}catch(Exception e){e.printStackTrace();}
		finally{
			return feeHistory;
		}
	}
    ArrayList<String> selectDueFee(int id)//used by pay fee panel
    {
    	ArrayList<String> dues = new ArrayList<String>();
    	try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			  Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select administration from Student where id="+id+" and administration is not null");
    	if(!rs.next())
    	{
    		dues.add("administration");
    	}
    	rs=st.executeQuery("select april from Student where id="+id+" and april is not null");
    	if(!rs.next())
    	{
    		dues.add("april");
    	}
    	rs=st.executeQuery("select may from Student where id="+id+" and may is not null");
    	if(!rs.next())
    	{
    		dues.add("may");
    	}
    	rs=st.executeQuery("select june from Student where id="+id+" and june is not null");
    	if(!rs.next())
    	{
    		dues.add("june");
    	}
    	rs=st.executeQuery("select july from Student where id="+id+" and july is not null");
    	if(!rs.next())
    	{
    		dues.add("july");
    	}
    	rs=st.executeQuery("select august from Student where id="+id+" and august is not null");
    	if(!rs.next())
    	{
    		dues.add("august");
    	}
    	rs=st.executeQuery("select september from Student where id="+id+" and september is not null");
    	if(!rs.next())
    	{
    		dues.add("september");
    	}
    	rs=st.executeQuery("select october from Student where id="+id+" and october is not null");
    	if(!rs.next())
    	{
    		dues.add("october");
    	}
    	rs=st.executeQuery("select november from Student where id="+id+" and november is not null");
    	if(!rs.next())
    	{
    		dues.add("november");
    	}
    	rs=st.executeQuery("select december from Student where id="+id+" and december is not null");
    	if(!rs.next())
    	{
    		dues.add("december");
    	}
    	rs=st.executeQuery("select january from Student where id="+id+" and january is not null");
    	if(!rs.next())
    	{
    		dues.add("january");
    	}
    	rs=st.executeQuery("select ferbruary from Student where id="+id+" and ferbruary is not null");
    	if(!rs.next())
    	{
    		dues.add("ferbruary");
    	}
    	rs=st.executeQuery("select march from Student where id="+id+" and march is not null");
    	if(!rs.next())
    	{
    		dues.add("march");
    	}
    	}catch(Exception e){e.printStackTrace();
    	}
    	finally{return dues;}
    }
    
    boolean updateFee(String due,int id,String date)
    {
    	try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			  Statement st=con.createStatement();
			  st.executeUpdate("update Student set "+due +" = '"+date+"' where id = "+id);
			  return true;
    	}catch(Exception e){return false;}
    }
    
   /* JTable getStudentsNotPaid()
    {
    	JTable studentsNotPaid=null;
    	try{
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			  Statement st=con.createStatement();
    }*/
    JTable studentInfo(int id1)
    {
    	JTable  studInf=null;int t=0;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			  Statement st=con.createStatement();
		      ResultSet rs=st.executeQuery("select * from Student where id="+id1);
		      
		      ResultSetMetaData metaData = rs.getMetaData();
		      // names of columns
		      Vector<String> columnNames = new Vector<String>();
		      int columnCount = metaData.getColumnCount();
		      //for sql server
		      for (int column = 1; column <= columnCount; column++) {
		          columnNames.add(metaData.getColumnName(column));
		      }
		      //for sqllite
		      /*{
		    	  columnNames.add("id");columnNames.add("DateOfJoining");
		    	  columnNames.add("firstName");
		    	  columnNames.add("lastName");columnNames.add("FathersName");columnNames.add("MothersName");columnNames.add("DateOfBirth");columnNames.add("Aadhaar");
		    	  columnNames.add("hno");columnNames.add("Street");columnNames.add("Place");columnNames.add("City");columnNames.add();columnNames.add();columnNames.add("administration");columnNames.add("april");columnNames.add("may");columnNames.add("june");columnNames.add("july");columnNames.add("august");columnNames.add("september");columnNames.add("october");columnNames.add("november");
		    	  columnNames.add("december");columnNames.add("January");columnNames.add("February");columnNames.add("March");
		      }*/

		      // data of the table
		      Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		      while (rs.next()) {
		          Vector<Object> vector = new Vector<Object>();
		          for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		              vector.add(rs.getObject(columnIndex));
		          }
		          data.add(vector);
		      }

		      studInf=new JTable(new DefaultTableModel(data, columnNames));
		      JScrollPane scroll=new JScrollPane(studInf);
		}catch(Exception e){e.printStackTrace();}
		finally{
			return studInf;
		}
    	
    }
    int getId(String fName,String lName,String fatherName)
    {
    	int id=0;
    	try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Student;integratedSecurity=true;");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select id from Student where firstName = '"+fName+"' and lastName = '"+lName+"' and fathersName = '"+fatherName+"';");
			while(rs.next())
			id=rs.getInt(1);
		}catch(Exception e){e.printStackTrace();}
    	finally{ return id;}
    }
}
