
/**
 * Represents the table of flights in a day
 *
 * @author (Lauren Dermer)
 * @version (13.12.2017)
 */
public class Airport
{ 

    /**
     * Represantation of an array that saves the list of flights
     */

    // Variables declaration

    private final int MAX_FLIGHTS=200; // FINAL - Max flights a day

    private Flight[] _flightSchedule; // Array of flights
    private int _noOfFlights; // Flights no. in table of flights (in array)
    private String _airport; // City name (of the airport)

    /**
     * Constructor that gets the city name of airport location
     * and initializes variables so the array of flights will be max
     * @param Airport Gets the city name of the airport
     */

    public Airport(String airport)
    {  
        // Initialize variables + get city of airport

        _airport = new String (airport); // City name
        _flightSchedule = new Flight[MAX_FLIGHTS]; // Initialize array
        _noOfFlights=0; // Initialize no. of flights to 0
    }

    /**
     * Gets Flight as a paramater.
     * Must - _departure or _destination must be _airport (City name of airport)
     * @return Returns true if was able to add flight with no issue
     * @return Returns false if was not able
     */

    public boolean addFlight(Flight flight) // Adds a flight to table of flights
    {

        if (!(flight.getDeparture().equals(_airport) || flight.getDestination().equals(_airport)))
            return false;

        return true; //flight;

    }

    // Getters

    public int getNoOfFlights()
    {
        return _noOfFlights;
    }

    // Setters

    public void setNoOfFlights()
    {
        _noOfFlights=_noOfFlights;
    }

}