package classes;

/* Author: Jack Williams */
/* Date: February 20th - February 27th */
/* Description: This class allows the user to enter new medication objects.
* Each medication has a unique ID, name, dosage amount, quantity in stock, and expiry date. */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medication {

    /* Attributes */

    private int medID;
    private String name;
    private int dosage;
    private int quantity;
    private LocalDate medExpiry;

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
    public Medication(int medID, String name, int dosage, int quantity, LocalDate medExpiry) {
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

    public int getMedID() {
        return this.medID;
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

    public LocalDate getMedExpiry() {
        return this.medExpiry;
    }

    public void setMedID(int medID) {
        this.medID = medID;
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

    public void setMedExpiry(LocalDate medExpiry) {
        this.medExpiry = medExpiry;
    }

    /* Methods */

    /* Random Date */
    public LocalDate randomDate() {
        /* Define the range of years (2015 - 2035) */
        LocalDate startDate = LocalDate.of(2015, 1, 1);
        LocalDate endDate = LocalDate.of(2035, 12, 31);

        /* Convert dates to epoch days */
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        /* Generate a random epoch day */
        long randomEpochDay = startEpochDay + (long) ((endEpochDay - startEpochDay + 1) * Math.random());

        /* Convert back to LocalDate and return */
        return LocalDate.ofEpochDay(randomEpochDay);
    }

    /* Input Date Method */
    /* This method is needed when calling the last constructor, as this is the only way to input a LocalDate value */
    public LocalDate inputDate(String newDate) {
        /* Create formatter to make the input follow yyyy/MM/dd format*/
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        /* Parse the desired date (newDate), format it to a LocalDate value & return */
        return LocalDate.parse(newDate, dateFormat);
    }

    /* toString Method*/
    public String toString() {
        return "ID: " + this.medID + " Name: " + this.name + " Dosage: " + this.dosage + " Quantity: " + this.quantity + " Expiry Date: " + this.medExpiry;
    }
}
