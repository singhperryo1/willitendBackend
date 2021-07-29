public class Username extends UserInfo {
    static String firstName;
    static String lastName;

    public Username(String organization, String email, String password, String firstName, String lastName) {
        super(organization, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

