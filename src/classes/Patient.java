package classes;

public class Patient extends Person {
    private String patientId;
    private String medicalHistory;
    private String allergies;


    public Patient(String id, String name, int age, String phoneNumber, String patientId, String medicalHistory, String allergies) {
        super(id, name, age, phoneNumber);
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
    }


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

    // The display
    public void displayInfo() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Allergies: " + allergies);
    }
}

