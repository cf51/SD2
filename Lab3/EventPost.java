package Lab3.Network;

public class EventPost extends Post{
	    
	    
	    private String eventType; //new variable for eventType 
	    
	    
	    public EventPost(String author, String text) {
	    	
	    	super(author); //calling the superclass 
	    	
	    	text = eventType; //creating new text 
	    	
	    }
	    
	    public String getEventType() {
	    	return eventType; 	//Returning the event type
	    }
}
