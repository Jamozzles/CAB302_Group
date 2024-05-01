package com.example.cab302_project_mood_tracker.Model;

public class Account {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Account(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    //Override for debugging the print method
    @Override
    public String toString() {
        // Return all fields in a specific order
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email + ", Phone: " + phone;
    }
}