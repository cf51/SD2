package Lab4.FoxesAndRabbits2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulationGenerator extends Simulator {
	
	// The probability that a fox will be created in any given grid position.
    protected static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    protected static final double RABBIT_CREATION_PROBABILITY = 0.08;    
    // The probability that a rabbit will be created in any given grid position.
    protected static final double WOLVE_CREATION_PROBABILITY = 0.05; 
    
    private Field field;
    
    private SimulatorView view;
    
    private List<Predator> predator;
    
    private List<Animal> animals; 
	
	public PopulationGenerator(Field fi, SimulatorView vi) {
		
		this.field = fi; 
		
		this.view = vi;
		
		animals = new ArrayList<>();	
		
		predator = new ArrayList<>(); 
		
		setColor();
	}
	
	public List<Predator> getPredatorList(){
		return this.predator;
	}
	
	public List<Animal> getAnimalList(){
		return this.animals;
	}
	
	public void Populate() 
	    {
	        Random rand = Randomizer.getRandom();
	        field.clear();
	        for(int row = 0; row < field.getDepth(); row++) {
	            for(int col = 0; col < field.getWidth(); col++) {
	                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
	                    Location location = new Location(row, col);
	                    Fox fox = new Fox(true, field, location);
	                    predator.add(fox);
	                }
	                
	                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
	                    Location location = new Location(row, col);
	                    Rabbit rabbit = new Rabbit(true, field, location);
	                    animals.add(rabbit);
	                }
	                
	                else if(rand.nextDouble() <= WOLVE_CREATION_PROBABILITY) {
	                    Location location = new Location(row, col);
	                    Wolve wolve = new Wolve(true, field, location);
	                    predator.add(wolve);
	                }
	            }

	        }
	    }
	private void setColor() {
		view.setColor(Rabbit.class, Color.ORANGE);
        view.setColor(Fox.class, Color.BLUE);
        view.setColor(Wolve.class, Color.GREEN);
	}
}
