package org.rebecca.javabrains.StockAnalyser.model;

public class User {
    private String userID;
    private String emailID;
    private String password;
    private String name;
    private long contactNo;

    public String getUserID() {
        return userID;

    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public User() { }

    public User(String userID, String emailID, String password, String name, long contactNo) {

        this.userID = userID;
        this.emailID = emailID;
        this.password = password;
        this.name = name;
        this.contactNo = contactNo;
    }
}
