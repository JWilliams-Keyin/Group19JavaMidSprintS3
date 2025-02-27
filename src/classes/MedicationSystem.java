/*
Description: MedicationSystem class is the coordinator for the Pharmacy Management
             System. It synthesizes data from patients, doctors, medications and
             prescriptions to provide the requested outputs.
Author: D.C. Elliott
Date: Feb 25-26, 2025
*/

package classes;

import java.util.ArrayList;
import java.time.LocalDate;


public class MedicationSystem {

//Attributes
    private ArrayList<Patient> patientList;
    private ArrayList<Doctor> doctorList;
    private ArrayList<Medication> medicationList;
    private ArrayList<Prescription> prescriptionList;

//Constructors
    public MedicationSystem() {
        this.patientList = new ArrayList<>();
        this.doctorList = new ArrayList<>();
        this.medicationList = new ArrayList<>();
        this.prescriptionList = new ArrayList<>();
    }

//Methods
// Search functions
// Search by name

    public Patient searchPatientName(String name) {
        for (Patient patient : patientList) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        System.out.println("Patient not found: " + name);
        return null;
    }

    public Doctor searchDoctorName(String name) {
        for (Doctor doctor : doctorList) {
            if (doctor.getname().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        System.out.println("Doctor not found: " + name);
        return null;
    }

    public Medication searchMedicationName(String name) {
        for (Medication medication : medicationList) {
            if (Medication.getName().equalsIgnoreCase(name)) {
                return medication;
            }
        }
        System.out.printLn("Medication not found: " + name);
        return null;
    }

//Search by ID

    public Patient searchPatientId(int id) {
        for (Patient patient : patientList) {
            if (patient.getId().equalsIgnoreCase(id)) {
                return patient;
            }
        }
        System.out.println("Patient not found: " + id);
        return null;
    }

    public Doctor searchDoctorId(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId().equalsIgnoreCase(id)) {
                return doctor;
            }
        }
        System.out.println("Doctor not found: " + id);
        return null;
    }

    public Medication searchMedicationId(int id) {
        for (Medication medication : medicationList) {
            if (Medication.getId().equalsIgnoreCase(id)) {
                return medication;
            }
        }
        System.out.printLn("Medication not found: " + id);
        return null;
    }

// Edit functions
// Add/Edit/Remove patient
    public boolean addPatient(Patient patient) {
        for (Patient existingPatient:patientList){
            if (existingPatient.getId().equals(patient.getId())) {
                System.out.println("Patient already exists with ID: " + patient.getId());
                return false;
            }
        }
        patientList.add(patient);
        System.out.printLn("Patient added successfully: " + patient.getName());
        return true;
    }

    public boolean editPatient(int id, String name, int age, String phoneNumber, String medicalHistory, String allergies) {
        Patient patient = searchPatientId(id);
        if (patient != null) {
            patient.setName(name);
            patient.setAge(age);
            patient.setPhoneNumber(phoneNumber);
            patient.setMedicalHistory(medicalHistory);
            patient.setAllegies(allergies);
           // patient.setMedications(medication);
           // patient.setPrescriptions(prescription);
            System.out.println("Patient information updated.");
            return true;
        }
        System.out.println("Patient not found.");
        return false;
    }

    public boolean deletePatient(int id) {
        Patient patient = searchPatientId(id);
        if (patient != null) {
            patientList.remove(patient);
            System.out.println("Patient deleted.");
            return true;
        }
        System.out.println("Patient not found for deletion.");
        return false;
    }

// Add/Edit/Remove doctor
    public boolean addDoctor(Doctor doctor) {
        for (Doctor existingDoctor:doctorList){
            if (existingDoctor.getId().equals(doctor.getId())) {
                System.out.println("Doctor already exists with ID: " + doctor.getId());
                return false;
            }
        }
        doctorList.add(doctor);
        System.out.printLn("Doctor added successfully: " + doctor.getName());
        return true;
    }

    public boolean editDoctor(int id, String name, int age, String phoneNumber, String specialization, int yearsOfExperience) {
        Doctor doctor = searchDoctorId(id);
        if (doctor != null) {
            doctor.setName(name);
            doctor.setAge(age);
            doctor.setPhoneNumber(phoneNumber);
            doctor.setSpecialization(specialization);
            doctor.setYearsOfExperience(yearsOfExperience);
            // doctor.setPatient(patients);
            System.out.println("Doctor information updated.");
            return true;
        }
        System.out.println("Doctor not found.");
        return false;
    }

    public boolean deleteDoctor(int id) {
        Doctor doctor = searchDoctorId(id);
        if (doctor != null) {
            doctorList.remove(doctor);
            System.out.println("Doctor deleted.");
            return true;
        }
        System.out.println("Doctor not found for deletion.");
        return false;
    }

// Add/Edit/Remove medication
    public boolean addMedication(Medication medication) {
        for (Medication existingMedication:medicationList){
            if (existingMedication.getId().equals(medication.getId())) {
                System.out.println("Medication already exists with ID: " + medication.getId());
                return false;
            }
        }
        medicationList.add(medication);
        System.out.printLn("Medication added successfully: " + medication.getName());
        return true;
    }

    public boolean editMedication(int id, String name, int dosage, int quantity, LocalDate medExpiry) {
        Medication medication =searchMedicationId(id);
        if (medication != null) {
            medication.setName(name);
            medication.setDosage(dosage);
            medication.setQuantity(quantity);
            medication.setMedExpiry(medExpiry);
            System.out.println("Medication information updated.");
            return true;
        }
        System.out.println("Medication not found.");
        return false;
    }

    public boolean deleteMedication(int id) {
        Medication medication =searchMedicationId(id);
        if (medication != null) {
            medicationList.remove(medication);
            System.out.println("Medication deleted.");
            return true;
        }
        System.out.println("Medication not found for deletion.");
        return false;
    }


//Add patient to doctors list

    public void addPatientToDoctorList(int patientId, int doctorId) {
        Patient patient = searchPatientId(patientId);
        Doctor doctor = searchDoctorId(doctorId);

        if (patient != null && doctor != null) {
            doctor.addPatient(patient);
            System.out.println(patient.getName() + "has been added to the patient list of Dr. " + doctor.getName());
        }else if (patient == null && doctor != null) {
            System.out.println("Patient not found.");
        }else if (patient != null && doctor == null){
            System.out.println("Doctor not found.");
        }else {
            System.out.println("Neither doctor or patient found.");
        }
    }
}


