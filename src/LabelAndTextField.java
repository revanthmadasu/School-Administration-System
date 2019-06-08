import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabelAndTextField extends JPanel
{
	JLabel l;
	JTextField t;
	LabelAndTextField(String l1,int size)
	{
		l=new JLabel(l1);
		this.add(l);
		t=new JTextField(size);
		this.add(t);
	}
}