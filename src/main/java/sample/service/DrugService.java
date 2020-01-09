package sample.service;

import sample.db.DataBase;
import sample.model.Drug;

public class DrugService {

    // generating id for the drug
    public int generateDrugId() {
        return DataBase.getInstance().getDrugList().size() + 1;
    }


    // increasing the amount
    public boolean addDrug(Drug drug, int quantity) {
        if (drug != null && quantity > 0) {
            int tmp = drug.getQuantity();
            tmp += quantity;
            drug.setQuantity(tmp);
            return true;
        }
        return false;
    }


    // decreasing the amount
    public boolean dispenseDrug(Drug drug, int quantity) {
        if (drug != null && quantity > 0 && drug.getQuantity() >= quantity) {
            int tmp = drug.getQuantity();
            tmp -= quantity;
            drug.setQuantity(tmp);
            return true;
        }
        return false;
    }
}
