package models;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private String name, phone, cnic;

    public Person() {
        name = " ";
        phone = " ";
        cnic = " ";
    }

    public Person(String name, String phone, String cnic) {
        this.name = name;
        this.phone = phone;
        this.cnic = cnic;
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

    public String getCnic() {
        return this.cnic;
    }

    public void setCninc(String gender) {
        this.cnic = gender;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "  Phone: " + getPhone() + "  CNIC: " + getCnic() + "\n";
    }

}