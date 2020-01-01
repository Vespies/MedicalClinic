package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Visit {

    private int id;
    private LocalDate date;
    private LocalTime time;
    private boolean accepted;
    private int patientId;
    private int doctorId;
    private int noteId;
}
