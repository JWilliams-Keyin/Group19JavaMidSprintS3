package classes;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private int yearsOfExperience;


    public Doctor(String id, String name, int age, String phoneNumber, String doctorId, String specialization, int yearsOfExperience) {
        super(id, name, age, phoneNumber); // Calls Person constructor
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }


    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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

    // Display
    public void displayInfo() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Specialization: " + specialization);
        System.out.println("Years of Experience: " + yearsOfExperience);
    }
}

