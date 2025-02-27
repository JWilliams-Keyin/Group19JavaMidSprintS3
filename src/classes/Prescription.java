package classes;

/* Author: Jack Williams */
/* Date: February 26th */
/* Description: This class allows the user to enter new prescription objects.
 * Each prescription has an ID along with references to the doctor that issued it, the patient
 * it is for, the medication issued, and the expiry date of the prescription. */

import java.time.LocalDate;

public class Prescription {

    /* Attributes */

    private int prescID;
    private Patient Patient;
    private Doctor Doctor;
    private Medication Medication;
    private LocalDate prescExpiry;

    /* Constructors */

    /* Default */
    public Prescription() {
        this.prescID = 0;
        this.Doctor = new Doctor(0, "Bob Placeholder", 0, "00000000", "0", "n/a", 0);
        this.Patient = new Patient(0, "Pam Placeholder", 0, "00000000", "0", "none", "n/a");
        this.Medication = new Medication();
        this.prescExpiry = defaultDate();
    }

    /* Enter all except expiry */
    public Prescription(int prescID, Doctor Doctor, Patient Patient, Medication Medication) {
        this.prescID = prescID;
        this.Doctor = Doctor;
        this.Patient = Patient;
        this.Medication = Medication;
        this.prescExpiry = defaultDate();
    }

    /* Enter all including expiry */
    public Prescription(int prescID, Doctor Doctor, Patient Patient, Medication Medication, LocalDate prescExpiry) {
        this.prescID = prescID;
        this.Doctor = Doctor;
        this.Patient = Patient;
        this.Medication = Medication;
        this.prescExpiry = prescExpiry;
    }

    /* Getters & Setters */

    public Prescription getPrescription() {
        return new Prescription(this.prescID, this.Doctor, this.Patient, this.Medication, this.prescExpiry);
    }

    public int getPrescID() {
        return this.prescID;
    }

    public Doctor getDoctor() {
        return this.Doctor;
    }

    public Patient getPatient() {
        return this.Patient;
    }

    public Medication getMedication() {
        return this.Medication;
    }

    public LocalDate getPrescExpiry() {
        return this.prescExpiry;
    }

    public void setPrescID(int prescID) {
        this.prescID = prescID;
    }

    public void setDoctor(Doctor Doctor) {
        this.Doctor = Doctor;
    }

    public void setPatient(Patient Patient) {
        this.Patient = Patient;
    }

    public void setMedication(Medication Medication) {
        this.Medication = Medication;
    }

    public void setPrescExpiry(LocalDate prescExpiry) {
        this.prescExpiry = prescExpiry;
    }

    /* Methods */

    /* defaultDate Method*/
    public LocalDate defaultDate() {

        /* Get the current date */
        LocalDate currentDate = LocalDate.now();

        /* Add a year to the current date & return*/
        return currentDate.plusYears(1);
    }

    /* toString Method */
    public String toString() {
        return "ID: " + this.prescID + " Doctor: " + this.Doctor + " Patient: " + this.Patient + " Medication: " + this.Medication + " Prescription Expiry: " + this.prescExpiry;
    }
}
