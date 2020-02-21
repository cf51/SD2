package lab2.zuul;
import java.util.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom; 
	private Room prevRoom; //Creating new field to store the previous room 
	private Player player1; //Creating new field to store the player 
	
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {        
        Room startRoom = createRooms();      
        currentRoom = startRoom;
       
        parser = new Parser();
        
        Room lastRoom = createRooms(); //Creating the last room as a new room 
        prevRoom = lastRoom; 		   //Setting the previous room eqaual to the last room variable 
        
        player1 = new Player (" "); 	//Creating a new player with no name
        								//the name will be set by the scanner in play() method 
    }

    /**
     * Create all the rooms and link their exits together.
     * 
     * @return Returns the starting room
     */
    
    private Room createRooms()
    {
        Room outside, theatre, pub, lab, office; 
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // put items in the room
        pub.addItem(new Item("beer", 0.5));
        pub.addItem(new Item("wine", 0.75));
        lab.addItem(new Item("computer", 30));
        
        // initialise room exits
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        return outside;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    
    public void play() 
    {            
       
        String name ; 										//Creating string to store players name 
        Scanner scan = new Scanner(System.in); 				//initalizing a new scanner 
        System.out.println("Please enter your name");		//asking player for their name 
        name = scan.nextLine();								//scanning input and storing it to variable name
        
        
        
        player1.setName(name); 		//Setting the players name 
        
        printWelcome(); 			//Printing the welcome message once they have entered their name 
        
        System.out.println("Welcome " + player1.getName() + ", where would you like to go?"); //Welcoming the user 
        

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println("Type 'back' if you want to go back");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println();
        System.out.println("User Name: " + player1.getName());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit")) 
            wantToQuit = quit(command);
        else if (commandWord.equals("back")) //if the players command is 'back' it calls the method goBack 
            goBack(command);
           return wantToQuit;
    
}

    protected void goBack(Command command) {
    
    	if(command.hasSecondWord()) {					//If there is more than one word the usr is asked again 
    		System.out.println("Go back to where");
    		return; 
    	}
    
    	if (prevRoom == null) {											    //If there is no previous room the user is told 
    		System.out.println("You haven't got anywhere to go back to");   //they can't go back
    	}
    	
    	else { 
    		entRoom(prevRoom);					//The user enters the previous room (they go back) 
    	}
    	
}
    
    private void entRoom(Room nextRoom) {
    	prevRoom = currentRoom;		//Setting the previous room equal to the current room 
    	currentRoom = nextRoom;
    	player1.setRoom(currentRoom);	//Setting the current room equal to the next room 
    									//Allows player to go back a room 
    	
    	System.out.println(currentRoom.getLongDescription() + "\nUser Name: " + player1.getName());	//Printing the players room 
    	}
 
    
    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
   
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    
    protected void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
       
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
        	entRoom(nextRoom);
   
        }
    }
    

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else
            return true;  // signal that we want to quit
    }
    
 

	public Room getCurrentRoom()
	{
		return this.currentRoom;
	}
	
	 public static void main( String[] args )
	   	{
	   		Game game = new Game();
	   		game.play();
	   		
	   	}
}
