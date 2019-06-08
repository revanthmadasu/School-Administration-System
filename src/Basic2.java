import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Basic2 implements ActionListener {

	EventListener1 events;
	JFrame frame1;
	JPanel newStudPane, promoteStudPane, editFeePane,editStudPane;
	PayFeePane payFeePane;
	JTabbedPane tabs;
	LabelAndTextField date,firstName,lastName,fatherName,motherName,dob,gender,aadhaar,hno,street,place,city,state,pin,contactNo1,contactNo2,classJoining,previousSchool;
	JButton submit;
	QueriesPanel queries;
	Basic2()
	{
		frame1=new JFrame("Rahul Convent School");
		frame1.setSize(700,700);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		newStudPane = new JPanel();
		newStudPane.setLayout(new FlowLayout(FlowLayout.LEADING)); 
	    date=new LabelAndTextField("Date(YYYY/MM/DD)",6);  
		firstName=new LabelAndTextField("First Name",10);
		lastName=new LabelAndTextField("Last Name",10);
		fatherName=new LabelAndTextField("Father's Name",10);
		motherName=new LabelAndTextField("Mother's Name",10);
		dob=new LabelAndTextField("Date of Birth",6);
		gender=new LabelAndTextField("Gender",5);
		aadhaar=new LabelAndTextField("Aadhaar",10);
		hno=new LabelAndTextField("HouseNo:",10);
		street=new LabelAndTextField("Street:",10);
		place=new LabelAndTextField("Place:",10);
		city=new LabelAndTextField("City:",10);
		state=new LabelAndTextField("State:",5);
		pin=new LabelAndTextField("Pin:",10);
		contactNo1=new LabelAndTextField("Contact No1",9);
		contactNo2=new LabelAndTextField("Contact No2",9);
		classJoining=new LabelAndTextField("Class Joining",3);
		previousSchool=new LabelAndTextField("Previous School",10);
		newStudPane.add(date);
		newStudPane.add(firstName);
		newStudPane.add(lastName);
		newStudPane.add(fatherName);
		newStudPane.add(motherName);
		newStudPane.add(dob);
		newStudPane.add(gender);
		newStudPane.add(aadhaar);
		newStudPane.add(hno);
		newStudPane.add(street);
		newStudPane.add(place);
		newStudPane.add(city);
		newStudPane.add(state);
		newStudPane.add(pin);
		newStudPane.add(contactNo1);
		newStudPane.add(contactNo2);
		newStudPane.add(classJoining);
		newStudPane.add(previousSchool);
		submit=new JButton("SUBMIT");
		submit.addActionListener(this);
		newStudPane.add(submit);
		
		payFeePane = new PayFeePane(this);
	    promoteStudPane = new JPanel();
		editFeePane = new JPanel();
		editStudPane = new JPanel();
		queries = new QueriesPanel(this);
		
		tabs=new JTabbedPane();
		tabs.addTab("New Student",newStudPane );
		tabs.addTab("Pay Fee",payFeePane );
		tabs.addTab("Promote Student",promoteStudPane );
		tabs.addTab("Edit Fee",editFeePane );
		tabs.addTab("Edit Student",editStudPane );
		tabs.addTab("Queries",queries );
		frame1.add(tabs);
		
		events=new EventListener1(this);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Basic2();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		events.enterIntoDatabase(this);
		
	}
}

