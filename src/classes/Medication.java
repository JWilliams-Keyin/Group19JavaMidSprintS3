package classes;

/* Author: Jack Williams */
/* Date: February 20th - February 25th */
/* Description: This class allows the user to enter new medication objects.
* Each medication has a unique ID, name, dosage amount, quantity in stock, and expiry date. */

import java.util.Date;

public class Medication {

    /* Attributes */

    private int medID;
    private String name;
    private int dosage;
    private int quantity;
    private Date medExpiry;

    /* Constructors */

    /* Default */
    public Medication() {
        this.medID = 0;
        this.name = "n/a";
        this.dosage = 1;
        this.quantity = 1;
        this.medExpiry = randomDate();
    }

    /* Input With Random Date*/
    public Medication(int medID, String name, int dosage, int quantity) {
        this.medID = medID;
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.medExpiry = randomDate();
    }

    /* Input All */
    public Medication(int medID, String name, int dosage, int quantity, Date medExpiry) {
        this.medID = medID;
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.medExpiry = medExpiry;
    }

    /* Getters & Setters */

    public Medication getMedication() {
        return new Medication(this.medID, this.name, this.dosage, this.quantity, this.medExpiry);
    }

    public String getName() {
        return this.name;
    }

    public int getDosage() {
        return this.dosage;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Date getMedExpiry() {
        return this.medExpiry;
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

    public void setMedExpiry(Date medExpiry) {
        this.medExpiry = medExpiry;
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
        return "ID: " + this.medID + " Name: " + this.name + " Dosage: " + this.dosage + " Quantity: " + this.quantity + " Expiry Date: " + this.medExpiry;
    }
}
