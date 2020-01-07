package sample.service;

import sample.db.DataBase;
import sample.model.Admin;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Secretary;

public class AdminService {

    private PatientService patientService = new PatientService();
    private SecretaryService secretaryService = new SecretaryService();
    private DoctorService doctorService = new DoctorService();

    public Admin findByIdNumber(String idNumber) {
        for (Admin element : DataBase.getInstance().getAdminList()) {
            if (element.getIdNumber().equals(idNumber)) return element;
        }
        return null;
    }

    public int generateAdminId() {
        return DataBase.getInstance().getAdminList().size() + 1;
    }

    public void addUser(String firstName, String lastName, String idNUmber, String password, String address, int age, String sex, String role) {
        switch (role) {
            case "Patient":
                Patient patient = new Patient(patientService.generatePatientId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getPatientList().add(patient);
                break;
            case "Secretary":
                Secretary secretary = new Secretary(secretaryService.generateSecretaryId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getSecretaryList().add(secretary);
                break;
            case "Doctor":
                Doctor doctor = new Doctor(doctorService.generateDoctorId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getDoctorList().add(doctor);
                break;
            case "Admin":
                Admin admin = new Admin(generateAdminId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getAdminList().add(admin);
                break;
        }
    }
}
