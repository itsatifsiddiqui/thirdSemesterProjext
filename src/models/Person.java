package models;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private String name, phone, gender;

    public Person() {
        name = " ";
        phone = " ";
        gender = " ";
    }

    public Person(String name, String phone, String gender) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "  Phone: " + getPhone() + "  Geneder: " + getGender() + "\n";
    }

}