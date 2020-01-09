package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Drug {

    private Integer id;
    private String name;
    private int quantity;

    @Override
    public String toString() {
        return name + " quantity : " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return Objects.equals(id, drug.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
