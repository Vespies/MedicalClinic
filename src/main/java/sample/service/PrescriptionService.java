package sample.service;

import sample.db.DataBase;
import sample.model.Prescription;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionService {

    public int generatePrescriptionId(){
        return DataBase.getInstance().getPrescriptionList().size() + 1;
    }

    public List<Prescription> findByPatientId(Integer patientId) {
        List<Prescription> prescriptionList = new ArrayList<>();

        for (Prescription element : DataBase.getInstance().getPrescriptionList()) {
            if (element.getPatientId().equals(patientId)) prescriptionList.add(element);
        }
        return prescriptionList;
    }

}
