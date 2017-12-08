/**
 * This class represents a time-stamp in the given 24 hour format: "HH:MM".
 * 
 * @author Egor Lunin
 */

public class Time1 {

    /* -----------------------Variable declarations----------------------- */

    private int _hour; // Represents the hours part of the time-stamp. Can range from 0 to 23.
    private int _minute; // Represents the minutes part of the time-stamp. Can range from 0 to 59.

    /* -----------------------Constructors----------------------- */

    /**
     * Regular constructor.
     * 
     * @param h
     *            Hours portion of the time-stamp in a 24 hour format (range is
     *            0-23).
     * @param m
     *            Minutes portion of the time-stamp (range is 0-59).
     */
    public Time1(int h, int m) {

        // Hours range check. Hours must be 0-23, otherwise a zero will be assigned.
        if (h >= 0 && h <= 23) {
            _hour = h;
        } else {
            _hour = 0;
        }

        // Minutes range check. Minutes must be 0-59, otherwise a zero will be assigned.
        if (m >= 0 && m <= 59) {
            _minute = m;
        } else {
            _minute = 0;
        }

    }

    /**
     * Copy constructor.
     * 
     * @param t
     *            Time1 object that will be replicated.
     */
    public Time1(Time1 t) {
        _hour = t.getHour();
        _minute = t.getMinute();
    }

    /* -----------------------Getters and Setters----------------------- */

    /**
     * Hours getter.
     * 
     * @return The hours portion as integer.
     */
    public int getHour() {
        return _hour;
    }

    /**
     * Minutes getter.
     * 
     * @return The minutes portion as integer.
     */
    public int getMinute() {
        return _minute;
    }

    /**
     * Hours setter. Will only change the value of "_hour" if the given parameter
     * num is in valid range of 0-23.
     * 
     * @param num
     */
    void setHour(int num) {
        if (num >= 0 && num <= 23) {
            _hour = num;
        }
    }

    /**
     * Minutes setter. Will only change the value of "_minute" if the given
     * parameter num is in valid range of 0-59.
     * 
     * @param num
     */
    void setMinute(int num) {
        if (num >= 0 && num <= 59) {
            _minute = num;
        }
    }

    /* -----------------------Methods----------------------- */

    /**
     * To string.
     * 
     * @return A string representation of the time-stamp in the next format:
     *         "hh:mm".
     */
    public String toString() {

        // Create a temporary string
        String result = new String();

        // If the _hour has one digit start the string with a 0.
        if (_hour <= 9) {
            result = "0";
        }

        // Add the _hour to the string.
        result += _hour;

        // Add the semicolon between the hours and minutes.
        result += ":";

        // If the _minute has one digit add a 0 before.
        if (_minute <= 9) {
            result += "0";
        }

        // Add the _minute to the string.
        result += _minute;

        // Return the complete string in the format "hh:mm".
        return result;
    }

    /**
     * Minutes from midnight.
     * 
     * @return The amount of minutes from last midnight.
     */
    public int minFromMidnight() {
        return _hour * 60 + _minute;
    }

    /**
     * Equality check between Time1 objects.
     * 
     * @param other
     *            Time1 object representing the second time-stamp.
     * @return True if the Time1 objects are identical. Otherwise False.
     */
    public boolean equals(Time1 other) {
        return _hour == other.getHour() && _minute == other.getMinute();
    }

    /**
     * Checks whether the current object is set to an earlier time-stamp than the
     * object sent as the parameter.
     * 
     * @param other
     *            Time1 object representing the other time-stamp.
     * @return True if the current object is 'earlier' than the other one. Otherwise
     *         False.
     */
    public boolean before(Time1 other) {
        return this.minFromMidnight() < other.minFromMidnight();
    }

    /**
     * Checks whether the current object is set to a later time-stamp than the
     * object sent as the parameter.
     * 
     * @param other
     *            Time1 object representing the other time-stamp.
     * @return True if the current object is 'later' than the other one. Otherwise
     *         False.
     */
    public boolean after(Time1 other) {
        return other.before(this);
    }

    /**
     * The difference in minutes between the current object and the object sent as
     * the parameter. Given condition is that the current object's time-stamp is
     * 'later' than the one sent as the parameter.
     * 
     * @param other
     *            Time1 object representing the other time-stamp.
     * @return Integer number representing the minutes between the two time-stamps.
     */
    public int difference(Time1 other) {
        return this.minFromMidnight() - other.minFromMidnight();
    }

} // End of class 'Time1'.