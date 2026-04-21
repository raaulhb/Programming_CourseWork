
/**
 * The Gadget Class represents a Gadget of any kind,
 * It stores information about the Gadgets,
 * and has the methods to access those information.
 *
 * @author Raul Barros
 * @version 1.0 2026
 */

public class Gadget {
    private final String model;
    private final float price;
    private final int weight;
    private final String size;
    /* Constructor:
     * initialise a new gadget object storing:
     * the model,
     * price,
     * weight and size
     */
    public Gadget(String model, float price,int weight, String size) { 
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }
    //Returns the model name
    public String getModel() { 
        return model;
    }
    //Returns the gadget price
    public float getPrice() { 
        return price;
    }
    //Returns the gadget weight
    public int getWeight() { 
        return weight;
    }
    //Returns the gadget size
    public String getSize() { 
        return size;
    }
    
    /* 
     *Returns a formatted String representation
     *of the gadget showing the model
    */
    @Override public String toString() {
        return "Gadget{model='" + model +"'}";
    }
    
    /* 
     * Returns a formatted String containing 
     * all the information of the Gadget
    */
    public String display() { 
        return "Model: " + getModel() + System.lineSeparator() +
        "Price: " + getPrice() + System.lineSeparator() +
        "Weight: " + getWeight() + System.lineSeparator() +
        "Size: " + getSize() + System.lineSeparator();
    }
}
