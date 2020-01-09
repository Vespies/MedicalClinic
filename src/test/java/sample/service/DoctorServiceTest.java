package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Doctor;

import static org.junit.Assert.*;

public class DoctorServiceTest {

    private DoctorService doctorService;

    @Before
    public void setup() {
        doctorService = new DoctorService();
        DataBase.getInstance().getDoctorList().clear();
        DataBase.getInstance().getDoctorList().add(new Doctor(1, "doctor", "doctor", "d2001", "doctor", "doctor", 20, "man"));
    }

    @Test
    public void findByIdNumberNotNull() {
        assertNotNull(doctorService.findByIdNumber("d2001"));
    }

    @Test
    public void findByIdNumberNull() {
        assertNull(doctorService.findByIdNumber("d2002"));
    }

    @Test
    public void findByIdNotNull() {
        assertNotNull(doctorService.findById(1));
    }

    @Test
    public void findByIdNull() {
        assertNull(doctorService.findById(2));
    }

    @Test
    public void generateIdEquals() {
        assertEquals(2, doctorService.generateDoctorId());
    }

    @Test
    public void generateIdNotEquals() {
        assertNotEquals(1, doctorService.generateDoctorId());
    }
}