package sample.service;

import sample.db.DataBase;
import sample.model.Doctor;
import sample.model.Drug;
import sample.model.Patient;
import sample.model.Prescription;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionService {

    public int generatePrescriptionId() {
        return DataBase.getInstance().getPrescriptionList().size() + 1;
    }

    public List<Prescription> findByPatientId(Integer patientId) {
        List<Prescription> prescriptionList = new ArrayList<>();

        for (Prescription element : DataBase.getInstance().getPrescriptionList()) {
            if (element.getPatientId().equals(patientId)) prescriptionList.add(element);
        }
        return prescriptionList;
    }

    public boolean addPrescription(Patient patient, Drug drug, Doctor doctor, int quantity, String dosage) {
        if (patient != null && drug != null && doctor != null) {
            Prescription prescription = new Prescription(generatePrescriptionId(), drug.getName(), quantity, dosage, patient.getId(), doctor.getId());
            DataBase.getInstance().getPrescriptionList().add(prescription);
            return true;
        }
        return false;
    }
}
