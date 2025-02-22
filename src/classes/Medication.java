package classes;

/* Author: Jack Williams */
/* Date: February 20th - February */
/* Description: This class allows the user to enter new medication objects.
* Each medication has a unique ID, name, dosage amount, quantity in stock, and expiry date. */

import java.util.Date;

public class Medication {

    /* Attributes */

    private int ID;
    private String name;
    private int dosage;
    private int quantity;
    private Date expiry;

    /* Constructors */

    /* Default */
    public Medication() {
        this.ID = 0;
        this.name = "n/a";
        this.dosage = 1;
        this.quantity = 1;
        this.expiry = randomDate();
    }

    /* Input With Random Date*/
    public Medication(int ID, String name, int dosage, int quantity) {
        this.ID = ID;
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.expiry = randomDate();
    }

    /* Input All */
    public Medication(int ID, String name, int dosage, int quantity, Date expiry) {
        this.ID = ID;
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.expiry = expiry;
    }

        /* Getters & Setters */

    public Medication getMedication() {
        return new Medication(this.ID, this.name, this.dosage, this.quantity, this.expiry);
    }

    public void setMedName(String name) {
        this.name = name;
    }

    public void setMedDosage(int dosage) {
        this.dosage = dosage;
    }

    public void setMedQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMedExpiry(Date expiry) {
        this.expiry = expiry;
    }

    /* Methods */

        /* Random Date */
    public Date randomDate() {
        /* Define the range of years (2015 to 2030) */
        long startMillis = new Date(115, 0, 1).getTime();
        long endMillis = new Date(130, 11, 31).getTime();

        /* Generate a random timestamp in milliseconds */
        long randomMillis = startMillis + (long) ((endMillis - startMillis) * Math.random());

        /* Convert milliseconds to a Date object & return */
        return new Date(randomMillis);
    }

    /* toString Method*/
    public String toString() {
        return "ID: " + this.ID + " Name: " + this.name + " Dosage: " + this.dosage + " Quantity: " + this.quantity + " Expiry Date: " + this.expiry;
    }
}
