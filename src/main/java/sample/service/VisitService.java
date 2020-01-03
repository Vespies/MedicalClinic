package sample.service;

import sample.db.DataBase;
import sample.model.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitService {

    public int generateVisitId() {
        return DataBase.getInstance().getVisitList().size() + 1;
    }

    public List<Visit> patientHistory(Integer patientId) {
        List<Visit> visitList = new ArrayList<>();

        for (Visit element : DataBase.getInstance().getVisitList()) {
            if (element.getPatientId().equals(patientId)) visitList.add(element);
        }
        return visitList;
    }

    public List<Visit> secretaryVisitList() {
        List<Visit> visitList = new ArrayList<>();
        LocalDate date = LocalDate.now();

        for (Visit element : DataBase.getInstance().getVisitList()){
            if (element.isAccepted() && element.getDate().isAfter(date)) visitList.add(element);
        }
        return visitList;
    }


}
