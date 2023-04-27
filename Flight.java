/**
 * Flight class is a class that holds the information regarding a specific
 * flight.
 * Ex: (Flight Type, Departure City and State, Arrival City and State, Departure
 * Date and Time, Arrival Date and Time, Price Per Seat, Seat Availability and
 * Flight Number)
 * 
 * @author Mohammad Seeam
 */

import java.util.Random;

class Flight {

    /* Variable Declarations */
    protected String flightType; // flightType holds the type of flight it is (One-Way or Two-Way)
    // departureCity and departureState hold the String value departure city and
    // state, respectively
    protected String departureCity, departureState;
    // arrivalCity and arrivalState hold the String value arrival city and state,
    // respectively
    protected String arrivalCity, arrivalState;
    // departureDate holds the date the flight leaves
    protected String departureDate;
    // departureTime holds the time the flight leaves
    protected String departureTime;
    // arrivalDate holds the date the flight arrives
    protected String arrivalDate;
    // arrivalTime holds the time the flight arrives
    protected String arrivalTime;
    // price_per_seat holds the double value of the cost of a seat on a flight
    protected double price_per_seat;
    // seat_availability holds the int value of the number of seats available on a
    // flight
    protected int seat_availability;
    // flight_number will hold the uniquely flight number
    protected String flight_number;

    /*
     * Default constructor
     */
    public Flight() {
        this.flightType = "One-Way";
        this.departureCity = "Lubbock";
        this.departureState = "Texas";
        this.arrivalCity = "San Francisco";
        this.arrivalState = "California";
        this.departureDate = "01/01/2023";
        this.departureTime = "01:01:01";
        this.arrivalDate = "12/31/2023";
        this.arrivalTime = "23:59:59";
        this.price_per_seat = 100;
        this.seat_availability = 30;
        this.flight_number = generateFlightNumber();
    }

    /*
     * Constructor is immediately provided with all flight information (Type Of
     * Flight, Departure City and State, Arrival City and State, Departure Date
     * and Time, Arrival Date and Time, Seat Price and Seat Availability) and then
     * generates a flight number.
     */
    public Flight(String flight_type, String departure_city, String departure_state, String arrival_city,
            String arrival_state, String departure_date, String departure_time, String arrival_date,
            String arrival_time, int seat_price, int seat_limit) {
        this.flightType = flight_type;
        this.departureCity = departure_city;
        this.departureState = departure_state;
        this.arrivalCity = arrival_city;
        this.arrivalState = arrival_state;
        this.departureDate = departure_date;
        this.departureTime = departure_time;
        this.arrivalDate = arrival_date;
        this.arrivalTime = arrival_time;
        this.price_per_seat = seat_price;
        this.seat_availability = seat_limit;
        this.flight_number = generateFlightNumber();
    }

    /*
     * setFlightType(String flight_type) sets flight type from user (One way or
     * Return)
     */
    public void setFlightType(String flight_type) {
        flightType = flight_type;
    }

    /*
     * setDepartureCity(String departure_city) sets flight departure city
     */
    public void setDepartureCity(String departure_city) {
        departureCity = departure_city;
    }

    /*
     * setDepartureState(String departure_state) sets flight departure state
     */
    public void setDepartureState(String departure_state) {
        departureState = departure_state;
    }

    /*
     * setArrivalCity(String arrival_city) sets flight arrival city
     */
    public void setArrivalCity(String arrival_city) {
        arrivalCity = arrival_city;
    }

    /*
     * setArrivalState(String arrival_state) sets flight arrival state
     */
    public void setArrivalState(String arrival_state) {
        arrivalState = arrival_state;
    }

    /*
     * setDepartureDate(String departure_date) sets flight departure date
     */
    public void setDepartureDate(String departure_date) {
        departureDate = departure_date;
    }

    /*
     * setDepartureTime(String departure_time) sets flight departure time
     */
    public void setDepartureTime(String departure_time) {
        departureTime = departure_time;
    }

    /*
     * setArrivalDate(String arrival_date) sets flight arrival date
     */
    public void setArrivalDate(String arrival_date) {
        arrivalDate = arrival_date;
    }

    /*
     * setArrivalTime(String arrival_time) sets flight arrival time
     */
    public void setArrivalTime(String arrival_time) {
        arrivalTime = arrival_time;
    }

    /*
     * getFlightType() returns flight type
     */
    public String getFlightType() {
        return flightType;
    }

    /*
     * getDepartureCity() returns flight departure city
     */
    public String getDepartureCity() {
        return departureCity;
    }

    /*
     * getDepartureState() returns flight departure state
     */
    public String getDepartureState() {
        return departureState;
    }

    /*
     * getArrivalCity() returns flight arrival city
     */
    public String getArrivalCity() {
        return arrivalCity;
    }

    /*
     * getArrivalState() returns flight arrival state
     */
    public String getArrivalState() {
        return arrivalState;
    }

    /*
     * getDepartureDate() returns flight departure date
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /*
     * getDepartureDate() returns flight departure date
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /*
     * getArrivalDate() returns flight arrival date
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /*
     * getArrivalTime() returns flight arrival time
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /*
     * getSeatAvailability() returns flight seat available
     */
    public int getSeatAvailability() {
        return seat_availability;
    }

    /*
     * getPricePerSeat() returns seat price
     */
    public double getPricePerSeat() {
        return price_per_seat;
    }

    /*
     * getflightNumber() returns flight number
     */
    public String getflightNumber() {
        return flight_number;
    }

    /*
     * generateFlightNumber() makes flight number
     */
    public String generateFlightNumber() {
        // using random class to generate a number between 1 and 1000000, inclusive
        Random random = new Random();
        int flight_number = random.nextInt(1000000);// flight_number will hold flight number
        // changing the data type from int to String
        return String.format("%06d", flight_number);// returns flight_number
    }

    /*
     * decrease_seat_availability() decreases seat_availability.
     */
    public void decrease_seat_availability() {
        seat_availability--;
    }

}