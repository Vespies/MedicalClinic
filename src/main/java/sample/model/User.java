package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class User {

    private int id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String password;
    private String address;
    private int age;
    private String sex;
}
