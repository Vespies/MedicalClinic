package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Admin;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Secretary;

import static org.junit.Assert.*;

public class AdminServiceTest {

    private AdminService adminService;

    @Before
    public void setup() {
        adminService = new AdminService();
        DataBase.getInstance().getAdminList().clear();
        DataBase.getInstance().getAdminList().add(new Admin(1, "admin", "admin", "a4001", "admin", "admin", 20, "man"));

        DataBase.getInstance().getPatientList().clear();
        DataBase.getInstance().getPatientList().add(new Patient(1, "patient", "patient", "p1001", "patient", "patient", 20, "man"));

        DataBase.getInstance().getDoctorList().clear();
        DataBase.getInstance().getDoctorList().add(new Doctor(1, "doctor", "doctor", "d2001", "doctor", "doctor", 20, "man"));

        DataBase.getInstance().getSecretaryList().clear();
        DataBase.getInstance().getSecretaryList().add(new Secretary(1, "secretary", "secretary", "s3001", "secretary", "secretary", 20, "woman"));
    }

    @Test
    public void addPatientTrue() {
        assertTrue(adminService.addUser("patient", "patient", "patient", "patient", "patient", 20, "man", "Patient"));
    }

    @Test
    public void addPatientFalse() {
        assertFalse(adminService.addUser("patient", "patient", "patient", "patient", "patient", 20, "man", "patient"));
    }

    @Test
    public void addSecretaryTrue() {
        assertTrue(adminService.addUser("Secretary", "Secretary", "Secretary", "Secretary", "Secretary", 20, "woman", "Secretary"));
    }

    @Test
    public void addSecretaryFalse() {
        assertFalse(adminService.addUser("Secretary", "Secretary", "Secretary", "Secretary", "Secretary", 20, "woman", "secretary"));
    }

    @Test
    public void addDoctorTrue() {
        assertTrue(adminService.addUser("Doctor", "Doctor", "Doctor", "Doctor", "Doctor", 20, "man", "Doctor"));
    }

    @Test
    public void addDoctorFalse() {
        assertFalse(adminService.addUser("Doctor", "Doctor", "Doctor", "Doctor", "Doctor", 20, "man", "doctor"));
    }

    @Test
    public void addAdminTrue() {
        assertTrue(adminService.addUser("Admin", "Admin", "Admin", "Admin", "Admin", 20, "man", "Admin"));
    }

    @Test
    public void addAdminFalse() {
        assertFalse(adminService.addUser("Admin", "Admin", "Admin", "Admin", "Admin", 20, "man", "admin"));
    }

    @Test
    public void addTestFalse() {
        assertFalse(adminService.addUser("Test", "Test", "Test", "Test", "Test", 20, "man", "Test"));
    }

    @Test
    public void findAdminByIdNumberNotNull() {
        assertNotNull(adminService.findByIdNumber("a4001"));
    }

    @Test
    public void findAdminByIdNumberNull() {
        assertNull(adminService.findByIdNumber("a4002"));
    }

    @Test
    public void removePatientTrue() {
        assertTrue(adminService.removePatient(DataBase.getInstance().getPatientList().get(0)));
    }

    @Test
    public void removePatientFalse() {
        assertFalse(adminService.removePatient(null));
    }

    @Test
    public void removeSecretaryTrue() {
        assertTrue(adminService.removeSecretary(DataBase.getInstance().getSecretaryList().get(0)));
    }

    @Test
    public void removeSecretaryFalse() {
        assertFalse(adminService.removePatient(null));
    }

    @Test
    public void removeDoctorTrue() {
        assertTrue(adminService.removeDoctor(DataBase.getInstance().getDoctorList().get(0)));
    }

    @Test
    public void removeDoctorFalse() {
        assertFalse(adminService.removeDoctor(null));
    }

    @Test
    public void removeAdminTrue() {
        assertTrue(adminService.removeAdmin(DataBase.getInstance().getAdminList().get(0)));
    }

    @Test
    public void removeAdminFalse() {
        assertFalse(adminService.removeAdmin(null));
    }
}