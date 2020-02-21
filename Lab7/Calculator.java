import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
public class Calculator extends JFrame implements ActionListener
{
	private JFrame frame;

	private JTextField textField;
	private JLabel value;
	private float val2; 
	private float val1; 
	private float answer; 
	private String op; 
	/**
	 * Constructor for objects of class Clock
	 */
	public Calculator()    
	{
		makeFrame();

	}




	private void makeFrame()
	{
		frame = new JFrame("Calculator");
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// Specify the layout manager with nice spacing
		contentPane.setLayout(new BorderLayout(12, 12));

		// Create the image pane in the center
		textField = new JTextField("", SwingConstants.NORTH);
		Font displayFont = textField.getFont().deriveFont(96.0f);
		textField.setFont(displayFont);

		value = new JLabel("0", SwingConstants.CENTER);
		Font displayFont1 = value.getFont().deriveFont(96.0f);
		value.setFont(displayFont1);

		frame.add(textField);
		frame.setVisible(true);
		contentPane.add(value, BorderLayout.NORTH);

		// Create the toolbar with the buttons
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new GridLayout(1, 0));

		//Set  up plus button
		JButton plusB = new JButton("+");
		JButton minusB = new JButton("-");
		JButton divideB = new JButton("/");
		JButton multiplyB = new JButton("*");
		JButton clearB = new JButton("CRL");
		JButton equalsB = new JButton("="); 

		plusB.addActionListener(this);
		minusB.addActionListener(this);  
		divideB.addActionListener(this);
		multiplyB.addActionListener(this); 
		clearB.addActionListener(this);
		equalsB.addActionListener(this);


		toolbar.add(clearB);
		toolbar.add(plusB);
		toolbar.add(minusB);
		toolbar.add(divideB);
		toolbar.add(multiplyB);
		toolbar.add(equalsB);

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

	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand(); 



		if(s.equals("CRL")) {

			value.setText("0");
			textField.setText("");
		}

		if (s.equals("+") ||s.equals("-") || s.equals("*") || s.equals("/")) {

			val1 = Float.parseFloat(textField.getText()); 
			textField.setText("");
			value.setText(Float.toString(val1));
			op = s; 

		}
		else if(s.equals("=")){

			if (op.equals ("+")) {
				val2 = Float.parseFloat(textField.getText()); 
				answer = val2 + val1; 
				value.setText(Float.toString(answer));
				textField.setText("");
			}

			if (op.equals ("-")) {
				val2 = Float.parseFloat(textField.getText()); 
				answer = val1 - val2; 
				value.setText(Float.toString(answer));
				textField.setText("");
			}

			if (op.equals ("*")) {
				val2 = Float.parseFloat(textField.getText()); 
				answer = val2 * val1; 
				value.setText(Float.toString(answer));
				textField.setText("");
			}

			if (op.equals ("/")) {
				val2 = Float.parseFloat(textField.getText()); 
				answer = val1 / val2; 
				value.setText(Float.toString(answer));
				textField.setText("");
			}








		}






	}













	public static void main (String[] args) {

		Calculator c = new Calculator(); 

		c.makeFrame();

	}


}
