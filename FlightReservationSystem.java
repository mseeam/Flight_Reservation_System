import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

/**
 * FlightReservationSystem class is the main class driver that runs all
 * Passenger,
 * Flight and Reservation classes. Includes necessary methods such as
 * addPassenger(),
 * addFlight(), makeReservation and PrintEverything().
 * 
 * @author Mohammad Seeam
 */

public class FlightReservationSystem {

    /* ArrayLists used to keep track of all Object types created */
    public static List<Passenger> all_passengers = new ArrayList<>(); // That list is for Passenger objects
    public static List<Flight> all_flights = new ArrayList<>(); // That list is for Flight objects
    public static List<Reservation> all_reservations = new ArrayList<>(); // That list is for Reservation objects

    /*
     * void main(String[] args) is the main function.
     */
    public static void main(String[] args) {
        /* Necessary instantiations */
        Scanner myObj = new Scanner(System.in); // new Scanner object created to read user input
        String input; // input will hold the user's input (String)

        /* Actively checking for necessary exceptions */
        while (true) {
            try {
                // showcasing a "menu"
                System.out.println("Hello! Welcome to our Flight Reservation System.");
                System.out.println(
                        "Please choose an option: \na) Add Passenger\nb) Add Flight\nc) Make a Reservation\nd) " +
                                "Print All Reservations\ne) Exit");
                while (true) {

                    // prompting for user input
                    System.out.print("Type your selection now: ");
                    input = myObj.nextLine();

                    // acting upon said input
                    // ensuring input is NOT empty
                    if (input.isEmpty()) {
                        System.out.println("Input can not be empty. Please try again.....");
                    }
                    // if input is 'a', add Passenger
                    else if (input.toLowerCase().equals("a")) {
                        addPassenger();
                        System.out.println();
                        break;
                    }
                    // if input is 'b', add Flight
                    else if (input.toLowerCase().equals("b")) {
                        addFlight();
                        System.out.println();
                        break;
                    }
                    // if input is 'c', make Reservation
                    else if (input.toLowerCase().equals("c")) {
                        makeReservation();
                        System.out.println();
                        break;
                    }
                    // if input is 'd', print Reservation details
                    else if (input.toLowerCase().equals("d")) {
                        printEverything();
                        System.out.println();
                        break;
                    }
                    // if input is 'e', exit while loop
                    else if (input.toLowerCase().equals("e")) {
                        System.out.println("Program Ends... Bye !");
                        System.exit(0);
                        break;
                    }
                    // else, invalid input
                    else {
                        System.out.print("Invalid input! Try again..... ");
                    }
                }
                // Exception
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /*
     * addPassenger() takes passenger information, EX: (Name, Age, Gender, Passport,
     * Year of Membership)
     */
    private static void addPassenger() {
        Scanner myObj = new Scanner(System.in);// new Scanner object created to read user input
        String input;// input will hold the user's input (String)
        System.out.print(
                "Enter Passenger Information separated by comma: Name, Age, Gender, Passport, Year of Membership.\nType Here: ");
        while (true) {
            input = myObj.nextLine();
            if (!input.isEmpty()) {
                String[] tokens = input.split(",");
                Arrays.stream(tokens).map(String::trim).toArray(unused -> tokens);

                if (input.toLowerCase().equals("exit")) {
                    System.out.println("Passenger Add cancelled!");
                    break;
                } else if (tokens.length != 5) {
                    System.out.print("Error! One or more information about passenger is missing\ntype again: ");
                } else {
                    try {
                        // age for age
                        // yearOfMembership for year of membership
                        int age = Integer.parseInt(tokens[1]);
                        int yearOfMembership = Integer.parseInt(tokens[4]);
                        // check if this passenger passport number already exists
                        // dontAddPassenger used to check
                        boolean dontAddPassenger = false;
                        for (Passenger p : all_passengers) {
                            if (p.getpassport_number().equals(tokens[3])) {
                                System.out.println("Passenger with passport number " + tokens[3] + " already exists!");
                                dontAddPassenger = true;
                                break;
                            }
                        }

                        if (!dontAddPassenger) {
                            Passenger p = new Member(tokens[0], age, tokens[2], tokens[3], yearOfMembership);
                            all_passengers.add(p);
                            System.out.println("Passenger with passport number " + tokens[3] + " added successfully! ");
                        }
                        break;
                        // Exception
                    } catch (NumberFormatException e) {
                        System.out.print("Error! Age or yearOfMembership must be integer\ntype again: ");
                    }
                }
            } else {
                System.out.println("type \'exit\' to cancel adding passenger");
            }
        }
    }

    /*
     * addFlight() takes flight information, EX: (Flight Type, Departure City,
     * Departure State, Arrival City, Arrival State, Departure Date, Departure Time,
     * Arrival Date, Arrival Time, Seat Price, Seat Limit)
     */
    private static void addFlight() {
        Scanner myObj = new Scanner(System.in);// new Scanner object created to read user input
        String input;// input will hold the user's input (String)
        System.out.print(
                "Enter Flight Information separated by comma: Flight Type, Departure City, Departure State, Arrival City, Arrival State, Departure Date, Departure Time, Arrival Date, Arrival Time, Seat Price, Seat Limit.\nType Here: ");
        while (true) {
            try {
                input = myObj.nextLine();
                if (!input.isEmpty()) {
                    String[] tokens = input.split(",");
                    Arrays.stream(tokens).map(String::trim).toArray(unused -> tokens);
                    if (input.toLowerCase().equals("exit")) {
                        System.out.println("Flight add cancelled!");
                        break;
                    } else if (tokens.length != 11) {
                        System.out.print("Error! One or more information about flight is missing\ntype again: ");
                    } else if (!tokens[9].matches("-?\\d+(\\.\\d+)?") || !tokens[10].matches("-?\\d+(\\.\\d+)?")) {
                        System.out.print("Error! Seat Price or Seat Limit must be integer\ntype again: ");
                    } else {
                        // no need to check if the flight already exists since flight number is auto
                        // generated so all flight are unique.
                        Flight f = new Flight(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5],
                                tokens[6],
                                tokens[7], tokens[8], Integer.parseInt(tokens[9]), Integer.parseInt(tokens[10]));
                        all_flights.add(f);
                        System.out.println("Flight added successfully!");
                        break;
                    }
                } else {
                    System.out.println("type \'exit\' to cancel adding flight");
                }
                // Exception
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /*
     * makeReservation() makes reservation
     */
    private static void makeReservation() {
        try {
            if (all_passengers.size() == 0) {
                System.out.println("No Passenger Available, Add Passenger First!");
                return;
            }
            if (all_flights.size() == 0) {
                System.out.println("No Flight Available, Add Flight First!");
                return;
            }
            System.out.print("All Available Passengers (Name,Passport): ");
            for (Passenger p : all_passengers) {
                System.out.print("(" + p.getName() + "," + p.getpassport_number() + "), ");
            }
            System.out.println();
            System.out.print("All Available Flight (Flight Number,Seat Availability): ");
            for (Flight f : all_flights) {
                System.out.print("(" + f.getflightNumber() + "," + f.getSeatAvailability() + "), ");
            }
            System.out.println();
            Scanner myObj = new Scanner(System.in);// new Scanner object created to read user input
            System.out.print("Type passenger PASSPORT-NUMBER and FLIGHT-NUMBER to confirm and reserve: ");

            String input; // To hold user input
            while (true) {
                input = myObj.nextLine();
                if (!input.isEmpty()) {
                    String[] tokens = input.split(",");
                    Arrays.stream(tokens).map(String::trim).toArray(unused -> tokens); // trim all element
                    if (input.toLowerCase().equals("Exit")) {
                        System.out.println("Reservation Cancelled!");
                        break;
                    } else if (tokens.length != 2) {
                        System.out.print("Error! Type PASSPORT-NUMBER and FLIGHT-NUMBER: ");
                    } else {
                        // check if passenger exists
                        Passenger passenger = null;
                        for (Passenger p : all_passengers) {
                            if (p.getpassport_number().equals(tokens[0])) {
                                passenger = p;
                                break;
                            }
                        }
                        // check if flight exists
                        Flight flight = null;
                        for (Flight f : all_flights) {
                            if (f.getflightNumber().equals(tokens[1])) {
                                flight = f;
                                break;
                            }
                        }
                        if (passenger != null && flight != null) {
                            // check if passenger already have a reservation for the same flight
                            boolean dontReserve = false;
                            for (Reservation r : all_reservations) {
                                if (r.getPassenger_mem().getpassport_number().equals(passenger.getpassport_number()) &&
                                        r.getFlight().getflightNumber().equals(flight.getflightNumber())) {
                                    System.out.println(
                                            "Error! The passenger already has a reservation for the same flight ! ");
                                    dontReserve = true;
                                    ;
                                    break;
                                }
                            }
                            if (!dontReserve) {
                                Reservation reservation = Reservation.getReservation(passenger, flight);
                                if (reservation == null) {
                                    System.out.print("Reservation Failed!");
                                } else {
                                    all_reservations.add(reservation);
                                    System.out.println("Reservations Number " + reservation.get_reservation_id()
                                            + " Added Successfully!");
                                }
                            }
                        } else {
                            System.out.println(
                                    "Error: Reservation Failed! Invalid PASSENGER or FLIGHT input! Try again.....");
                        }
                        break;
                    }
                } else {
                    System.out.println("Type \'Exit\' to cancel Reservation");
                }
            }
            // Exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * printEverything() prints information about passenger, flight and reservation
     */
    private static void printEverything() {
        try {
            if (all_passengers.size() == 0) {
                System.out.println("No passenger available");
            } else {
                System.out.print("All Available Passengers (Name, Passport): ");
                for (Passenger p : all_passengers) {
                    System.out.print("(" + p.getName() + "," + p.getpassport_number() + "), ");
                }
                System.out.println();
            }

            if (all_flights.size() == 0) {
                System.out.println("No flight available");
            } else {
                System.out.print("All Available Flight (Flight Number, Seat Availability): ");
                for (Flight f : all_flights) {
                    System.out.print("(" + f.getflightNumber() + "," + f.getSeatAvailability() + "), ");
                }
                System.out.println();
            }

            if (all_reservations.size() == 0) {
                System.out.println("No reservation available");
            } else {
                System.out.print("All Reservations (Name, Passport, Flight): ");
                for (Reservation r : all_reservations) {
                    System.out.print(
                            "(" + r.getPassenger_mem().getName() + "," + r.getPassenger_mem().getpassport_number()
                                    + "," + r.getFlight().getflightNumber()
                                    + ")" + ", ");
                }
                System.out.println();

                // ask if user wants detailed reservations
                Scanner myObj = new Scanner(System.in);// new Scanner object created to read user input
                String input; // hold user input
                while (true) {
                    System.out.print("Do you want a detailed reservation information? (Y/N): ");
                    input = myObj.nextLine();
                    if (!input.isEmpty()) {
                        if (input.toLowerCase().equals("y")) {
                            for (int i = 0; i < all_reservations.size(); i++) {
                                System.out.println("-------------------------------------------------");
                                all_reservations.get(i).print_reservation();
                                System.out.println("-------------------------------------------------");
                            }
                            break;
                        } else if (input.toLowerCase().equals("n")) {
                            break;
                        }
                    }
                }
            }
            // Exception
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

/***********************************/
/* Sample detailed output is below */
/***********************************/

/*
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: c
 * No Passenger Available, Add Passenger First!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: a
 * Enter Passenger Information separated by comma: Name, Age, Gender, Passport,
 * Year of Membership.
 * Type Here: MOHAMMAD,23,Male,EB77777,10
 * Passenger with passport number EB77777 added successfully!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: b
 * Enter Flight Information separated by comma: Flight Type, Departure City,
 * Departure State, Arrival City, Arrival State, Departure Date, Departure Time,
 * Arrival Date, Arrival Time, Seat Price, Seat Limit.
 * Type Here: One-Way,
 * Lubbock,TX,Austin,TX,01/01/2023,12:00,01/02/2023,23:59,500,50
 * Flight added successfully!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: c
 * All Available Passengers (Name,Passport): (MOHAMMAD,EB77777),
 * All Available Flight (Flight Number,Seat Availability): (521467,50),
 * Type passenger PASSPORT-NUMBER and FLIGHT-NUMBER to confirm and reserve:
 * EB77777,(521467
 * Error: Reservation Failed! Invalid PASSENGER or FLIGHT input! Try again.....
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: c
 * All Available Passengers (Name,Passport): (MOHAMMAD,EB77777),
 * All Available Flight (Flight Number,Seat Availability): (521467,50),
 * Type passenger PASSPORT-NUMBER and FLIGHT-NUMBER to confirm and reserve:
 * EB77777,521467
 * Reservations Number 1 Added Successfully!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: d
 * All Available Passengers (Name, Passport): (MOHAMMAD,EB77777),
 * All Available Flight (Flight Number, Seat Availability): (521467,49),
 * All Reservations (Name, Passport, Flight): (MOHAMMAD,EB77777,521467),
 * Do you want a detailed reservation information? (Y/N): y
 * -------------------------------------------------
 * Name : MOHAMMAD
 * Age : 23
 * Gender : Male
 * Passport : EB77777
 * Flight type : One-Way
 * Flight number : 521467
 * Departure City : Lubbock
 * Departure State : TX
 * Departure Date : 01/01/2023
 * Departure Time : 12:00
 * Arrival City : Austin
 * Arrival State : TX
 * Arrival Date : 01/02/2023
 * Arrival Time : 23:59
 * Actual Price : 500.0
 * Price after discount : 250.0
 * Available Seat : 49
 * -------------------------------------------------
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: a
 * Enter Passenger Information separated by comma: Name, Age, Gender, Passport,
 * Year of Membership.
 * Type Here: Evelyn,20,Female,AA9999999,1
 * Passenger with passport number AA9999999 added successfully!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: c
 * All Available Passengers (Name,Passport): (MOHAMMAD,EB77777),
 * (Evelyn,AA9999999),
 * All Available Flight (Flight Number,Seat Availability): (521467,49),
 * Type passenger PASSPORT-NUMBER and FLIGHT-NUMBER to confirm and reserve:
 * AA9999999,521467
 * Reservations Number 2 Added Successfully!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: b
 * Enter Flight Information separated by comma: Flight Type, Departure City,
 * Departure State, Arrival City, Arrival State, Departure Date, Departure Time,
 * Arrival Date, Arrival Time, Seat Price, Seat Limit.
 * Type Here: Round,San Jose, CA, Lake Tahoe,
 * CA,05/25/2023,01:10,05/30/2023,10:10,1000,10
 * Flight added successfully!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: d
 * All Available Passengers (Name, Passport): (MOHAMMAD,EB77777),
 * (Evelyn,AA9999999),
 * All Available Flight (Flight Number, Seat Availability): (521467,48),
 * (171783,10),
 * All Reservations (Name, Passport, Flight): (MOHAMMAD,EB77777,521467),
 * (Evelyn,AA9999999,521467),
 * Do you want a detailed reservation information? (Y/N): n
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: c
 * All Available Passengers (Name,Passport): (MOHAMMAD,EB77777),
 * (Evelyn,AA9999999),
 * All Available Flight (Flight Number,Seat Availability): (521467,48),
 * (171783,10),
 * Type passenger PASSPORT-NUMBER and FLIGHT-NUMBER to confirm and reserve:
 * AA9999999,171783
 * Reservations Number 3 Added Successfully!
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: d
 * All Available Passengers (Name, Passport): (MOHAMMAD,EB77777),
 * (Evelyn,AA9999999),
 * All Available Flight (Flight Number, Seat Availability): (521467,48),
 * (171783,9),
 * All Reservations (Name, Passport, Flight): (MOHAMMAD,EB77777,521467),
 * (Evelyn,AA9999999,521467), (Evelyn,AA9999999,171783),
 * Do you want a detailed reservation information? (Y/N): y
 * -------------------------------------------------
 * Name : MOHAMMAD
 * Age : 23
 * Gender : Male
 * Passport : EB77777
 * Flight type : One-Way
 * Flight number : 521467
 * Departure City : Lubbock
 * Departure State : TX
 * Departure Date : 01/01/2023
 * Departure Time : 12:00
 * Arrival City : Austin
 * Arrival State : TX
 * Arrival Date : 01/02/2023
 * Arrival Time : 23:59
 * Actual Price : 500.0
 * Price after discount : 250.0
 * Available Seat : 48
 * -------------------------------------------------
 * -------------------------------------------------
 * Name : Evelyn
 * Age : 20
 * Gender : Female
 * Passport : AA9999999
 * Flight type : One-Way
 * Flight number : 521467
 * Departure City : Lubbock
 * Departure State : TX
 * Departure Date : 01/01/2023
 * Departure Time : 12:00
 * Arrival City : Austin
 * Arrival State : TX
 * Arrival Date : 01/02/2023
 * Arrival Time : 23:59
 * Actual Price : 500.0
 * Price after discount : 500.0
 * Available Seat : 48
 * -------------------------------------------------
 * -------------------------------------------------
 * Name : Evelyn
 * Age : 20
 * Gender : Female
 * Passport : AA9999999
 * Flight type : Round
 * Flight number : 171783
 * Departure City : San Jose
 * Departure State : CA
 * Departure Date : 05/25/2023
 * Departure Time : 01:10
 * Arrival City : Lake Tahoe
 * Arrival State : CA
 * Arrival Date : 05/30/2023
 * Arrival Time : 10:10
 * Actual Price : 1000.0
 * Price after discount : 1000.0
 * Available Seat : 9
 * -------------------------------------------------
 * 
 * Hello! Welcome to our Flight Reservation System.
 * Please choose an option:
 * a) Add Passenger
 * b) Add Flight
 * c) Make a Reservation
 * d) Print All Reservations
 * e) Exit
 * Type your selection now: 1
 * Invalid input! Try again..... Type your selection now: e
 * Program Ends... Bye !
 */