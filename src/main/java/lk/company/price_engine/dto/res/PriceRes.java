package lk.company.price_engine.dto.res;

import lk.company.price_engine.dto.LineItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PriceRes {

    private List<LineItems> lineItems;

    private double discount;

    private double subtotal;

    private double total;

}
