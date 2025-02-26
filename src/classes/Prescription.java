package classes;

/* Author: Jack Williams */
/* Date: February 26th - February */
/* Description: This class allows the user to enter new prescription objects.
 * Each prescription has an ID along with references to the doctor that issued it, the patient
 * it is for, the medication issued, and the expiry date of the prescription. */

import java.util.Date;

public class Prescription {

    /* Attributes */

    private int prescID;
    private Patient Patient;
    private Doctor Doctor;
    private Medication Medication;
    private Date prescExpiry;

    /* Constructors */

    /* Default */
    public Prescription() {
        this.prescID = 0;
        this.Doctor = new Doctor("0", "Bob Placeholder", 0, "00000000", "0", "n/a", 0);
        this.Patient = new Patient("0", "Pam Placeholder", 0, "00000000", "0", "none", "n/a");
        this.Medication = new Medication();
        this.prescExpiry = new Date();
    }

    /* Enter all except expiry */
    public Prescription(int prescID, Doctor Doctor, Patient Patient, Medication Medication) {
        this.prescID = prescID;
        this.Doctor = Doctor;
        this.Patient = Patient;
        this.Medication = Medication;
        this.prescExpiry = new Date();
    }

    /* Enter all including expiry */
    public Prescription(int prescID, Doctor Doctor, Patient Patient, Medication Medication, Date prescExpiry) {
        this.prescID = prescID;
        this.Doctor = Doctor;
        this.Patient = Patient;
        this.Medication = Medication;
        this.prescExpiry = prescExpiry;
    }
}

