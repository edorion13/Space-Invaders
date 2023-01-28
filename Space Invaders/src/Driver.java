import java.awt.*;

import javax.swing.*;
public class Driver {
	public static void main (String[]args) {
		Dimension size = new Dimension(1450,750);
		JFrame frame = new JFrame(); 						
		GraphicsPanel panel = new GraphicsPanel(size);

		frame.getContentPane().add(panel); 						
		frame.pack(); 											
		frame.setResizable(false); 								
		frame.setVisible(true); 								
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		//animation loop
		while(true) 
		{
			try 
			{
				Thread.sleep(1000/200); 
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
			panel.refresh();
		}
	}
}