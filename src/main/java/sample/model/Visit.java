package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Visit {

    private Integer id;
    private LocalDate date;
    private boolean accepted;
    private Integer patientId;
    private Integer doctorId;
    private Integer noteId;
    
    @Override
    public String toString() {
        return "Visit : " + date + " accepted : " + accepted;
    }
}
