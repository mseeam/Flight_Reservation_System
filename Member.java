/**
 * Member class extends Passenger class
 * Inside Member class, we override and impliment all abstract methods of
 * Passenger class
 * 
 * @author Mohammad Seeam
 * @author Evelyn Zacarias
 * @author Taylor Smith
 */

class Member extends Passenger {

    /* Variable Declarations */
    private int yearsOfMembership; // yearsOfMembership holds the int amount of years of membership a Passenger has

    /*
     * Constructor is immediately provided with all the information of the passenger
     * (Name, Age, Gender, Passport Number and Years Of Membership)
     */
    public Member(String name, int age, String gender, String passport, int yearsOfMembership) {
        super(name, age, gender, passport);
        this.yearsOfMembership = yearsOfMembership;
    }

    /*
     * setName(String name_parameter) sets name from user
     */
    @Override
    public void setName(String name_parameter) {
        name = name_parameter;
    }

    /*
     * setAge(int age_parameter) sets age from user
     */
    @Override
    public void setAge(int age_parameter) {
        age = age_parameter;
    }

    /*
     * setGender(String gender_parameter) sets gender from user
     */
    @Override
    public void setGender(String gender_parameter) {
        gender = gender_parameter;
    }

    /*
     * setpassport_number(String passport_number_parameter) sets passport number
     * from user
     */
    @Override
    public void setpassport_number(String passport_number_parameter) {
        passport_number = passport_number_parameter;
    }

    /*
     * getName() is a getter function that returns name as String
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * getAge() is a getter function that returns age as int
     */
    @Override
    public int getAge() {
        return age;
    }

    /*
     * getGender() is a getter function that returns gender as String
     */
    @Override
    public String getGender() {
        return gender;
    }

    /*
     * getpassport_number() is a getter function that returns passport number as
     * String
     */
    @Override
    public String getpassport_number() {
        return passport_number;
    }

    /*
     * setYearsOfMembership(int yearsOfMembership_param) is a setter function that
     * sets year of membership from user
     */
    public void setYearsOfMembership(int yearsOfMembership_param) {
        yearsOfMembership = yearsOfMembership_param;
    }

    /*
     * setYearsOfMembership(int yearsOfMembership_param) is a getter function that
     * returns membership year
     */
    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    /*
     * applyDiscount(double price) function calculates and gives discount based on
     * customer's year of membership
     */
    @Override
    public double applyDiscount(double price) {
        double price_before_discount = price; // price_before_discount holds the original price
        double price_after_discount; // price_after_discount holds the discounted price
        // If yearsOfMembership is greater than 5, member receives 50% discount
        // If yearsOfMembership is greater than 1 but less than or equal to 5, member
        // receives 10% discount
        // Else yearsOfMembership is less than 1, member receives 0% discount
        if (yearsOfMembership > 5) {
            price_after_discount = price_before_discount * 0.5;
            return price_after_discount;
        } else if (yearsOfMembership > 1 && yearsOfMembership <= 5) {
            price_after_discount = price_before_discount * 0.9;
            return price_after_discount;
        } else {
            price_after_discount = price_before_discount;
            return price_after_discount;
        }
    }

}