package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
