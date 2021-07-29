public class UserInfo{
    static String organization;
    static String email;
    static String password;

    public UserInfo(String organization, String email, String password) {
        this.organization = organization;
        this.email = email;
        this.password = password;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object printUserInfo(){
        System.out.println("Test to print out user's information:" );
        System.out.println("org:" + organization );
        System.out.println("email:" + email );
        System.out.println("password: " + password);
        return null;
    }


}
