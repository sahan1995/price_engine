package lk.company.price_engine.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductReq {

    private int id;

    private int qty;

    private String type;

    private int index;
}
