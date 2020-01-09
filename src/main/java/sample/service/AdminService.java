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

    // looking for an admin based on idNumber
    public Admin findByIdNumber(String idNumber) {
        for (Admin element : DataBase.getInstance().getAdminList()) {
            if (element.getIdNumber().equals(idNumber)) return element;
        }
        return null;
    }

    // generating new id for an admin
    public int generateAdminId() {
        return DataBase.getInstance().getAdminList().size() + 1;
    }

    // adding new admin
    public boolean addUser(String firstName, String lastName, String idNUmber, String password, String address, int age, String sex, String role) {
        switch (role) {
            case "Patient":
                Patient patient = new Patient(patientService.generatePatientId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getPatientList().add(patient);
                return true;
            case "Secretary":
                Secretary secretary = new Secretary(secretaryService.generateSecretaryId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getSecretaryList().add(secretary);
                return true;
            case "Doctor":
                Doctor doctor = new Doctor(doctorService.generateDoctorId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getDoctorList().add(doctor);
                return true;
            case "Admin":
                Admin admin = new Admin(generateAdminId(), firstName, lastName, idNUmber, password, address, age, sex);
                DataBase.getInstance().getAdminList().add(admin);
                return true;
        }
        return false;
    }

    // removing a patient
    public boolean removePatient(Patient patient) {
        if (patient != null) {
            DataBase.getInstance().getPatientList().remove(patient);

            for (int i = 0; i < DataBase.getInstance().getPatientList().size(); i++) {
                DataBase.getInstance().getPatientList().get(i).setId(i + 1);
            }

            return true;
        }
        return false;
    }

    // remocing a secretary
    public boolean removeSecretary(Secretary secretary) {
        if (secretary != null) {
            DataBase.getInstance().getSecretaryList().remove(secretary);

            for (int i = 0; i < DataBase.getInstance().getSecretaryList().size(); i++) {
                DataBase.getInstance().getSecretaryList().get(i).setId(i + 1);
            }

            return true;
        }
        return false;
    }

    // removing a doctor
    public boolean removeDoctor(Doctor doctor) {
        if (doctor != null) {
            DataBase.getInstance().getDoctorList().remove(doctor);

            for (int i = 0; i < DataBase.getInstance().getDoctorList().size(); i++) {
                DataBase.getInstance().getDoctorList().get(i).setId(i + 1);
            }

            return true;
        }
        return false;
    }

    // removing an admin
    public boolean removeAdmin(Admin admin) {
        if (admin != null) {

            DataBase.getInstance().getAdminList().remove(admin);
            for (int i = 0; i < DataBase.getInstance().getAdminList().size(); i++) {
                DataBase.getInstance().getAdminList().get(i).setId(i + 1);
            }

            return true;
        }
        return false;
    }
}
