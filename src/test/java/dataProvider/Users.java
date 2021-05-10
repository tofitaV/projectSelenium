package dataProvider;

import properties.Properties;

public class Users {

    private final UserRole userRole;

    public Users(UserRole userRole){
        this.userRole = userRole;
    }

    public enum UserRole{
        TESTER1,
        TESTER2
    }

    public String getLogin(){
        switch (userRole){
            case TESTER1: return Properties.props.tester1Login();
            default: return null;
        }
    }

    public String getPassword(){
        switch (userRole){
            case TESTER1: return Properties.props.tester1Password();
            default: return null;
        }
    }



}
