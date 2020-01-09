package sample.service;

import sample.db.DataBase;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitService {

    public int generateVisitId() {
        return DataBase.getInstance().getVisitList().size() + 1;
    }

    // generating the list of patients visits
    public List<Visit> patientVisitList(Integer patientId) {
        List<Visit> visitList = new ArrayList<>();

        for (Visit element : DataBase.getInstance().getVisitList()) {
            if (element.getPatientId().equals(patientId)) visitList.add(element);
        }
        return visitList;
    }

    // generating the list of visits for the secretary to see
    public List<Visit> secretaryVisitList() {
        List<Visit> visitList = new ArrayList<>();
        LocalDate date = LocalDate.now();

        for (Visit element : DataBase.getInstance().getVisitList()) {
            if (element.isAccepted() && element.getDate().isAfter(date)) visitList.add(element);
        }
        return visitList;
    }


    // generating the list of visits for the doctor
    public List<Visit> doctorVisitList(Integer doctorId) {
        List<Visit> visitList = new ArrayList<>();

        for (Visit element : DataBase.getInstance().getVisitList()) {
            if (element.getDoctorId().equals(doctorId)) visitList.add(element);
        }
        return visitList;
    }

    // changing the status of the appointment
    public boolean changeVisitStatus(Visit visit) {
        if (visit != null) {
            if (visit.isAccepted()) {
                visit.setAccepted(false);
            } else {
                visit.setAccepted(true);
            }
            return true;
        }
        return false;
    }

    // adding a new visit
    public boolean addVisit(LocalDate date, Doctor doctor, Patient patient) {
        if (date != null && doctor != null && patient != null) {
            Visit visit = new Visit(generateVisitId(), date, false, patient.getId(), doctor.getId(), null);
            DataBase.getInstance().getVisitList().add(visit);
            return true;
        }
        return false;
    }
}
