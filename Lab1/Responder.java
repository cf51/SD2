package Lab1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the responder as a set of words, and based on those
 * words the responder will generate a String that represents the response.
 *
 * Internally, the reponder uses a HashMap to associate words with response
 * strings and a list of default responses. If any of the input words is found
 * in the HashMap, the corresponding response is returned. If none of the input
 * words is recognized, one of the default responses is randomly chosen.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2011.07.31)
 */
public class Responder
{
    // Used to map key words to responses.
    private HashMap<String, String> responseMap;
    // Default responses to use if we don't recognise a word.
    private HashMap<String, String> synonymMap; // declaring new hashmap for the synonym map 
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;
    private int usedResponse ; //Creating new variable for the response that has been previously used 

    /**
     * Construct a Responder
     */
    public Responder()
    {
        responseMap = new HashMap<String, String>();
        defaultResponses = new ArrayList<String>();
        synonymMap = new HashMap<String, String>(); //initilizing the hashMap 
        fillResponseMap();
        fillDefaultResponses();
        fillSynonymMap(); //filling the synonym map 
        randomGenerator = new Random();
        
        usedResponse = -1; //Setting the previous to -1 (to allow element 0 of index to be used)
    }

    /**
     * Generate a response from a given set of input words.
     * 
     * @param words  A set of words entered by the user
     * @return       A string that should be displayed as the response
     */
   
    public String generateResponse(HashSet<String> words)
    {
        for (String word : words) {
            String response = responseMap.get(word);
            String synonym = synonymMap.get(word); 
            if(response != null) { //if the response is not empty then response is returned 
            	return response; //Returns the responce 
            		}
            else   
            	if (synonym != null) //if the synonym isn't empty then it reads the synonym hash map 
            		return responseMap.get(synonym); //Returns the response from the synonym 
        }
            	 return pickDefaultResponse();
}
        
        // If we get here, none of the words from the input line was recognized.
        // In this case we pick one of our default responses (what we say when
        // we cannot think of anything else to say...)
       
    

    /**
     * Enter all the known keywords and their associated responses
     * into our response map.
     */
    private void fillResponseMap()
    {
        responseMap.put("crash", 
                        "Well, it never crashes on our system. It must have something\n" +
                        "to do with your system. Tell me more about your configuration.");
        responseMap.put("crashes", 
                        "Well, it never crashes on our system. It must have something\n" +
                        "to do with your system. Tell me more about your configuration.");
        responseMap.put("slow", 
                        "I think this has to do with your hardware. Upgrading your processor\n" +
                        "should solve all performance problems. Have you got a problem with\n" +
                        "our software?");
        responseMap.put("performance", 
                        "Performance was quite adequate in all our tests. Are you running\n" +
                        "any other processes in the background?");
        responseMap.put("bug", 
                        "Well, you know, all software has some bugs. But our software engineers\n" +
                        "are working very hard to fix them. Can you describe the problem a bit\n" +
                        "further?");
        responseMap.put("buggy", 
                        "Well, you know, all software has some bugs. But our software engineers\n" +
                        "are working very hard to fix them. Can you describe the problem a bit\n" +
                        "further?");
        responseMap.put("windows", 
                        "This is a known bug to do with the Windows operating system. Please\n" +
                        "report it to Microsoft. There is nothing we can do about this.");
        responseMap.put("mac", 
                        "This is a known bug to do with the Mac operating system. Please\n" +
                        "report it to Apple. There is nothing we can do about this.");
        responseMap.put("expensive", 
                        "The cost of our product is quite competitive. Have you looked around\n" +
                        "and really compared our features?");
        responseMap.put("installation", 
                        "The installation is really quite straight forward. We have tons of\n" +
                        "wizards that do all the work for you. Have you read the installation\n" +
                        "instructions?");
        responseMap.put("memory", 
                        "If you read the system requirements carefully, you will see that the\n" +
                        "specified memory requirements are 1.5 giga byte. You really should\n" +
                        "upgrade your memory. Anything else you want to know?");
        responseMap.put("linux", 
                        "We take Linux support very seriously. But there are some problems.\n" +
                        "Most have to do with incompatible glibc versions. Can you be a bit\n" +
                        "more precise?");
        responseMap.put("bluej", 
                        "Ahhh, BlueJ, yes. We tried to buy out those guys long ago, but\n" +
                        "they simply won't sell... Stubborn people they are. Nothing we can\n" +
                        "do about it, I'm afraid.");
        responseMap.put("weather", //Adding in another response for the key word 'weather' 
        				"Ahhh, the weather, it's usually cold during the winter, \n" +
                		"and warm during the summer, but in Scotland.... you never know!");
        responseMap.put("weekend", //Adding in another response for the key word 'weekend' 
        				"The weekend is fun, it gives you free time to do whatever you like, \n"
        				+ "and if you're lucky you have some extra time to work on the SD2 labs!");
        responseMap.put("hello", //Adding in another response for the key word 'hello' 
				"Hello, it's nice to meet you, what's your name?");
    }
    
    private void fillSynonymMap() {
    	
    	synonymMap.put("Crashed","crash"); //Setting synonym for specific keywords 
    	synonymMap.put("Crash's","crashes");
    	synonymMap.put("Slow's","slow");
    	synonymMap.put("Performances","Performance");
    	synonymMap.put("bugs","bug");
    	synonymMap.put("bug's","bug");
    	synonymMap.put("Buggy", "");
    	synonymMap.put("Performance","Performances");
    	synonymMap.put("Performance","Performances");
    }
   
    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillDefaultResponses()
    {
        defaultResponses.add("That sounds odd. Could you describe that problem in more detail?");
        defaultResponses.add("No other customer has ever complained about this before. \n" +
                             "What is your system configuration?");
        defaultResponses.add("That sounds interesting. Tell me more...");
        defaultResponses.add("I need a bit more information on that.");
        defaultResponses.add("Have you checked that you do not have a dll conflict?");
        defaultResponses.add("That is explained in the manual. Have you read the manual?");
        defaultResponses.add("Your description is a bit wishy-washy. Have you got an expert\n" +
                             "there with you who could describe this more precisely?");
        defaultResponses.add("That's not a bug, it's a feature!");
        defaultResponses.add("Could you elaborate on that?");
    }

    /**
     * Randomly select and return one of the default responses.
     * @return     A random default response
     */
    private String pickDefaultResponse()
    {
    	int index = 0; //Setting index to 0 

    	// Pick a random number for the index in the default response list.
        // The number will be between 0 (inclusive) and the size of the list (exclusive).
       
    	do {
            index = randomGenerator.nextInt(defaultResponses.size());  //Generating a random number from the size of the default response list 
    	}
    		while (index == usedResponse ); // while the index is equal to the used response 
       
    	usedResponse = index; // if its not equal then the usedReponse is set to the index 
           
        return defaultResponses.get(index); 
    }
}
