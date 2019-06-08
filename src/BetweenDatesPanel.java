import javax.swing.*;
public class BetweenDatesPanel extends JPanel {
	JLabel l;
	JTextField t1,t2;
	JButton b;
	BetweenDatesPanel(String label,String buttonName,String title)
	{
		l=new JLabel(label);
		t1=new JTextField(4);
		t2=new JTextField(4);
		b=new JButton(buttonName);
		this.add(l);
		this.add(t1);
		this.add(t2);
		this.add(b);
		this.setBorder(BorderFactory.createTitledBorder(title));
	}
}
