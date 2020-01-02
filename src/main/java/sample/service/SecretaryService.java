package sample.service;

import sample.db.DataBase;
import sample.model.Secretary;

public class SecretaryService {

    public Secretary findByIdNumber(String idNumber){
        for (Secretary element: DataBase.getInstance().getSecretaryList()) {
            if (element.getIdNumber().equals(idNumber)) return element;
        }
        return null;
    }

    public int generateSecretaryId(){
        return DataBase.getInstance().getSecretaryList().size() + 1;
    }
}
