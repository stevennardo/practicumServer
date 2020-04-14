package com.example.demo;

public class Contact {

    String id;
    String name;
    String number;
    String email;
    String address;
    String city;
    String state;
    String zip;
    String bday;
    String linked;

    public Contact(String id, String name, String number, String email, String address, String city, String state, String zip, String bday, String linked) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.bday = bday;
        this.linked = linked;
    }

    public Contact(String id, String name, String number, String email, String address, String city, String state, String zip, String bday) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.bday = bday;
    }

    public Contact(String name) {
        this.name = name;
    }
}
