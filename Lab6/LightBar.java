

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import java.util.*;


class Blackwhite extends JFrame

{  
	Color [] rainbow ={ Color.red, Color.green};
	
	public Blackwhite(){  
		getContentPane().setBackground(Color.black);  
		
	}
	
	/*
	public String makeFrame() {
		
		block1 = new JLabel(, SwingConstants.CENTER);
	}
	*/

	public void flash()
	{  
			
			int counter = 0; 
			int progressCounter = 0; 
			
			Scanner scan = new Scanner(System.in); 
			System.out.println("Hit enter to add progress");
			
			
			
			
			while(progressCounter <=9 ) {
				
	
				scan.nextLine(); 
					getContentPane().setBackground(rainbow[counter]);
					counter++; 
					progressCounter++; 
					System.out.println("Progress is at " + progressCounter + "0%");
					counter = counter % rainbow.length; }
		
			
		System.out.println("\nComplete");
			
		}
	}


class LightBar
{  
	public static void main(String [] args)
	{  
		Blackwhite b;
		b = new Blackwhite();
		b.setSize(200,220);
		b.setTitle("Black and white");
		b.setVisible(true);
	
		
	
		b.addWindowListener
		
		
		(new WindowAdapter()
		{  
			public void windowClosing(WindowEvent e)
			{  System.exit(0); }
		});
		b.flash();
	}
}
