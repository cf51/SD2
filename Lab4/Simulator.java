package Lab4.FoxesAndRabbits2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A simple predator-prey simulator, based on a rectangular field
 * containing rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;
    
    
    

    // List of animals in the field.
    //protected List<Animal> animals;
    // The current state of the field.
    protected Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    
    private PopulationGenerator populate; 
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    
    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
       
        // Create a view of the state of each location in the field.
        field = new Field(depth, width);
        view = new SimulatorView(depth, width);
        populate = new PopulationGenerator(field, view);
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for a reasonably long period,
     * (4000 steps).
     */
    public void runLongSimulation()
    {
        simulate(4000);
    }
    
    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
        }
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     * fox and rabbit.
     */
    public void simulateOneStep()
    {
        step++;

        // Provide space for newborn animals.
        List<Animal> newAnimals = new ArrayList<Animal>();   
        
        List<Predator> newPredator = new ArrayList<Predator>();  
        // Let all rabbits act.
        for(Iterator<Animal> it = populate.getAnimalList().iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            animal.act(newAnimals);
            if(! animal.isAlive()) {
                it.remove();
            }
        }
            
            for(Iterator<Predator> it = populate.getPredatorList().iterator(); it.hasNext(); ) {
                Predator predator = it.next();
                predator.hunt(newPredator);
                if(! predator.isAlive()) {
                    it.remove();
                }
        }
               
        // Add the newly born foxes, rabbits and wolves to the main lists.
        populate.getAnimalList().addAll(newAnimals);
        
        populate.getPredatorList().addAll(newPredator);

        view.showStatus(step, field);
    }
        
    /**
     * Reset the simulation to a starting position.
     */
    
    public void reset()
    {
        step = 0;
        populate.getAnimalList().clear();
        populate.getPredatorList().clear();
        populate.Populate(); 
        
        // Show the starting state in the view.
        view.showStatus(step, field);
    }
    
    public PopulationGenerator getGenerator() {
    	return this.populate;
    }
    
    /**
     * Randomly populate the field with foxes, rabbits and wolves.
     */
    
    /*
   private void Populate() {
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    animals.add(fox);
                }
                
               else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    animals.add(rabbit);
                }
                
                else if(rand.nextDouble() <= WOLVE_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Wolve wolve = new Wolve(true, field, location);
                    animals.add(wolve);
                }
            }

        }
        */ 
    }
   
  


