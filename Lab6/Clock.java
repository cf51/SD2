
import java.awt.BorderLayout;

import java.awt.Container;
import java.util.Calendar; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * A very simple GUI (graphical user interface) for the clock display.
 * In this implementation, time runs at about 3 minutes per second, so that
 * testing the display is a little quicker.
 * 
 * @author Michael Kšlling and David J. Barnes
 * @version 2011.07.31
 */
public class Clock
{
    private JFrame frame;
    private JPanel panel; 
    private JLabel AmPm; 
    private JLabel time;
    private int currentSecond;
    private int currentMinute;
    private int currentHour; 
    private Calendar calendar;
    
    private boolean clockRunning = false; 
 
    
    /**
     * Constructor for objects of class Clock
     */
    public Clock()
    {
        makeFrame();
      
    }
    
    /**
     * 
     */
    private void start()
    {
        clockRunning = true;
    }
    

    /**
     * Create the Swing frame and its content.
     */
    
    private void makeFrame()
    {
    	
    	
        frame = new JFrame("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(300,300);
        
        panel = new JPanel(); 
        
        panel = (JPanel) frame.getContentPane();
        
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        
        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(12, 12));
        
        
        // Create the image pane in the center
        time = new JLabel(currentTime(), SwingConstants.CENTER);
        Font displayFont = time.getFont().deriveFont(96.0f);
        time.setFont(displayFont);
        
        
        AmPm = new JLabel(ampm(), SwingConstants.CENTER);
        Font displayFont1 = AmPm.getFont().deriveFont(96.0f);
        AmPm.setFont(displayFont1);
        
        
        contentPane.add(time, BorderLayout.CENTER);
        contentPane.add(AmPm, BorderLayout.SOUTH);  
        
        
        // building is done - arrange the components      
        frame.pack();
        
        
        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    
    public String currentTime() {
    	
    	Calendar c = Calendar.getInstance(); 
    	
    	String currentTime = checkTime(c.get(Calendar.HOUR_OF_DAY)) + ":" + (c.get(Calendar.MINUTE)) + ":" + (c.get(Calendar.SECOND)); 
    	
    	return currentTime; 
    	
  
    }
    
    private int checkTime(int i) {
    	
    	if ( i >= 13) {
    		
    		i = (i - 12); 
    		
    	}
    	
    	return i;
    	
    }
    
    public JLabel getLabel() {
    	
    	return this.time;
    }
    
    public String ampm() {
    	
    	Calendar c = Calendar.getInstance(); 
    	
    	int AM_PM = c.getActualMaximum(Calendar.AM_PM); 
    	
    	String ampm; 
    	
    	if(AM_PM == 0) {
    		
    		ampm = "AM";
    		
    	}
    	
    	else {
    		ampm = "PM"; 
    	}
    	
    	return ampm; 
    }
    
   public static void main (String[] args) {
	   
	   Clock clock = new Clock(); 
	  
	   clock.makeFrame();
	   while(true) {
		   clock.getLabel().setText(clock.currentTime()); 
	   }
	   

   }
}
