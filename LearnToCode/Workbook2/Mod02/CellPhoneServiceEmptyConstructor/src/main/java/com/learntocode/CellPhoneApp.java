package com.learntocode;

public class CellPhoneApp {
    public static void main(String[] args) {
        CellPhone cellPhone1 = new CellPhone(1234567, "iPhone X", "AT&T", "800-555-5555", "Dana Wyatt");
        CellPhone cellPhone2 = new CellPhone(2345678, "Samsung Galaxy S21", "Verizon", "855-555-2222", "John Smith");

        display(cellPhone1);
        display(cellPhone2);

        cellPhone1.dial(cellPhone2.getPhoneNumber());
        cellPhone2.dial(cellPhone1.getPhoneNumber());

        // Instantiate a new cell phone with the constructor that has no parameters
        CellPhone newPhone = new CellPhone();
        newPhone.setSerialNumber(9999999);
        newPhone.setModel("Google Pixel 5");
        newPhone.setCarrier("T-Mobile");
        newPhone.setPhoneNumber("555-555-5555");
        newPhone.setOwner("Jane Smith");

        display(newPhone);
        cellPhone1.dial(newPhone);
    }

    public static void display(CellPhone phone) {
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
    }
}
