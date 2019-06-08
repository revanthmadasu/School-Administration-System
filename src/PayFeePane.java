import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class PayFeePane extends JPanel implements ActionListener{
	JFrame frame;
	JButton submit,pay;
	Basic2 b;
	JTable feeHistory;
	JScrollPane feeHistorySP;
	LabelAndTextField id;
	ArrayList<String> duesList;
	JCheckBox duesCheck[];
	int id1;
	PayFeePane(Basic2 b)
	{
		this.b=b;
		id=new LabelAndTextField("Id",4);
		submit=new JButton("Submit");
		this.add(id);
		this.add(submit);
        submit.setActionCommand("Submit id");
        submit.addActionListener(this);
    
	}
	
	public void actionPerformed(ActionEvent e)
	{
		id1=Integer.parseInt(id.t.getText());
		if(b.events.isIdPresent(id1))
		{
			frame=new JFrame("Fee History");
			frame.setSize(1200, 600);
			frame.setLayout(new FlowLayout());
		    feeHistory=b.events.printStudentFeeHistory(id1);
		    feeHistory.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    feeHistory.setSize(1200,75);
		    feeHistorySP=new JScrollPane(feeHistory);
		    Dimension d = new Dimension();
		    d.setSize(1200, 150);
		    feeHistorySP.setPreferredSize(d);
		    frame.add(feeHistorySP);
	        pay=new JButton("Pay");
	        pay.addActionListener(new FeeHistoryEvent());
	        frame.add(pay);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    duesList=b.events.selectDueFee(id1);
		    int i=0;
		    duesCheck=new JCheckBox[duesList.size()];
		    while(i<duesList.size())
		    {
		    	duesCheck[i]=new JCheckBox(duesList.get(i));
			    frame.add(duesCheck[i]);
			    ++i;
		    }
		    frame.revalidate();
		    frame.repaint();
		}
		else {
			System.out.println("Invalid id - id = "+id1);
			//JOptionPane.showMessageDialog(b.payFeePane, "Invalid id", "Invalid Id", JOptionPane.ERROR_MESSAGE); 
		}
	}
    class FeeHistoryEvent implements ActionListener
    {

    	public void actionPerformed(ActionEvent e)
    	{
    		LocalDate date=LocalDate.now();
            String date1 =DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);

    		String s="";
    		for(int i=0;i<duesList.size();++i)
    			if(duesCheck[i].isSelected())
    			{
    				if(b.events.updateFee(duesCheck[i].getText(), id1, date1))
    					s+=duesCheck[i].getText();   s+=" , ";
    			}
			JOptionPane.showMessageDialog(frame, s, "Fees Paid for", JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
    	}
    }
}
