# Project name: Flight Reservation System

The program is designed for use by officials of the airline company to book a passenger's flight. This program is not designed for passengers.

The Flight Reservation System project showcases the implementation of three classes: `Passenger`, `Flight` and `Reservation`. To begin, the `Passenger` class is an *abstract class* that reflects characteristics of a passenger. Such as **name**, **age**, **gender** and **passport number**. Further, this class is extended in the `Member` class that acts as a passenger with an airline membership that is eligible for a discount. Moving forward, the `Flight class` is designed for making flight with details, such as **departure date and time** and **arrival date and time**, **departure and arrival city**, **departure and arrival state**, **seat availability**, **flight price** and so on. Moreover, the `Reservation` class works hand in hand with these Object classes to pair them together to confirm a **reservation**. Lastly, the `FlightReservationSystem` class is the main class driver.

* Created using `Visual Studio Code`

* Tested using `openjdk version "20" 2023-03-21`

* System used to test: `MacOS` (should work on any system)

## Usage

 1. First compile and run the `FlightReservationSystem.java` file.

 2. Next you will be given a series of choices within the terminal.

 ```terminal

Hello! Welcome to our Flight Reservation System.

Please choose an option: 

a) Add Passenger

b) Add Flight

c) Make a Reservation

d) Print All Reservations

e) Exit

Type your selection now: 

 ```

 3. Based on your selection, you will be asked to give input in a certain format. Such as...

 ```terminal

Type your selection now: a

Enter Passenger Information separated by comma: Name, Age, Gender, Passport, Year of Membership.

Type Here:     

 ```

 * `Example Input:` Bob, 18, male, 123RT, 18

 ```terminal

 Type your selection now: b

Enter Flight Information separated by comma: Flight Type, Departure City, Departure State, Arrival City, Arrival State, Departure Date, Departure Time, Arrival Date, Arrival Time, Seat Price, Seat Limit.

Type Here:

 ```

 * `Example Input:` one way, Lubbock, TX, Austin, TX, 12/27/2023, 12:00, 12/28/2023, 3:00, 100, 10

 4. After you have both a flight and a Passenger added, you are able to complete a reservation.

 ```terminal

Type your selection now: c

All Available Passengers (Name,Passport): (Bob,123RT),

All Available Flight (Flight Number,Seat Availability): (265351,10),

Type passenger PASSPORT-NUMBER and FLIGHT-NUMBER to confirm and reserve:

 ```

 * `Example Input:` 123RT,265351



 5. Creating a reservation allows you to print all current reservations.



 ```terminal

Type your selection now: d

All Available Passengers (Name, Passport): (Bob,123RT),

All Available Flight (Flight Number, Seat Availability): (265351,9),

All Reservations (Name, Passport, Flight): (Bob,123RT,265351),

Do you want a detailed reservation information? (Y/N):

 ```

* Inputing 'Y' Gives more detailed information about the reservation.

```terminal

Do you want a detailed reservation information? (Y/N): y

-------------------------------------------------

Name                  : Bob

Age                   : 18

Gender                : male

Passport              : 123RT

Flight type           : one way

Departure City        : Lubbock

Departure State       : TX

Departure Date        : 12/27/2023

Departure Time        : 12:00

Arrival City          : Austin

Arrival State         : TX

Arrival Date          : 12/28/2023

Arrival Time          : 3:00

Actual Price          : 100.0

Price after discount  : 50.0

Reservation ID        : 1

Available Seat        : 9

-------------------------------------------------

```



6. Inputing 'e' for the selection exits you from the program.

```terminal

Type your selection now: e

Program Ends... Bye !

```


NOTE: One passenger can book multiple flights, but 1 passenger can not reserve seat on the same flight twice.



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