import javax.swing.*;
public class LabelTextboxButton extends JPanel {
	JLabel l;
	JTextField t;
	JButton b;
	LabelTextboxButton(String label,int size,String buttonName,String title)
	{
		l=new JLabel(label);
		t=new JTextField(size);
		b=new JButton(buttonName);
		this.add(l);
		this.add(t);
		this.add(b);
		this.setBorder(BorderFactory.createTitledBorder(title));
	}
}
