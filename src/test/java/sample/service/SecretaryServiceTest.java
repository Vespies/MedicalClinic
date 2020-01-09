package sample.service;

import org.junit.Before;
import org.junit.Test;
import sample.db.DataBase;
import sample.model.Secretary;

import static org.junit.Assert.*;

public class SecretaryServiceTest {

    private SecretaryService secretaryService;

    @Before
    public void setup() {
        secretaryService = new SecretaryService();

        DataBase.getInstance().getSecretaryList().clear();
        DataBase.getInstance().getSecretaryList().add(new Secretary(1, "secretary", "secretary", "s3001", "sss", "secretary", 20, "woman"));
    }

    @Test
    public void findByIdNUmberNotNull() {
        assertNotNull(secretaryService.findByIdNumber("s3001"));
    }

    @Test
    public void findByIdNUmberNull() {
        assertNull(secretaryService.findByIdNumber("secretary"));
    }

    @Test
    public void generateSecretaryIdEquals() {
        assertEquals(2, secretaryService.generateSecretaryId());
    }

    @Test
    public void generateSecretaryIdNotEquals() {
        assertNotEquals(3, secretaryService.generateSecretaryId());
    }

}