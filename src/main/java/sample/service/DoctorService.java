package sample.service;

import sample.db.DataBase;
import sample.model.Doctor;

public class DoctorService {

    public Doctor findByIdNumber(String idNumber) {
        for (Doctor element: DataBase.getInstance().getDoctorList()) {
            if (element.getIdNumber().equals(idNumber)) return element;
        }
        return null;
    }

    public int generateDoctorId() {
        return DataBase.getInstance().getDoctorList().size() + 1;
    }

    public Doctor findById(Integer id) {
        for (Doctor element : DataBase.getInstance().getDoctorList()){
            if (element.getId().equals(id)) return element;
        }
        return null;
    }
}
