package classes;

import java.util.ArrayList;

public class Patient extends Person {
    private String medicalHistory;
    private String allergies;
    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    public Patient(int id, String name, int age, String phoneNumber, String medicalHistory, String allergies) {
        super(id, name, age, phoneNumber);
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }


    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public void addMedications(Medication medication) {
        if (!medications.contains(medication)) {
            medications.add(medication);
            System.out.println(medication.getName() + " has been added to the medication list of " + getName());
        }else {
            System.out.println(medication.getName() + " is already on the medication list of " + getName());
        }
    }

    public void deleteMedication(Medication medication) {
        if (medications.remove(medication)) {
            System.out.println(medication.getName() + " has been removed from medication list of " + getName());
        }else {
            System.out.println(medication.getName() + " is not on the list of medications for " + getName());
        }
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        if (!prescriptions.contains(prescription)) {
            prescriptions.add(prescription);
            System.out.println("Prescription ID " + prescription.getPrescID() + " has been added to the prescription list of " + getName());
        }else {
            System.out.println(prescription.getPrescID() + " is already on the prescription list of " + getName());
        }
    }

    public void deletePrescription(Prescription prescription) {
        if (prescriptions.remove(prescription)) {
            System.out.println(prescription.getPrescID() + " has been removed from prescription list of " + getName());
        }else {
            System.out.println(prescription.getPrescID() + " is not on the list of prescriptions for " + getName());
        }
    }




    // The display
    public void displayInfo() {
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Allergies: " + allergies);
        if (medications.isEmpty()) {
            System.out.println("No medications on file.");
        }else {
            for (Medication medication:medications) {
                System.out.println(" - " + medication.getName() + " (ID: " + medication.getMedID() + ")");
            }
        }
    }

    public String toString() {
        return "ID: " + this.getId() + " Name: " + this.getName() + " Age: " + this.getAge() + " Phone Number: " + this.getPhoneNumber() + " Medical History: " + medicalHistory + " Allergies: " + allergies;
    }
}

