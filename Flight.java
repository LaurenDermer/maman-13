/**
 * This class represents a flight. It contains the origin of the flight, it's
 * destination as well as the time of the departure, the duration of the flight,
 * the number of the passengers on board and the price of the flight's ticket.
 * 
 * @author Egor Lunin
 */

public class Flight {

    /* -----------------------Variable declarations----------------------- */

    private String _origin; // The city the flight leaves from.
    private String _destination; // The city the flight lands at.
    private Time1 _departure; // The time-stamp of the departure in "hh:mm" format.
    private int _flightDuration; // The duration of the flight in minutes.
    private int _noOfPassengers; // The number of passengers on the flight.
    private int _price; // The price of the flight.
    private boolean _isFull; // Indicates whether the flight is full of passengers.
    private final int MAX_CAPACITY = 250; // Maximum number of passengers on a flight.

    /* -----------------------Constructors----------------------- */

    /**
     * Regular constructor.
     * 
     * In case of negative values for flightDuration, noOfPassengers and price the
     * values will be set to 0.
     * 
     * If the noOfPassengers exceeds the MAX_CAPACITY it will be set to MAX_CAPACITY
     * 
     * @param origin
     *            The city the flight leaves from.
     * @param destination
     *            The city the flight lands at.
     * @param departureHour
     *            The hour of the departure.
     * @param departureMinute
     *            The minute of the departure.
     * @param flightDuration
     *            The duration of the flight in minutes. (Can't be negative)
     * @param noOfPassengers
     *            The number of passengers on the flight (range is 0 -
     *            MAX_CAPACITY).
     * @param price
     *            The price of the flight. (Can't be negative)
     */
    public Flight(String origin, String destination, int departureHour, int departureMinute, int flightDuration,
    int noOfPassengers, int price) {

        _origin = new String(origin);
        _destination = new String(destination);
        _departure = new Time1(departureHour, departureMinute);

        // If the duration is negative a zero will be assigned.
        if (flightDuration < 0) {
            _flightDuration = 0;
        } else {
            _flightDuration = flightDuration;
        }

        // If the number is above the MAX_CAPACITY it is set to MAX_CAPACITY.
        // If the number is negative a zero will be assigned.
        if (noOfPassengers > MAX_CAPACITY) {
            _noOfPassengers = MAX_CAPACITY;
        } else if (noOfPassengers < 0) {
            _noOfPassengers = 0;
        } else {
            _noOfPassengers = noOfPassengers;
        }

        if (_noOfPassengers == MAX_CAPACITY) {
            _isFull = true;
        }

        // If the price is negative a zero will be assigned.
        if (price < 0) {
            _price = 0;
        } else {
            _price = price;
        }

    }

    /**
     * Copy constructor.
     * 
     * @param other
     */
    public Flight(Flight other) {
        _origin = new String(other.getOrigin());
        _destination = new String(other.getDestination());
        _departure = new Time1(other.getDeparture());
        _flightDuration = other.getFlightDuration();
        _noOfPassengers = other.getNoOfPassengers();
        _price = other.getPrice();
        _isFull = other.getIsFull();
    }

    /* -----------------------Getters----------------------- */

    /**
     * Get Arrival Time
     * 
     * @return Time1 object with a time-stamp indicating the time of arrival.
     */
    public Time1 getArrivalTime() {

        // Temporary Time1 object. It is set to the departure time.
        Time1 result = new Time1(_departure);

        // Add the hours of the flight.
        result.setHour(result.getHour() + _flightDuration / 60);

        // If the minutes calculation happens to be 60 an hour will be added and the
        // minutes will be reset to zero.
        if (result.getMinute() + _flightDuration % 60 == 60) {
            result.setHour(result.getHour() + 1);
            result.setMinute(0);
        } else {
            // Otherwise simply add the minutes of the flight.
            result.setMinute(result.getMinute() + _flightDuration % 60);
        }

        // Return the calculated time of arrival.
        return result;
    }

    /**
     * Time of departure getter.
     * 
     * @return Time1 object representing the time of departure.
     */
    public Time1 getDeparture() {
        Time1 result = new Time1(_departure);
        return result;
    }

    /**
     * Destination time getter.
     * 
     * @return The destination of the flight.
     */
    public String getDestination() {
        return new String(_destination);
    }

    /**
     * Flight getter.
     * 
     * @return The flight duration in minutes.
     */
    public int getFlightDuration() {
        return _flightDuration;
    }

    /**
     * isFull getter.
     * 
     * @return True of the flight is full. False otherwise.
     */
    public boolean getIsFull() {
        return _isFull;
    }

    /**
     * Number of passengers getter.
     * 
     * @return The number of passengers on the flight.
     */
    public int getNoOfPassengers() {
        return _noOfPassengers;
    }

    /**
     * Origin getter.
     * 
     * @return The origin of the flight.
     */
    public String getOrigin() {
        return new String(_origin);
    }

    /**
     * Price getter.
     * 
     * @return The price of the flight.
     */
    public int getPrice() {
        return _price;
    }

    /* -----------------------Setters----------------------- */

    /**
     * Departure time setter.
     * 
     * @param departureTime
     *            Time1 object representing the new time of departure.
     */
    public void setDeparture(Time1 departureTime) {
        _departure = new Time1(departureTime);
    }

    /**
     * Destination setter.
     * 
     * @param dest
     *            The new flight destination.
     */
    public void setDestination(String dest) {
        _destination = new String(dest);
    }

    /**
     * Flight duration setter.
     * 
     * @param durTimeMinutes
     *            The new flight duration.
     */
    public void setFlightDuration(int durTimeMinutes) {
        if (durTimeMinutes >= 0) {
            _flightDuration = durTimeMinutes;
        }
    }

    /**
     * Number of passengers setter.
     * 
     * @param noOfPass
     *            The new number of passengers.
     */
    public void setNoOfPassengers(int noOfPass) {
        if (noOfPass >= 0 && noOfPass <= MAX_CAPACITY) {
            _noOfPassengers = noOfPass;
        }
    }

    /**
     * Origin setter.
     * 
     * @param origin
     *            The new origin of the flight.
     */
    public void setOrigin(String origin) {
        _origin = new String(origin);
    }

    /**
     * Price setter.
     * 
     * @param price
     *            The new price of the flight.
     */
    public void setPrice(int price) {
        if (price >= 0) {
            _price = price;
        }
    }

    /* -----------------------Methods----------------------- */

    /**
     * Equality check.
     * 
     * @param other
     *            Flight object to be compared with.
     * @return True if both objects are identical. False otherwise.
     */
    public boolean equals(Flight other) {
        return _origin.equals(other.getOrigin()) && _destination.equals(other.getDestination()) && _departure.equals(other.getDeparture());
    }

    /**
     * Add passengers.
     * 
     * @param num
     *            Number of passengers to be added.
     * @return True if the number wasn't negative and didn't exceed MAX_CAPACITY.
     *         False otherwise.
     */
    public boolean addPassengers(int num) {
        if (_noOfPassengers + num <= MAX_CAPACITY) {
            _noOfPassengers += num;
            if (_noOfPassengers == MAX_CAPACITY) {
                _isFull = true;
            }
            return true;
        }
        return false;
    }

    /**
     * Price check.
     * 
     * @param other
     *            Flight object to be compared with.
     * @return True if the current flight's price is lower than the other flight's
     *         price. False otherwise.
     */
    public boolean isCheaper(Flight other) {
        return _price < other.getPrice();
    }

    /**
     * Total price.
     * 
     * @return Total price of the flight (amount of passengers * ticket price).
     */
    public int totalPrice() {
        return _price * _noOfPassengers;
    }

    /**
     * Earlier landing check.
     * 
     * @param other
     *            Flight object to be compared with.
     * @return True if the current flight lands earlier than the other flight.
     */
    public boolean landsEarlier(Flight other) {
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    /**
     * To string.
     * 
     * @return The string representation of the current flight.
     */
    public String toString() {
        String result = new String();

        result = "Flight from " + _origin + " to " + _destination + " departs at " + _departure + ".";

        if (_isFull) {
            result += " Flight is full.";
        } else {
            result += " Flight is not full.";
        }

        return result;
    }
}