# Group19JavaMidSprintS3
Repo for our Java midterm sprint

Overview

The MedicationSystem class serves as the primary coordinator for the Pharmacy Management System. It manages the relationships between patients, doctors, medications, and prescriptions, providing a centralized control point for all pharmacy operations.
Core Components
The system maintains four primary data collections:

Patient records
Doctor profiles
Medication inventory
Prescription history

Key Functionality
Search Capabilities
The system provides comprehensive search functionality:

Name-based searches:

searchPatientName(String name)
searchDoctorName(String name)
searchMedicationName(String name)


ID-based searches:

searchPatientId(int id)
searchDoctorId(int id)
searchMedicationId(int id)
searchPrescriptionId(int id)



Data Management Functions
Patient Management

Add new patients with validation to prevent duplicate IDs
Edit existing patient information including medical history and allergies
Remove patients from the system

Doctor Management

Add new doctors with specialty information
Update doctor profiles including specialization and experience
Remove doctors from the system

Medication Inventory

Add new medications to the pharmacy inventory
Update medication details including dosage, quantity, and expiry dates
Remove medications that are no longer carried

Doctor-Patient Relationship

addPatientToDoctorList(int patientId, int doctorId) - Associates patients with their treating physicians

Prescription Management

addNewPrescription(int doctorId, int patientId, int medicationId) - Creates a prescription record linking doctor, patient, and medication
prescriptionListByDoctor(int doctorId) - Generates reports of all prescriptions issued by a specific doctor

Inventory Management

checkExpiredMedications() - Identifies medications past their expiration date
restockMedications() - Automatically replenishes medication inventory when stock falls below 50% of target quantity

Reporting

systemReport() - Generates a comprehensive overview of all system data including patients, doctors, medications, and prescriptions
