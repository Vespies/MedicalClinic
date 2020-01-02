package sample.service;

import sample.db.DataBase;
import sample.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitDataLoader {

    private AdminService adminService = new AdminService();
    private DoctorService doctorService = new DoctorService();
    private DrugService drugService = new DrugService();
    private NoteService noteService = new NoteService();
    private PatientService patientService = new PatientService();
    private PrescriptionService prescriptionService = new PrescriptionService();
    private SecretaryService secretaryService = new SecretaryService();
    private VisitService visitService = new VisitService();
    private Random random = new Random();

    public void addPatient() {
        List<Patient> patientList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Patient patient = new Patient(patientService.generatePatientId(), "patient" + i, "patient" + i, "p100" + i, "ppp", "address" + i, 30, "man");
            patientList.add(patient);
        }
        DataBase.getInstance().setPatientList(patientList);
    }

    public void addDoctor() {
        List<Doctor> doctorList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Doctor doctor = new Doctor(doctorService.generateDoctorId(), "doctor" + i, "doctor" + i, "d200" + i, "ddd", "address" + i, 30, "man");
            doctorList.add(doctor);
        }
        DataBase.getInstance().setDoctorList(doctorList);
    }

    public void addSecretary() {
        Secretary secretary = new Secretary(secretaryService.generateSecretaryId(), "secretary", "secretary", "s3001", "sss", "address", 30, "woman");
        DataBase.getInstance().getSecretaryList().add(secretary);
    }

    public void addAdmin() {
        Admin admin = new Admin(adminService.generateAdminId(), "admin", "admin", "a4001", "aaa", "address", 30, "man");
        DataBase.getInstance().getAdminList().add(admin);
    }

    public void addVisit() {
        Visit visit = new Visit(visitService.generateVisitId(), LocalDate.now().plusDays(1), false, 1, 1, null);
        DataBase.getInstance().getVisitList().add(visit);
    }

    public void addDrug() {
        for (int i = 0; i < 10; i++) {
            Drug drug = new Drug(drugService.generateDrugId(), "drug " + (i + 1), random.nextInt(50));
            DataBase.getInstance().getDrugList().add(drug);
        }
    }

    public void addPrescription() {
        Drug drug = DataBase.getInstance().getDrugList().get(0);

        Prescription prescription = new Prescription(prescriptionService.generatePrescriptionId(), drug.getName(), 2, "3 times per day", 1, 1);
        DataBase.getInstance().getPrescriptionList().add(prescription);

        prescription = new Prescription(prescriptionService.generatePrescriptionId(), drug.getName(), 1, "1 times per day", 1, 1);
        DataBase.getInstance().getPrescriptionList().add(prescription);
    }
}
