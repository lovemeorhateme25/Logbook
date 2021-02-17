package com.example.fillup;

public class Visitors {
    private String id,name,age,contact,address,date,time;

    public Visitors() {
    }

    public Visitors(String id, String name, String age, String contact, String address, String date, String time) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
        this.date = date;
        this.time = time;
    }
    public  String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public  String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public  String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public  String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public  String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public  String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
