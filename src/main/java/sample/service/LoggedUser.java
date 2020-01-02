package sample.service;

import lombok.Data;
import sample.model.Admin;
import sample.model.Doctor;
import sample.model.Patient;
import sample.model.Secretary;

@Data
public class LoggedUser {

    private static final LoggedUser LOGGED_USER = new LoggedUser();

    private Patient patient;
    private Doctor doctor;
    private Secretary secretary;
    private Admin admin;

    private LoggedUser() {
    }

    public static LoggedUser getInstance(){
        return LOGGED_USER;
    }

    public void logout() {
        patient = null;
        doctor = null;
        secretary = null;
        admin = null;
    }
}
