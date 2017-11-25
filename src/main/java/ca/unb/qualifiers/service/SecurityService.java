package ca.unb.qualifiers.service;


public interface SecurityService{

    String findLoggedInUsername();

    void autologin(String username, String password);
}

