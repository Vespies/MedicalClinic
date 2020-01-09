package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Doctor;
import sample.model.Drug;
import sample.model.Patient;
import sample.model.Prescription;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrescriptionServiceTest {

    private PrescriptionService prescriptionService;

    @Before
    public void setup() {
        prescriptionService = new PrescriptionService();

        DataBase.getInstance().getPrescriptionList().clear();
        DataBase.getInstance().getPrescriptionList().add(new Prescription(1, "drug 1", 2, "dosage test", 1, 1));
    }

    @Test
    public void findByPatientIdNotEmpty() {
        List<Prescription> prescriptionList = prescriptionService.findByPatientId(1);
        assertFalse(prescriptionList.isEmpty());
    }

    @Test
    public void findByPatientIdEmpty() {
        List<Prescription> prescriptionList = prescriptionService.findByPatientId(2);
        assertTrue(prescriptionList.isEmpty());
    }

    @Test
    public void addPrescriptionTrue() {
        Patient patient = new Patient();
        Drug drug = new Drug();
        Doctor doctor = new Doctor();
        int quantity = 0;
        String dosage = "dosage test";

        assertTrue(prescriptionService.addPrescription(patient, drug, doctor, quantity, dosage));
    }

    @Test
    public void addPrescriptionFalse() {
        Patient patient = null;
        Drug drug = new Drug();
        Doctor doctor = new Doctor();
        int quantity = 0;
        String dosage = "dosage test";

        assertFalse(prescriptionService.addPrescription(patient, drug, doctor, quantity, dosage));
    }
}