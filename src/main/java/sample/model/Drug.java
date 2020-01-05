package sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
