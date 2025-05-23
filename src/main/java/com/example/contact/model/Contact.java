package com.example.contact.model;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String company;
    private String position;

    public Contact() {}

    public Contact(String name, String phone, String email, String company, String position) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.position = position;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}