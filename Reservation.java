/**
 * Reservation class is a class that holds the information regarding both
 * passengers and flights in order to make a reservation. After all information
 * has been provided, a reservation number will be generated.
 * 
 * @author Mohammad Seeam
 */

class Reservation {

    /* Variable Declarations */
    private Passenger p; // p is a Passenger object for this reservation
    private Flight fli; // fli is a Flight object for this reservation
    // reservation_id keeps track of the number of reservations made, that is why
    // it is static
    private static int reservation_id = 0;

    /*
     * Constructor is provided with a passenger and a flight object and will
     * increase
     * the number
     * of reservation and decrease the number of seats available on that
     * flight
     */
    public Reservation(Passenger pass, Flight fli) {
        this.p = pass;
        this.fli = fli;
        this.reservation_id++;
        this.fli.decrease_seat_availability();
    }

    /*
     * setPassenger_mem(Passenger p) function takes p the Passenger object to set as
     * the new passenger.
     */
    public void setPassenger_mem(Passenger p) {
        this.p = p;
    }

    /*
     * setFlight(Flight f) function takes f the Flight object to set as the new
     * Flight.
     */
    public void setFlight(Flight f) {
        this.fli = f;
    }

    /*
     * getPassenger_mem() returns Passenger object
     */
    public Passenger getPassenger_mem() {
        return p;
    }

    /*
     * getFlight() returns Flight object
     */
    public Flight getFlight() {
        return fli;
    }

    /*
     * get_reservation_id() returns reservation_id
     */
    public int get_reservation_id() {
        return reservation_id;
    }

    /*
     * print_reservation() prints ALL informations
     */
    public void print_reservation() {
        System.out.println("Name                  : " + getPassenger_mem().getName());
        System.out.println("Age                   : " + getPassenger_mem().getAge());
        System.out.println("Gender                : " + getPassenger_mem().getGender());
        System.out.println("Passport              : " + getPassenger_mem().getpassport_number());
        System.out.println("Flight type           : " + getFlight().getFlightType());
        System.out.println("Flight number         : " + getFlight().getflightNumber());
        System.out.println("Departure City        : " + getFlight().getDepartureCity());
        System.out.println("Departure State       : " + getFlight().getDepartureState());
        System.out.println("Departure Date        : " + getFlight().getDepartureDate());
        System.out.println("Departure Time        : " + getFlight().getDepartureTime());
        System.out.println("Arrival City          : " + getFlight().getArrivalCity());
        System.out.println("Arrival State         : " + getFlight().getArrivalState());
        System.out.println("Arrival Date          : " + getFlight().getArrivalDate());
        System.out.println("Arrival Time          : " + getFlight().getArrivalTime());
        System.out.println("Actual Price          : " + getFlight().getPricePerSeat());
        System.out
                .println("Price after discount  : " + getPassenger_mem().applyDiscount(getFlight().getPricePerSeat()));
        System.out.println("Available Seat        : " + getFlight().getSeatAvailability());
    }

    /*
     * getReservation(Passenger mem, Flight f) method ensures the flight still has
     * available seats BEFORE booking
     */
    public static Reservation getReservation(Passenger mem, Flight f) {
        if (f.getSeatAvailability() == 0) {
            System.out.print("Error! No seat available,");
            return null;
        } else {
            return new Reservation(mem, f);
        }
    }
}
