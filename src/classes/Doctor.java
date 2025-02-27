package classes;

import java.util.ArrayList;

public class Doctor extends Person {
    private String specialization;
    private int yearsOfExperience;
    private ArrayList<Patient> patients;


    public Doctor(int id, String name, int age, String phoneNumber, String doctorId, String specialization, int yearsOfExperience) {
        super(id, name, age, phoneNumber); // Calls Person constructor
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.patients = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            System.out.println(patient.getName() + " has been added to Dr. " + getName());
        }else {
            System.out.println(patient.getName() + " is already a patient of Dr. " + getName());
        }
    }

    public void deletePatient(Patient patient) {
        if (patients.remove(patient)) {
            System.out.println(patient.getName() + " has been removed from the patient list of Dr. " + getName());
        }else {
            System.out.println(patient.getName() + " is not a patient of Dr. " + getName());
        }
    }

    // Display
    public void displayInfo() {
        System.out.println("Doctor ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Specialization: " + specialization);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Assigned Patients:");
        if (patients.isEmpty()) {
            System.out.println("No patients assigned.");
        }else {
            for (Patient patient:patients) {
                System.out.println(" - " + patient.getName() + " (ID: " + patient.getId() + ")");
            }
        }
    }
}

