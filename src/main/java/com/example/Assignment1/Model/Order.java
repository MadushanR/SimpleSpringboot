package com.example.Assignment1.Model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class Order {
    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private String deliverytype;
    private String size;
    private String [] toppings;
    private int number;


    public Order() {
    }

    public Order( String firstname, String lastname, String phone, String address, String deliverytype, String size, String[] toppings, int number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.deliverytype = deliverytype;
        this.size = size;
        this.toppings = toppings;
        this.number = number;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliverytype() {
        return deliverytype;
    }

    public void setDeliverytype(String deliverytype) {
        this.deliverytype = deliverytype;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Order{" +
                " firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", deliverytype='" + deliverytype + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + Arrays.toString(toppings) +
                ", number=" + number +
                '}';
    }
    public double CalculateSizeTotal(){
        double stotal = 0;
        stotal = switch (getSize()) {
            case "small" -> stotal + 10;
            case "medium" -> stotal + 13;
            case "large" -> stotal + 17;
            default -> 0;
        };
        return stotal;
    }

    public double CalculateToppingsTotal(){
        double ttotal = 0;
        if (getToppings().length<3)
            ttotal = ttotal+getToppings().length;
        else
            ttotal=ttotal+3;
        return ttotal;
    }

    public double CalculateDeliveryTotal(){
        double dtotal = 0;
        if (Objects.equals(getDeliverytype(), "Delivery"))
            dtotal = dtotal+5;
        return dtotal;
    }
    public double CalculateTotal(){
        double total = 0;
        total = total+((CalculateSizeTotal()+ CalculateToppingsTotal()+CalculateDeliveryTotal())*number);
        return total;
    }
}
