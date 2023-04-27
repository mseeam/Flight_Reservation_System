/**
 * Passenger class is an abstract class that holds basic informations
 * of the specified passenger. Ex: Name, Age, Gender and Passport Number.
 * Member class EXTENDS Passenger class and impliments abstract class and it's
 * methods
 * 
 * @author Mohammad Seeam
 */

abstract class Passenger {
    /* Variables Declaration */
    protected String name; // name holds the name of the passenger
    protected int age; // age holds the int value of the passenger's age
    protected String gender; // gender holds the gender the passenger identifies
    protected String passport_number; // passport number holds the passenger's passport number

    /*
     * Constructor is immediately provided with all the information of the passenger
     * (Name, Age, Gender and Passport Number)
     */
    public Passenger(String name, int age, String gender, String passport_number) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.passport_number = passport_number;
    }

    /*
     * setName(String name_parameter) is a abstract void setter function that set
     * name from user
     */
    public abstract void setName(String name_parameter);

    /*
     * setAge(int age_parameter) is a abstract void setter function that set age
     * from user
     */
    public abstract void setAge(int age_parameter);

    /*
     * setGender(String gender_parameter) is a abstract void setter function that
     * set gender from user
     */
    public abstract void setGender(String gender_parameter);

    /*
     * setpassport_number(String passport_number_parameter) is a abstract void
     * setter function that set passport number from user
     */
    public abstract void setpassport_number(String passport_number_parameter);

    /*
     * getName() is an abstract getter function that returns name as String
     */
    public abstract String getName();

    /*
     * getAge() is an abstract getter function that returns age as int
     */
    public abstract int getAge();

    /*
     * getGender() is an abstract getter function that returns gender as String
     */
    public abstract String getGender();

    /*
     * getpassport_number() is an abstract getter function that returns passport
     * number as String
     */
    public abstract String getpassport_number();

    /*
     * applyDiscount(double p) is an abstract function that returns price after
     * discount
     */
    public abstract double applyDiscount(double p);

}
