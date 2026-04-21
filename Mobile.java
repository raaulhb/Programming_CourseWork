/**
 * The Mobile Class represents a Mobile in the Gadget Shop,
 * It extends the superclass Gadget, and stores information about the 
 * initialCredit defined for the mobile.
 * And has additional methods to check the initialCredit, addCredit, and make calls.
 *
 * @author Raul Barros
 * @version 1.0 2026
 */

public class Mobile extends Gadget {
    private int initialCredit;
    /*
     * Constructor that calls the parent Gadget Constructor
     * and additionally stores the initialCredit value for mobiles.
    */
    public Mobile(
    String model,
    float price,
    int weight,
    String size,
    int initialCredit
    ) 
    {   /*
        We use the keyword (super) to call the constructor from the superclass Gadget, 
        and use the (this) to differ the initialCredit variable from the local variable,
        passed as parameter by the constructor.
        This is so we can provide the initialCredit value. 
        */
        super(model, price, weight, size); 
        this.initialCredit = initialCredit;
    }
    
    /*
     * Returns the current Available credit
     * of the mobile as an Integer.
    */
    public int getInitialCredit() 
    {
        return this.initialCredit;
    }
    
    /*
     * Validates that the new credit is positive then adds the value
     * to the initalCredit.
     * Otherwise, returns a message.
     */
    public String addCredit(int newCredit) 
    {   
        if (newCredit > 0 ) {
            initialCredit  = initialCredit + newCredit;
            return "Credit added. New balance is: " + initialCredit;
        } else {
            return "Please enter a positive amount.";
        }
    }
    
    /*
     * Checks that the phone number is valid and
     * if there is sufficient credit to make the call compared to the 
     * duration of the call passed as an Int.
     * If so, deduct the duration from the initialCredit.
     * Otherwise, returns a message.
     */
    public String makePhoneCall(
    int phoneNumber,
    int durationOfCall)
    {
        if (phoneNumber > 0 && initialCredit > durationOfCall)
        {
            initialCredit = initialCredit - durationOfCall;

            return  "Calling " + phoneNumber +
            " | Duration: " + durationOfCall +
            " | Remaining credit: " + initialCredit;
        } else {
            return "You have insufficient credit to make the call.";
        }
    }
    
    /* 
     *Returns a formatted String representation
     *of the Mobile showing the model
    */
    public 
    @Override String toString() { 
        return "Mobile { model=" + getModel() + "}";
    }
    
    /* 
     * Returns a formatted String containing 
     * all the information of the Mobile, 
     * including the currentCredit.
    */
    @Override public String display() { 
        return "Mobile" + System.lineSeparator() +
        super.display() +
        "Credit = " + initialCredit;
    }
}