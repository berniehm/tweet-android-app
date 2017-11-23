package model;

/**This class will contain the users details for example their name
 * and email and password
 * Created by berni on 11/22/17
 */


public  class User {
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}