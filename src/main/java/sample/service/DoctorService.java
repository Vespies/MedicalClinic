package sample.service;

import sample.db.DataBase;
import sample.model.*;

public class DoctorService {

    // looking for a doctor based on idNumber
    public Doctor findByIdNumber(String idNumber) {
        for (Doctor element : DataBase.getInstance().getDoctorList()) {
            if (element.getIdNumber().equals(idNumber)) return element;
        }
        return null;
    }

    // generating id for a doctor
    public int generateDoctorId() {
        return DataBase.getInstance().getDoctorList().size() + 1;
    }


    // looking for a doctor based on id
    public Doctor findById(Integer id) {
        for (Doctor element : DataBase.getInstance().getDoctorList()) {
            if (element.getId().equals(id)) return element;
        }
        return null;
    }
}
