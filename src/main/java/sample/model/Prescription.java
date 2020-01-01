package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prescription {

    private int id;
    private String drugName;
    private int quantity;
    private String dosage;
    private int patientId;
    private int doctorId;
}
