package sample.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Patient extends User{

    public Patient(int id, String firstName, String lastName, String IDNumber, String password, String address, int age, String sex) {
        super(id, firstName, lastName, IDNumber, password, address, age, sex);
    }
}