package sample.db;

import lombok.Data;
import sample.model.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataBase {

    private static final DataBase DATA_BASE = new DataBase();

    private List<Admin> adminList;
    private List<Doctor> doctorList;
    private List<Drug> drugList;
    private List<Note> noteList;
    private List<Patient> patientList;
    private List<Prescription> prescriptionList;
    private List<Secretary> secretaryList;
    private List<Visit> visitList;


    public DataBase() {
        this.adminList = new ArrayList<>();
        this.doctorList = new ArrayList<>();
        this.drugList = new ArrayList<>();
        this.noteList = new ArrayList<>();
        this.patientList = new ArrayList<>();
        this.prescriptionList = new ArrayList<>();
        this.secretaryList = new ArrayList<>();
        this.visitList = new ArrayList<>();
    }

    public static DataBase getInstance() {
        return DATA_BASE;
    }
}
