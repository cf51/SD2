package lab2.zuul;

public class Player {

	private Room currentRoom; 
	private String name; 
	
	
	public Player (String name) {
		
		this.setName(name); //Setting player name 
	}
	
	
	public void setRoom(Room room) {
		
		currentRoom = room; //Setting the current room 
	}
	
	public Room getRoom()  {
		
		if (currentRoom == null) {
			System.out.println("You've not set a room"); 
		}
		
		return currentRoom; //returning the players current room 
	}


	public String getName() {
		return name;	//returning player name 
	}


	public void setName(String name) {
		this.name = name; //Setting player name 
	}
}


