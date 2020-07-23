package lk.company.price_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineItems {

    private int index;

    private double sub_total;

    private long cartoons_qty;

    private long single_qty;

    public LineItems(int index, double sub_total) {
        this.index = index;
        this.sub_total = sub_total;
    }
}
