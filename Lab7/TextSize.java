	import java.awt.BorderLayout;
	 
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

public class TextSize extends JFrame implements ActionListener {

	static final String LETTER_X = "X"; 
	private JFrame frame;
	private JLabel X;
	private JLabel fontSize;
	private JButton b1; 
	private JButton b2; 
	
	private JPanel top;
	private JPanel bottom;
	private JPanel main;
	
	
	
	
	/**
	 * Constructor for objects of class Clock
	 */
	
	public TextSize(){
	}
	
	private void makeFrame(){
		
		
		//creating new frame 
	    frame = new JFrame("Font Size");
	    
	    //sets size of the frame and closes application on exit 
	    frame.setSize(400, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //sets the inital size and font of letter X
	    X = new JLabel("X");
	    X.setFont(new Font("Serif", Font.BOLD, 18));
	  
	
	    //setting the inital size and text of the number 
	    fontSize = new JLabel(" ");
	    fontSize.setText(String.valueOf(X.getFont().getSize()));
	
	    //initializing the top panel 
	    top = new JPanel ();
	    top.add(X, BorderLayout.WEST); //setting 'X' it to the left 
	    top.add(fontSize, BorderLayout.EAST); //setting 'fontSize' to the right
	   
	    //Creating the new buttons 
	    JButton b1 = new JButton("Increase");          
	    JButton b2 = new JButton("Decrease");                       
	  
	    //action listner to listen for an button clicks 
	    b1.addActionListener(this); 
	    b2.addActionListener(this); 
	    
	    //putting the buttons on the bottom panel 
	    bottom = new JPanel ();
	    bottom.add(b1, BorderLayout.WEST); //setting 'increase' button to the left of panel 
	    bottom.add(b2, BorderLayout.EAST); //setting 'decrease' to the right of panel 
	    
	    //creates the middle panel and splits in
	    main = new JPanel(); 
	    main = (JPanel) frame.getContentPane();
	    main.add(top, BorderLayout.NORTH); //puts the top panel to the top 
	    main.add(bottom, BorderLayout.SOUTH); //puts the bottom panel to the bottom 
	    
	    //builds the frame 
	    frame.pack();
	    
	    // place the frame at the center of the screen and show
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
	    frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand(); 
		
		int sizeFont = X.getFont().getSize(); 
		
		int sizeLabel = Integer.parseInt(fontSize.getText()); 
		
		if(s.equals("Decrease")) {
			
			if (sizeLabel > 0) {
	    		sizeLabel--; 
	    		X.setFont(new Font("Serif", Font.BOLD, sizeLabel ));
	    		sizeFont--; 
	    		fontSize.setText(String.valueOf(sizeFont));
			}
			else if (sizeLabel == 0) {
				sizeLabel = 0; 
	    		X.setFont(new Font("Serif", Font.BOLD, sizeLabel ));
	    		sizeFont = 0; 
	    		fontSize.setText(String.valueOf(sizeFont));
			}
		}
		
		else if (s.equals("Increase")) {
			
			sizeLabel++;
			X.setFont(new Font("Serif", Font.BOLD, sizeLabel));
			sizeFont++;
			fontSize.setText(String.valueOf(sizeFont));
		}
	}
	  
	
	public static void main (String[] args) {
	   
	   TextSize box = new TextSize(); 
	  
	   box.makeFrame();
	
	   }
	   
	
	}

/*
public abstract class TextSize extends JFrame implements ActionListener 
{
    private JFrame frame;
    private JLabel X;
    private JLabel fontSize;
    
    
    
    
    public TextSize()
    {
      //  makeFrame();
      
    }
    
    public void decrease(ActionEvent e) {
     
 
    	int fontsize = 30; 
    	
    	if("Decrease".equals(e.getActionCommand())) {
    		
    		fontsize = fontsize - 5; 
    	
    	}
    	
    	X.setFont(new Font("Serif", Font.BOLD, fontsize ));
		fontSize.setFont(new Font("Serif", Font.BOLD, fontsize ));
		fontSize.setText(""+ fontsize);
	
    }
    
    public void increase(ActionEvent e) {
        
    	if("Increase".equals(e.getActionCommand())) {
    		X.setFont(new Font("Serif", Font.BOLD, 75));
    		fontSize.setFont(new Font("Serif", Font.BOLD, 75));
    		fontSize.setText("75");
    	}
    }
    
    
    
    private void makeFrame()
    {
        frame = new JFrame("Font Size");
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        
        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(12, 12));
        
        // Create the image pane in the center
        X = new JLabel("X", SwingConstants.CENTER);
        X.setFont(new Font("Serif", Font.BOLD, 50));
        Font displayFont = X.getFont().deriveFont(96.0f);
        X.setFont(displayFont);
       
        fontSize = new JLabel("50", SwingConstants.CENTER);
        fontSize.setFont(new Font("Serif", Font.BOLD, 50));
        Font displayFont1 = fontSize.getFont().deriveFont(96.0f);
        fontSize.setFont(displayFont1);
       
        
        //Sets the positon of the panels within the frame 
        contentPane.add(X, BorderLayout.WEST);
        contentPane.add(fontSize, BorderLayout.EAST);

        // Create the toolbar with the buttons
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1, 0));
        
        //Set  up plus button
        JButton b1 = new JButton("Increase");
        b1.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { increase(e); }
                           });
        toolbar.add(b1);
        
        //Set up minus button 
        JButton b2 = new JButton("Decrease");
        b2.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { decrease(e); }
                           });
        toolbar.add(b2);

        
        
        // Add toolbar into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(toolbar);
        
        contentPane.add(flow, BorderLayout.SOUTH);
        
        // building is done - arrange the components      
        frame.pack();
        
        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
       
    
    public JLabel getLabel() {
    	
    	return this.X;
    }
    
   
    
   public static void main (String[] args) {
	   
	   TextSize box = new TextSize(); 
	  
	   box.makeFrame();

	   }
	   

   }
*/