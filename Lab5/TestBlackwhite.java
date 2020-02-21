package Lab5.Window;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import java.util.*;

class Blackwhite extends JFrame

{  
	Color [] rainbow ={ Color.red, Color.orange, Color.yellow,Color.green, Color.blue, Color.magenta};
	
	public Blackwhite(){  
		getContentPane().setBackground(Color.black);  
		
	}

	private void pause(long millisecs)
	{  
		long startTime = Calendar.getInstance().getTimeInMillis();
		while(Calendar.getInstance().getTimeInMillis()-startTime<millisecs);
	}

	public void flash()
	{  
			
			int counter = 0; 
			
			Scanner scan = new Scanner(System.in); 
			System.out.println("Hit enter to change the color");
			
			while(true) {
				
	
				scan.nextLine(); 
					getContentPane().setBackground(rainbow[counter]);
					counter++; 
					counter = counter % rainbow.length; }
				
			
			/*
			 * 
			pause(1000); 
			getContentPane().setBackground(rainbow[0]);
			pause(500);
			getContentPane().setBackground(rainbow[1]);
			pause(500);
			getContentPane().setBackgrou
			
			nd(rainbow[2]);
			pause(500);
			getContentPane().setBackground(rainbow[3]);
			pause(500);
			getContentPane().setBackground(rainbow[4]);
			pause(500);
			getContentPane().setBackground(rainbow[5]);
			*/
			
			
		}
	}


class TestBlackwhite
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
