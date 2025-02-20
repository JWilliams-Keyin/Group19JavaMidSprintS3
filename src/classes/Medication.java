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
        this.expiry = new Date();
    }

    /* Input With Random Date*/
    public Medication(int ID, String name, int dosage, int quantity) {
        this.ID = ID;
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.expiry = new Date();
    }

    /* Input All */
    public Medication(int ID, String name, int dosage, int quantity, Date expiry) {
        this.ID = ID;
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.expiry = expiry;
    }
}
