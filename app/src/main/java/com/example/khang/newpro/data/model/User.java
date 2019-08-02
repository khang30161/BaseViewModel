package com.example.khang.newpro.data.model;

public class User {

    private String userId;
    private String userName;
    private String numberPhone;
    private String gender;
    private String address;
    private String description;

    public User(String userId, String userName, String numberPhone, String gender, String address, String description) {
        this.userId = userId;
        this.userName = userName;
        this.numberPhone = numberPhone;
        this.gender = gender;
        this.address = address;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
