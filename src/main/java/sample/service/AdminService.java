package sample.service;

import sample.db.DataBase;
import sample.model.Admin;

public class AdminService {

    public Admin findByIdNumber(String idNumber) {
        for (Admin element : DataBase.getInstance().getAdminList()) {
            if (element.getIdNumber().equals(idNumber)) return element;
        }
        return null;
    }

    public int generateAdminId() {
        return DataBase.getInstance().getAdminList().size() + 1;
    }
}
