package sample.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import lombok.Data;
import sample.model.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataBase {

    // singleton design pattern, the database
    // saves and reads data to files

    private static final DataBase DATA_BASE = new DataBase();

    private List<Admin> adminList;
    private List<Doctor> doctorList;
    private List<Drug> drugList;
    private List<Note> noteList;
    private List<Patient> patientList;
    private List<Prescription> prescriptionList;
    private List<Secretary> secretaryList;
    private List<Visit> visitList;


    private DataBase() {
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


    // saving to the json file
    public void saveDataToFile() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.registerModule(new JSR310Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // saving data one thing after the other
        mapper.writeValue(new File("admin.json"), adminList);
        mapper.writeValue(new File("doctor.json"), doctorList);
        mapper.writeValue(new File("drug.json"), drugList);
        mapper.writeValue(new File("note.json"), noteList);
        mapper.writeValue(new File("patient.json"), patientList);
        mapper.writeValue(new File("prescription.json"), prescriptionList);
        mapper.writeValue(new File("secretary.json"), secretaryList);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(df);
        mapper.writeValue(new File("visit.json"), visitList);
    }

    // reading data from files and saving data to files
    public void loadDateFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.registerModule(new JSR310Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        CollectionType type = TypeFactory.defaultInstance().constructCollectionType(List.class, Admin.class);
        adminList = mapper.readValue(new File("admin.json"), type);

        type = TypeFactory.defaultInstance().constructCollectionType(List.class, Doctor.class);
        doctorList = mapper.readValue(new File("doctor.json"), type);

        type = TypeFactory.defaultInstance().constructCollectionType(List.class, Drug.class);
        drugList = mapper.readValue(new File("drug.json"), type);

        type = TypeFactory.defaultInstance().constructCollectionType(List.class, Note.class);
        noteList = mapper.readValue(new File("note.json"), type);

        type = TypeFactory.defaultInstance().constructCollectionType(List.class, Patient.class);
        patientList = mapper.readValue(new File("patient.json"), type);

        type = TypeFactory.defaultInstance().constructCollectionType(List.class, Prescription.class);
        prescriptionList = mapper.readValue(new File("prescription.json"), type);

        type = TypeFactory.defaultInstance().constructCollectionType(List.class, Secretary.class);
        secretaryList = mapper.readValue(new File("secretary.json"), type);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(df);
        type = TypeFactory.defaultInstance().constructCollectionType(List.class, Visit.class);
        visitList = mapper.readValue(new File("visit.json"), type);
    }
}
