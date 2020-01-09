package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Drug;

import static org.junit.Assert.*;

public class DrugServiceTest {

    private DrugService drugService;

    @Before
    public void setup() {
        drugService = new DrugService();

        DataBase.getInstance().getDrugList().clear();
        DataBase.getInstance().getDrugList().add(new Drug(1, "drug 1", 20));
    }

    @Test
    public void generateIdEquals() {
        assertEquals(2, drugService.generateDrugId());
    }

    @Test
    public void generateIdNotEquals() {
        assertNotEquals(1, drugService.generateDrugId());
    }

    @Test
    public void addDrugTrue() {
        Drug drug = new Drug(1, "drug 1", 20);
        int quantity = 20;

        assertTrue(drugService.addDrug(drug, quantity));
    }

    @Test
    public void addDrugFalse() {
        Drug drug = new Drug(1, "drug 1", 20);
        int quantity = -5;

        assertFalse(drugService.addDrug(drug, quantity));
    }

    @Test
    public void dispenseDrugTrue(){
        Drug drug = new Drug(1, "drug 1", 20);
        int quantity = 5;

        assertTrue(drugService.dispenseDrug(drug, quantity));
    }

    @Test
    public void dispenseDrugFalse(){
        Drug drug = new Drug(1, "drug 1", 20);
        int quantity = -5;

        assertFalse(drugService.dispenseDrug(drug, quantity));
    }

    @Test
    public void dispenseDrugFalse2(){
        Drug drug = new Drug(1, "drug 1", 20);
        int quantity = 21;

        assertFalse(drugService.dispenseDrug(drug, quantity));
    }
}