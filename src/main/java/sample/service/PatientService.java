package sample.service;

import sample.db.DataBase;
import sample.model.Patient;

public class PatientService {

    public Patient findByIdNumber(String idNumber){
        for (Patient element: DataBase.getInstance().getPatientList()) {
            if (element.getIdNumber().equals(idNumber)) return element;
        }
        return null;
    }

    public int generatePatientId(){
        return DataBase.getInstance().getPatientList().size() + 1;
    }
}
