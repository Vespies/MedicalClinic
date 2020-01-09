package sample.service;

import sample.db.DataBase;
import sample.model.*;

import java.time.LocalDate;
import java.util.Random;

// initialising the application with some basic data
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

    private void addPatient() {
        for (int i = 0; i < 3; i++) {
            Patient patient = new Patient(patientService.generatePatientId(), "patient" + (i + 1), "patient" + (i + 1), "p100" + (i + 1), "ppp", "address" + (i + 1), 30, "man");
            DataBase.getInstance().getPatientList().add(patient);
        }
    }

    private void addDoctor() {
        for (int i = 0; i < 3; i++) {
            Doctor doctor = new Doctor(doctorService.generateDoctorId(), "doctor" + (i + 1), "doctor" + (i + 1), "d200" + (i + 1), "ddd", "address" + (i + 1), 30, "man");
            DataBase.getInstance().getDoctorList().add(doctor);
        }
    }

    private void addSecretary() {
        Secretary secretary = new Secretary(secretaryService.generateSecretaryId(), "secretary", "secretary", "s3001", "sss", "address", 30, "woman");
        DataBase.getInstance().getSecretaryList().add(secretary);
    }

    private void addAdmin() {
        Admin admin = new Admin(adminService.generateAdminId(), "admin", "admin", "a4001", "aaa", "address", 30, "man");
        DataBase.getInstance().getAdminList().add(admin);
    }

    private void addNote() {
        Note note = new Note(noteService.generateNoteId(), "test note 1");
        DataBase.getInstance().getNoteList().add(note);

        note = new Note(noteService.generateNoteId(), "test note 2");
        DataBase.getInstance().getNoteList().add(note);
    }

    private void addVisit() {
        Note note = DataBase.getInstance().getNoteList().get(0);
        Visit visit = new Visit(visitService.generateVisitId(), LocalDate.now().plusDays(1), false, 1, 1, note.getId());
        DataBase.getInstance().getVisitList().add(visit);

        note = DataBase.getInstance().getNoteList().get(1);
        visit = new Visit(visitService.generateVisitId(), LocalDate.now().plusDays(1), true, 1, 1, note.getId());
        DataBase.getInstance().getVisitList().add(visit);
    }

    private void addDrug() {
        for (int i = 0; i < 10; i++) {
            Drug drug = new Drug(drugService.generateDrugId(), "drug " + (i + 1), random.nextInt(50));
            DataBase.getInstance().getDrugList().add(drug);
        }
    }

    private void addPrescription() {
        Drug drug = DataBase.getInstance().getDrugList().get(0);

        Prescription prescription = new Prescription(prescriptionService.generatePrescriptionId(), drug.getName(), 2, "3 times per day", 1, 1);
        DataBase.getInstance().getPrescriptionList().add(prescription);

        prescription = new Prescription(prescriptionService.generatePrescriptionId(), drug.getName(), 1, "1 times per day", 1, 1);
        DataBase.getInstance().getPrescriptionList().add(prescription);
    }

    public void initializeDataBase() {
        addPatient();
        addDoctor();
        addSecretary();
        addAdmin();
        addNote();
        addVisit();
        addDrug();
        addPrescription();
    }
}
