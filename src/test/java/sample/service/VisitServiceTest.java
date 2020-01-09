package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Visit;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class VisitServiceTest {

    private VisitService visitService;

    @Before
    public void setup() {
        visitService = new VisitService();

        DataBase.getInstance().getVisitList().clear();
        DataBase.getInstance().getVisitList().add(new Visit(1, LocalDate.now().plusDays(2), true, 1, 1, 1));
    }

    @Test
    public void generateVisitIdEquals() {
        assertEquals(2, visitService.generateVisitId());
    }

    @Test
    public void generateVisitIdNotEquals() {
        assertNotEquals(3, visitService.generateVisitId());
    }

    @Test
    public void patientVisitListNotEmpty() {
        List<Visit> patientVisitList = visitService.patientVisitList(1);
        assertFalse(patientVisitList.isEmpty());
    }

    @Test
    public void patientVisitListEmpty() {
        List<Visit> patientVisitList = visitService.patientVisitList(2);
        assertTrue(patientVisitList.isEmpty());
    }

    @Test
    public void secretaryVisitListNotEmpty() {
        List<Visit> patientVisitList = visitService.secretaryVisitList();
        assertFalse(patientVisitList.isEmpty());
    }

    @Test
    public void secretaryVisitListEmpty() {
        DataBase.getInstance().getVisitList().clear();

        List<Visit> patientVisitList = visitService.secretaryVisitList();
        assertTrue(patientVisitList.isEmpty());
    }

    @Test
    public void doctorVisitListNotEmpty() {
        List<Visit> patientVisitList = visitService.doctorVisitList(1);
        assertFalse(patientVisitList.isEmpty());
    }

    @Test
    public void doctorVisitListEmpty() {
        List<Visit> patientVisitList = visitService.doctorVisitList(2);
        assertTrue(patientVisitList.isEmpty());
    }

    @Test
    public void changeVisitStatusTrue(){
        Visit visit = new Visit(1, null, false, 1, 1 ,1);
        assertTrue(visitService.changeVisitStatus(visit));
    }

    @Test
    public void changeVisitStatusFalse(){
        assertFalse(visitService.changeVisitStatus(null));
    }

    @Test
    public void addVisitTrue(){
        LocalDate date = LocalDate.now();
        Doctor doctor = new Doctor();
        Patient patient = new Patient();

        assertTrue(visitService.addVisit(date, doctor, patient));
    }

    @Test
    public void addVisitFalse(){
        LocalDate date = null;
        Doctor doctor = new Doctor();
        Patient patient = new Patient();

        assertFalse(visitService.addVisit(date, doctor, patient));
    }
}