package application.security;

import application.model.User;

public class UserPrincipal {

    User user;

    private static UserPrincipal ourInstance = new UserPrincipal();

    public static UserPrincipal getInstance() {
        return ourInstance;
    }

    private UserPrincipal() {
    }

    public User getLoggedUser() {
        return user;
    }

    public void setLoggedUser(User user) {
        this.user = user;
    }

    public boolean isUserLogged() {
        if(user != null) {
            return true;
        }
        return false;
    }

}
