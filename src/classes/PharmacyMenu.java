/*
Description: MedicationSystem class is the coordinator for the Pharmacy Management
             System. It synthesizes data from patients, doctors, medications and
             prescriptions to provide the requested outputs.
Author: D.C. Elliott
Date: Feb 25-, 2025
*/


package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PharmacyMenu {
    public static void main(String[] args) {
        MedicationSystem system = new MedicationSystem();
        initializeData(system); // Creates sample data for testing,see method at bottom.

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("\n=====Welcome To The Pharmacy Management System=====");
            System.out.println("What would you like to do? ");
            System.out.println("1: Add a New Patient");
            System.out.println("2: Add a New Doctor");
            System.out.println("3: Add a New Medication");
            System.out.println("4: Edit Patient Information");
            System.out.println("5: Edit Doctor Information");
            System.out.println("6: Edit Medication Information");
            System.out.println("7: Delete Patient");
            System.out.println("8: Delete Doctor");
            System.out.println("9: Delete Medication");
            System.out.println("10: Search for Patient");
            System.out.println("11: Search for Doctor");
            System.out.println("12: Search for Medication");
            System.out.println("13: Add Patient to Doctor");
            System.out.println("14: Create New Prescription");
            System.out.println("15: View Prescriptions by Doctor");
            System.out.println("16: Check for Expired Medications");
            System.out.println("17: Restock Medications");
            System.out.println("18: Generate System Report");
            System.out.println("19: Exit");

            System.out.print("Enter your choice: ");
            int option = getIntInput(scanner);

            switch (option) {
                case 1:
                    addNewPatient(scanner, system);
                    break;
                case 2:
                    addNewDoctor(scanner, system);
                    break;
                case 3:
                    addNewMedication(scanner, system);
                    break;
                case 4:
                    editPatient(scanner, system);
                    break;
                case 5:
                    editDoctor(scanner, system);
                    break;
                case 6:
                    editMedication(scanner, system);
                    break;
                case 7:
                    deletePatient(scanner, system);
                    break;
                case 8:
                    deleteDoctor(scanner, system);
                    break;
                case 9:
                    deleteMedication(scanner, system);
                    break;
                case 10:
                    searchPatient(scanner, system);
                    break;
                case 11:
                    searchDoctor(scanner, system);
                    break;
                case 12:
                    searchMedication(scanner, system);
                    break;
                case 13:
                    addPatientToDoctor(scanner, system);
                    break;
                case 14:
                    createNewPrescription(scanner, system);
                    break;
                case 15:
                    viewPrescriptionsByDoctor(scanner, system);
                    break;
                case 16:
                    checkExpiredMedications(system);
                    break;
                case 17:
                    restockMedications(system);
                    break;
                case 18:
                    generateSystemReport(system);
                    break;
                case 19:
                    exit = true;
                    System.out.println("Exiting the Pharmacy Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Check for valid input
    private static int getIntInput(Scanner scanner) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }

        return input;
    }

    // 1: Add a Patient
    private static void addNewPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Add New Patient =====");

        System.out.print("Enter Patient ID: ");
        int id = getIntInput(scanner);

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = getIntInput(scanner);

        System.out.print("Enter Patient Phone Number (XXX-XXX-XXXX): ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Patient Medical History: ");
        String medicalHistory = scanner.nextLine();

        System.out.print("Enter Patient Allergies: ");
        String allergies = scanner.nextLine();

        Patient patient = new Patient(id, name, age, phoneNumber, medicalHistory, allergies);

        if (system.addPatient(patient)) {
            System.out.println("Patient " + patient.getName() + " added successfully!");
        } else {
            System.out.println("Failed to add patient. ID may already exist.");
        }
    }

    // 2: Add a Doctor
    private static void addNewDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Add New Doctor =====");

        System.out.print("Enter Doctor ID: ");
        int id = getIntInput(scanner);

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Doctor Age: ");
        int age = getIntInput(scanner);

        System.out.print("Enter Doctor Phone Number (XXX-XXX-XXXX): ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Doctor Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Years of Experience: ");
        int yearsOfExperience = getIntInput(scanner);

        Doctor doctor = new Doctor(id, name, age, phoneNumber, specialization, yearsOfExperience);

        if (system.addDoctor(doctor)) {
            System.out.println("Doctor " + doctor.getName() + " added successfully!");
        } else {
            System.out.println("Failed to add doctor. ID may already exist.");
        }
    }

    // 3: Add a Medication
    private static void addNewMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Add New Medication =====");

        System.out.print("Enter Medication ID: ");
        int id = getIntInput(scanner);

        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Dosage (mg): ");
        int dosage = getIntInput(scanner);

        System.out.print("Enter Quantity in Stock: ");
        int quantity = getIntInput(scanner);

        System.out.print("Enter Inventory Target Quantity: ");
        int targetQuantity = getIntInput(scanner);

        System.out.print("Would you like to set a specific expiry date? (y/n): ");
        String response = scanner.nextLine().toLowerCase();

        Medication medication;
        if (response.equals("y")) {
            System.out.print("Enter Expiry Date (yyyy/MM/dd): ");
            String dateString = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate expiryDate = LocalDate.parse(dateString, formatter);
                medication = new Medication(id, name, dosage, quantity, targetQuantity, expiryDate);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Using random date instead.");
                medication = new Medication(id, name, dosage, quantity, targetQuantity);
            }
        } else {
            medication = new Medication(id, name, dosage, quantity, targetQuantity);
        }

        if (system.addMedication(medication)) {
            System.out.println("Medication " + medication.getName() + " added successfully!");
        } else {
            System.out.println("Failed to add medication. ID may already exist.");
        }
    }

    // 4: Edit Patient Info
    private static void editPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Edit Patient Information =====");

        System.out.print("Enter Patient ID to edit: ");
        int id = getIntInput(scanner);

        Patient patient = system.searchPatientId(id);

        if (patient != null) {
            System.out.println("Current information: " + patient.toString());

            System.out.print("Enter new Name (or press enter to keep current): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) name = patient.getName();

            System.out.print("Enter new Age (or 0 to keep current): ");
            int age = getIntInput(scanner);
            if (age == 0) age = patient.getAge();

            System.out.print("Enter new Phone Number (or press enter to keep current): ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) phoneNumber = patient.getPhoneNumber();

            System.out.print("Enter new Medical History (or press enter to keep current): ");
            String medicalHistory = scanner.nextLine();
            if (medicalHistory.isEmpty()) medicalHistory = patient.getMedicalHistory();

            System.out.print("Enter new Allergies (or press enter to keep current): ");
            String allergies = scanner.nextLine();
            if (allergies.isEmpty()) allergies = patient.getAllergies();

            if (system.editPatient(id, name, age, phoneNumber, medicalHistory, allergies)) {
                System.out.println("Patient information updated successfully!");
            } else {
                System.out.println("Failed to update patient information.");
            }
        } else {
            System.out.println("Patient not found with ID: " + id);
        }
    }

    // 5: Edit Doctor Info
    private static void editDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Edit Doctor Information =====");

        System.out.print("Enter Doctor ID to edit: ");
        int id = getIntInput(scanner);

        Doctor doctor = system.searchDoctorId(id);

        if (doctor != null) {
            System.out.println("Current information: " + doctor.toString());

            System.out.print("Enter new Name (or press enter to keep current): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) name = doctor.getName();

            System.out.print("Enter new Age (or 0 to keep current): ");
            int age = getIntInput(scanner);
            if (age == 0) age = doctor.getAge();

            System.out.print("Enter new Phone Number (or press enter to keep current): ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) phoneNumber = doctor.getPhoneNumber();

            System.out.print("Enter new Specialization (or press enter to keep current): ");
            String specialization = scanner.nextLine();
            if (specialization.isEmpty()) specialization = doctor.getSpecialization();

            System.out.print("Enter new Years of Experience (or 0 to keep current): ");
            int yearsOfExperience = getIntInput(scanner);
            if (yearsOfExperience == 0) yearsOfExperience = doctor.getYearsOfExperience();

            if (system.editDoctor(id, name, age, phoneNumber, specialization, yearsOfExperience)) {
                System.out.println("Doctor information updated successfully!");
            } else {
                System.out.println("Failed to update doctor information.");
            }
        } else {
            System.out.println("Doctor not found with ID: " + id);
        }
    }

    // 6: Edit Medication Info
    private static void editMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Edit Medication Information =====");

        System.out.print("Enter Medication ID to edit: ");
        int id = getIntInput(scanner);

        Medication medication = system.searchMedicationId(id);

        if (medication != null) {
            System.out.println("Current information: " + medication.toString());

            System.out.print("Enter new Name (or press enter to keep current): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) name = medication.getName();

            System.out.print("Enter new Dosage (or 0 to keep current): ");
            int dosage = getIntInput(scanner);
            if (dosage == 0) dosage = medication.getDosage();

            System.out.print("Enter new Quantity (or 0 to keep current): ");
            int quantity = getIntInput(scanner);
            if (quantity == 0) quantity = medication.getQuantity();

            LocalDate expiryDate = medication.getMedExpiry();
            System.out.print("Would you like to update the expiry date? (y/n): ");
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("y")) {
                System.out.print("Enter new Expiry Date (yyyy/MM/dd): ");
                String dateString = scanner.nextLine();

                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    expiryDate = LocalDate.parse(dateString, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Keeping current expiry date.");
                }
            }

            if (system.editMedication(id, name, dosage, quantity, expiryDate)) {
                System.out.println("Medication information updated successfully!");
            } else {
                System.out.println("Failed to update medication information.");
            }
        } else {
            System.out.println("Medication not found with ID: " + id);
        }
    }

    // 7: Delete Patient
    private static void deletePatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Delete Patient =====");

        System.out.print("Enter Patient ID to delete: ");
        int id = getIntInput(scanner);

        if (system.deletePatient(id)) {
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Failed to delete patient. Patient may not exist.");
        }
    }

    // 8: Delete Doctor
    private static void deleteDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Delete Doctor =====");

        System.out.print("Enter Doctor ID to delete: ");
        int id = getIntInput(scanner);

        if (system.deleteDoctor(id)) {
            System.out.println("Doctor deleted successfully!");
        } else {
            System.out.println("Failed to delete doctor. Doctor may not exist.");
        }
    }

    // 9: Delete Medication
    private static void deleteMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Delete Medication =====");

        System.out.print("Enter Medication ID to delete: ");
        int id = getIntInput(scanner);

        if (system.deleteMedication(id)) {
            System.out.println("Medication deleted successfully!");
        } else {
            System.out.println("Failed to delete medication. Medication may not exist.");
        }
    }

    // 10: Search for Patient
    private static void searchPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Search for Patient =====");
        System.out.println("1: Search by ID");
        System.out.println("2: Search by Name");
        System.out.print("Enter your choice: ");
        int choice = getIntInput(scanner);

        if (choice == 1) {
            System.out.print("Enter Patient ID: ");
            int id = getIntInput(scanner);
            Patient patient = system.searchPatientId(id);

            if (patient != null) {
                System.out.println("Patient found:");
                patient.displayInfo();
            }
        } else if (choice == 2) {
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();
            Patient patient = system.searchPatientName(name);

            if (patient != null) {
                System.out.println("Patient found:");
                patient.displayInfo();
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // 11: Search for Doctor
    private static void searchDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Search for Doctor =====");
        System.out.println("1: Search by ID");
        System.out.println("2: Search by Name");
        System.out.print("Enter your choice: ");
        int choice = getIntInput(scanner);

        if (choice == 1) {
            System.out.print("Enter Doctor ID: ");
            int id = getIntInput(scanner);
            Doctor doctor = system.searchDoctorId(id);

            if (doctor != null) {
                System.out.println("Doctor found:");
                doctor.displayInfo();
            }
        } else if (choice == 2) {
            System.out.print("Enter Doctor Name: ");
            String name = scanner.nextLine();
            Doctor doctor = system.searchDoctorName(name);

            if (doctor != null) {
                System.out.println("Doctor found:");
                doctor.displayInfo();
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // 12: Search for Medication
    private static void searchMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Search for Medication =====");
        System.out.println("1: Search by ID");
        System.out.println("2: Search by Name");
        System.out.print("Enter your choice: ");
        int choice = getIntInput(scanner);

        if (choice == 1) {
            System.out.print("Enter Medication ID: ");
            int id = getIntInput(scanner);
            Medication medication = system.searchMedicationId(id);

            if (medication != null) {
                System.out.println("Medication found: " + medication.toString());
            }
        } else if (choice == 2) {
            System.out.print("Enter Medication Name: ");
            String name = scanner.nextLine();
            Medication medication = system.searchMedicationName(name);

            if (medication != null) {
                System.out.println("Medication found: " + medication.toString());
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // 13: Add Patient to Doctor
    private static void addPatientToDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Add Patient to Doctor =====");

        System.out.print("Enter Patient ID: ");
        int patientId = getIntInput(scanner);

        System.out.print("Enter Doctor ID: ");
        int doctorId = getIntInput(scanner);

        system.addPatientToDoctorList(patientId, doctorId);
    }

    // 14: Create Prescription
    private static void createNewPrescription(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== Create New Prescription =====");

        System.out.print("Enter Doctor ID: ");
        int doctorId = getIntInput(scanner);

        System.out.print("Enter Patient ID: ");
        int patientId = getIntInput(scanner);

        System.out.print("Enter Medication ID: ");
        int medicationId = getIntInput(scanner);

        system.addNewPrescription(doctorId, patientId, medicationId);
    }

    // 15: View Prescriptions by Doctor
    private static void viewPrescriptionsByDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n===== View Prescriptions by Doctor =====");

        System.out.print("Enter Doctor ID: ");
        int doctorId = getIntInput(scanner);

        system.prescriptionListByDoctor(doctorId);
    }

    // 16: Check for Expired Medications
    private static void checkExpiredMedications(MedicationSystem system) {
        System.out.println("\n===== Check for Expired Medications =====");
        system.checkExpiredMedications();
    }

    // 17: Restock Medications
    private static void restockMedications(MedicationSystem system) {
        System.out.println("\n===== Restock Medications =====");
        system.restockMedications();
    }

    // 18: Generate System Report
    private static void generateSystemReport(MedicationSystem system) {
        System.out.println("\n===== Generating System Report =====");
        system.systemReport();
    }

    // Initialize some sample data for testing
    private static void initializeData(MedicationSystem system) {
        // Add sample patients
        Patient patient1 = new Patient(1, "James Brown", 45, "123-456-7890", "Hypertension",  "Penicillin");
        Patient patient2 = new Patient(2, "Diana Ross", 32, "321-654-0987", "Diabetes Type 2", "Sulfa drugs");

        // Add sample doctors
        Doctor doctor1 = new Doctor(3, "David Livingston", 52, "123-111-2222", "Cardiology",  20);
        Doctor doctor2 = new Doctor(4, "Sherlock Holmes", 38, "123-333-4444", "Endocrinology",  10);

        // Add sample medications
        Medication med1 = new Medication(1, "Lisinopril", 10, 100, 150);
        Medication med2 = new Medication(2, "Metformin", 15, 45, 100);

        // Add entities to system
        system.addPatient(patient1);
        system.addPatient(patient2);
        system.addDoctor(doctor1);
        system.addDoctor(doctor2);
        system.addMedication(med1);
        system.addMedication(med2);

        // Create relationships
        system.addPatientToDoctorList(1, 3);
        system.addPatientToDoctorList(2, 4);

        // Create prescriptions
        system.addNewPrescription(3, 1, 1);
        system.addNewPrescription(4, 2, 2);

        System.out.println("Sample data initialized for testing purposes.");
    }
}