package com.learntocode;

public class CellPhoneApp {
    public static void main(String[] args) {
        CellPhone myPhone = new CellPhone(1234567, "iPhone X", "AT&T", "800-555-5555", "Dana Wyatt");

        System.out.println("Serial Number: " + myPhone.getSerialNumber());
        System.out.println("Model: " + myPhone.getModel());
        System.out.println("Carrier: " + myPhone.getCarrier());
        System.out.println("Phone Number: " + myPhone.getPhoneNumber());
        System.out.println("Owner: " + myPhone.getOwner());
        
    }
}
