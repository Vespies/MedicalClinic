package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Doctor extends User {

    public Doctor(int id, String firstName, String lastName, String IDNumber, String password, String address, int age, String sex) {
        super(id, firstName, lastName, IDNumber, password, address, age, sex);
    }

}
