package models;


import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;
    private String name;
    private String age;
    private String gender;
    private String PhoneNumber;
    private String address;

    private String role;

    public Account() {
    }

    public Account(String username, String password, String name, String age, String gender, String phoneNumber, String address, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        PhoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account[" +
                "username = " + username +
                ", password = " + password +
                ", name = " + name +
                ", age = " + age +
                ", gender = " + gender +
                ", PhoneNumber = " + PhoneNumber +
                ", address = " + address +
                ", role = " + role +
                ']';
    }
}

