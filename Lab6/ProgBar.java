import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProgBar extends JFrame
{
	private JFrame frame;
	private int counter;
	private JLabel percent;
	JLabel[] bar = new JLabel[10]; 

    
    
    
    public ProgBar() {
    	
    	setLayout(new GridLayout(11,1));
    	 
    	 counter = 0;
    	 
    	 for (int i=0; i<bar.length; i++){
    		 
    		 bar[i] = new JLabel();
    		 bar[i].setBackground(Color.red);
    		 bar[i].setOpaque(true);
    		 add(bar[i]); 
    	 }
    	 
    	 percent = new JLabel(Integer.toString(counter) + "%", JLabel.CENTER);
    	 add(percent); 
    	 
    }
    	 public void update(){
    		 
    		 counter++;
    		 
    		 if(counter <= bar.length) {
    			 percent.setText(Integer.toString(counter) + "0%");
    			 bar[counter -1].setBackground(Color.GREEN); 
    		 }
    	 }
    	 
     
         
;
    
    
    public static void main (String[] args) {
 	   
 	   ProgBar p = new ProgBar(); 
 	   p.setSize(400,400);
 	   p.setTitle("ProgBar");
 	   p.setVisible(true);
 	  
 	   Scanner scan = new Scanner(System.in);
 	   
 	   while(true) {
 		   scan.nextLine();
 		   p.update();
 	   }
 	   
}
    
}