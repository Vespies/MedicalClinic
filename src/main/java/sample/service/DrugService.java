package sample.service;

import sample.db.DataBase;

public class DrugService {


    public int generateDrugId(){
        return DataBase.getInstance().getDrugList().size() + 1;
    }
}
