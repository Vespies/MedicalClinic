package sample.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Secretary extends User {

    public Secretary(int id, String firstName, String lastName, String IDNumber, String password, String address, int age, String sex) {
        super(id, firstName, lastName, IDNumber, password, address, age, sex);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
