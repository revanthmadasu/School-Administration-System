import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Query6Panel extends JPanel {
	JLabel l,or;
	JTextField t;
	LabelAndTextField fName,lName,fatherName;
	JButton b1,b2;
	Query6Panel(String label,int size,String buttonName,String title)
	{
		l=new JLabel(label);
		t=new JTextField(size);
		b1=new JButton(buttonName);
		this.add(l);
		this.add(t);
		this.add(b1);
		or=new JLabel("or");
		fName=new LabelAndTextField("First Name:",13);
		lName=new LabelAndTextField("Last Name:",13);
		fatherName=new LabelAndTextField("Father Name:",13);
		b2=new JButton("Display");
		this.add(or);
		this.add(fName);
		this.add(lName);
		this.add(fatherName);
	    this.add(b2);
		this.setBorder(BorderFactory.createTitledBorder(title));
	}
}
