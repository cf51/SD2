package Lab5.Window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class White extends JFrame
{ 
	public White(Color backgroundColor)
	{  
		getContentPane().setBackground(backgroundColor); 

		
		

	}
	
}

class TestWhite{
	
	public static void main(String [] args){  
		
		White g;
		g = new White(Color.green);
		g.setSize(250,250);
		g.setTitle("Green");
		g.setVisible(true);
		
		White b;
		b = new White(Color.blue);
		b.setSize(350,100);
		b.setTitle("Blue");
		b.setVisible(true);
		
		White r; 
		r = new White(Color.red); 
		r.setSize(200,450);
		r.setTitle("Red");
		r.setVisible(true);
		
		
		g.addWindowListener(new WindowAdapter()

	
		
		
				{ 
	public void windowClosing(WindowEvent e){
		
		System.exit(0); 
		
			}
		});
	}
}


