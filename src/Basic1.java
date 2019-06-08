import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Basic1 {
	public static void main(String args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Basic1();
			}
		});
	}
	Basic1()
	{
		JFrame frame1=new JFrame("NEW FRAME");
		frame1.setSize(275, 100);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
	}

}
