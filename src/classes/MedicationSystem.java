/*
Description: MedicationSystem class is the coordinator for the Pharmacy Management
             System. It synthesizes data from patients, doctors, medications and
             prescriptions to provide the requested outputs.
Author: D.C. Elliott
Date: Feb 25-27, 2025
*/

package classes;

import javax.print.Doc;
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

//Getters

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public ArrayList<Medication> getMedicationList() {
        return medicationList;
    }

    public ArrayList<Prescription> getPrescriptionList() {
        return prescriptionList;
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
            if (doctor.getName().equalsIgnoreCase(name)) {
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
        System.out.println("Medication not found: " + name);
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
        System.out.println("Medication not found: " + id);
        return null;
    }

    public Prescription searchPrescriptionId(int id) {
        for (Prescription prescription : prescriptionList) {
            if (Prescription.getId().equalsIgnoreCase(id)) {
                return prescription;
            }
        }
        System.out.println("Prescription not found: " + id);
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
        System.out.println("Patient added successfully: " + patient.getName());
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
        System.out.println("Doctor added successfully: " + doctor.getName());
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

// Add a prescription

    public void addNewPrescription(int doctorId, int patientId, int medicationId) {
        Doctor doctor = searchDoctorId(doctorId);
        Patient patient = searchPatientId(patientId);
        Medication medication = searchMedicationId(medicationId);

        if (doctor != void && patient != void && medication != void) {
            int newId = prescriptionList.size()+1;
            Prescription prescription = new Prescription(newId, doctor, patient, medication);

            prescriptionList.add(prescription);
            patient.addPrescription(prescription);
            System.out.println("New prescription created and added.")
        }
        System.out.println("New Prescription not added, check inputs.");
    }


// Find all prescriptions issued by a specific doctor.

    public void prescriptionListByDoctor(String doctorId) {
        Doctor doctor = searchDoctorId(doctorId);

        if (doctor != null) {
            System.out.println("PRESCRIPTIONS ISSUED BY DR. " + doctor.getName() + ":");

            boolean found = false;
            for ( Prescription prescription:prescriptionList) {
                if (prescription.getDoctor().getId().equals(doctorId)) {
                    System.out.println(prescription.toString());
                    found = true;
                }
            }
            if (found == false) {
                System.out.println("No prescriptions issued by Dr. " + doctor.getName());
            }
            System.out.println("END OF REPORT");
        }System.out.println("Doctor not found with ID: " + doctorId);
    }

//Check for expired medications

    public void checkExpiredMedications() {
        System.out.println("EXPIRED MEDICATIONS REPORT");
        LocalDate currentDate = LocalDate.now();
        boolean expiredMed = false;

        for (Medication medication:medicationList) {
            if (medication.getMedExpiry.before(currentDate)) {
                System.out.println("EXPIRED: " + medication.toString());
                expiredMed = true;
            }
        }
        if (expiredMed == false) {
            System.out.println("NO EXPIRED MEDICATIONS FOUND.");
        }
        System.out.println("\n END OF REPORT");
    }

// Restock Medication Inventory

    public void restockMedications() {
        for (Medication medication:medicationList) {
            int currentQuantity = medication.getQuantity();
            int targetStock = medication.getTargetQuantity();
            if (targetStock-currentQuantity<0.5*targetStock) {
                medication.setQuanity = targetStock;
                System.out.println(medication.getName() + " restocked with additional " + targetStock-currentQuantity + " units.");
            } System.out.println(medication.getName() + " was not restocked at this time.");
        }
    }


//System Report

    public void systemReport() {
        System.out.println("PHARMACY MANAGEMENT SYSTEM REPORT \n");

        System.out.println("PATIENT LIST: \n");
        for (Patient patient:patientList) {
            System.out.println(patient.toString());
        }

        System.out.println("\n DOCTOR LIST: \n");
        for (Doctor doctor:doctorList) {
            System.out.println(doctor.toString());
        }

        System.out.println("\n MEDICATION LIST: \n");
        for (Medication medication:medicationList){
            System.out.println(medication.toString());
        }

        System.out.println("\n PRESCRIPTION LIST: \n");
        for (Prescription prescription:prescriptionList) {
            System.out.println(prescription.toString());
    }
    }



}


