package com.willitend.backend.willitendBackend;

public class newsletter {
    private String userEmail;
    private String userState;
    public newsletter(String userEmail, String userState){
        this.userEmail = userEmail;
        this.userState = userState;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public String getUserState() {
        return userState;
    }
    public void setUserState(String userState) {
        this.userState = userState;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    } 
    public boolean insertUserToDataBase(){
        if(this.isEmailCanFind()) return false;
        else{
            //
                // TODO : Needs some SQL statement inserting user into database. 
            //
            return true;
        }

    }
    private boolean isEmailCanFind()
    {
        // Some SQL statement in here. 
        return false;
    }
    
}
