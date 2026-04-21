/**
 * The Mp3 Class represents a Mp3 in the Gadget Shop,
 * It extends the superclass Gadget, and stores information about the 
 * memory defined for the Mp3.
 * And has additional methods to check the memory, uploadMusc and deleteMusic.
 *
 * @author Raul Barros
 * @version 1.0 2026
 */

public class Mp3 extends Gadget {
    private int memory;
    /*
     * Constructor that calls the parent Gadget Constructor
     * and additionally stores the memory value for mp3.
    */
    public Mp3(
    String model,
    float price,
    int weight,
    String size,
    int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }
    
    /*
     Returns the current available memory of the Mp3 device as an integer.
     */
    public int getMemory() {
        return this.memory;
    }

    /*
     Validates that the mp3File size is a positive Int,
     and if the device have enough memory.
     If so, decrements the memory by the size of the mp3File,
     Otherwise returns an error message.
     */
    public String uploadMusic(int mp3File) {
        if(this.memory >= mp3File && mp3File > 0) { 
            this.memory -= mp3File;     
            return "Success! Your MP3 has been uploaded.Available memory:" + memory;
        } else {
            return "Upload failed: Not enough memory to process the MP3 file.";
        }
    }
    
      /*
       Validates that the mp3File size is a positive Int,
       then increments the memory by the mp3File size
       and returns a success message with updated memory.
       Otherwise returns an error message.
     */
    public String deleteMusic(int mp3File) {
        if(mp3File > 0) { 
            this.memory += mp3File;
            return "Success! Your MP3 has been deleted. Available memory:" + memory;
        } else {
            return "Delete failed: please enter a valid MP3 file size.";
        }
    }
    
    /* 
     *Returns a formatted String representation
     *of the Mobile showing the model
    */
    @Override 
    public String toString() { 
        return "Mp3{model='" + getModel() + "' | memory='"+memory+"'}";
    }
    
    /* 
     * Returns a formatted String containing 
     * all the information of the Mp3, including the memory.
    */
    @Override public String display() { 
        return "Mp3" + System.lineSeparator() +
        super.display() +
        "Memory = " + memory;
    }
}