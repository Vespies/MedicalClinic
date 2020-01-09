package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Patient;

import static org.junit.Assert.*;

public class PatientServiceTest {

    private PatientService patientService;

    @Before
    public void setup() {
        patientService = new PatientService();

        DataBase.getInstance().getPatientList().clear();
        DataBase.getInstance().getPatientList().add(new Patient(1, "patient", "patient", "p1001", "ppp", "patient", 20, "man"));
    }

    @Test
    public void findByIdNotNull(){
        assertNotNull(patientService.findById(1));
    }

    @Test
    public void findByIdNull(){
        assertNull(patientService.findById(null));
    }

    @Test
    public void findByIdNumberNotNull(){
        assertNotNull(patientService.findByIdNumber("p1001"));
    }

    @Test
    public void findByIdNumberNull(){
        assertNull(patientService.findByIdNumber("patient"));
    }

    @Test
    public void generatePatientIdTrue(){
        assertEquals(2, patientService.generatePatientId());
    }

    @Test
    public void generatePatientIdFalse(){
        assertNotEquals(3, patientService.generatePatientId());
    }
}