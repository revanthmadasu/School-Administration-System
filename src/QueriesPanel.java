import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
public class QueriesPanel extends JPanel implements ActionListener{
	Basic2 b;
	JButton q1,q2,q3;
	LabelTextboxButton q4;
	Query6Panel q5;
	BetweenDatesPanel q6;
	JTable studInf;
	JScrollPane studInfSP;
	JFrame frame1,frame2,frame3,frame4,frame5,frame6;
	QueriesPanel(Basic2 b)
	{
		this.b=b;
		q1=new JButton("Students Not Paid");
		q2=new JButton("Students Paid");
		q3=new JButton("Total Dues");
		this.add(q1);
		this.add(q2);
		this.add(q3);
		q1.setActionCommand("q1");
		q2.setActionCommand("q2");
		q3.setActionCommand("q3");
		q1.addActionListener(this);
		q2.addActionListener(this);
		q3.addActionListener(this);
		q4=new LabelTextboxButton("Id",2,"Check","Check For Due");
		this.add(q4);
		q5=new Query6Panel("Id",2,"Display","Display Student Information");
		this.add(q5);
		q6=new BetweenDatesPanel("Dates:","Display","Display income school has got between different dates");
		this.add(q6);
		q4.b.setActionCommand("q4");
		q5.b1.setActionCommand("q5b1");
		q5.b2.setActionCommand("q5b2");
		q6.b.setActionCommand("q6");
		q4.b.addActionListener(this);
		q5.b1.addActionListener(this);
		q5.b2.addActionListener(this);
		q6.b.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "q1":
			break;
		case "q2":break;
		case "q3":break;
		case "q4":break;
		case "q5b1":
	    studInf=b.events.studentInfo(Integer.parseInt(q5.t.getText())); 
	    this.displayStudInfFrame();
			break;
		case "q5b2": 
			int tid=b.events.getId(this.q5.fName.t.getText(), this.q5.lName.t.getText(), this.q5.fatherName.t.getText());
			studInf=b.events.studentInfo(tid);
			this.displayStudInfFrame();
			break;
		case "q6":break;
		}
	}
    public void displayStudInfFrame()
    {
		studInf.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    studInf.setSize(1200,150);
	    studInfSP=new JScrollPane(studInf);
	    Dimension d = new Dimension();
	    d.setSize(1200, 100);
	    studInfSP.setPreferredSize(d);
	    frame5=new JFrame("Fee History");
		frame5.setSize(1200, 600);
		frame5.setLayout(new FlowLayout());
	    frame5.add(studInfSP);
	    frame5.setVisible(true);
    	
    }
}
