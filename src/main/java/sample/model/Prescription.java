package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prescription {

    private Integer id;
    private String drugName;
    private int quantity;
    private String dosage;
    private Integer patientId;
    private Integer doctorId;

    @Override
    public String toString() {
        return "Prescription id: " + id;
    }
}
