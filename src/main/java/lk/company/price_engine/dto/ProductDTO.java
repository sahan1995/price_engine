package lk.company.price_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {

    private int ID;

    private String product_name;

    private double cartoon_price;

    private double units_per_cartoon;

    private double perUnitPrice;

    private List<ProductUnitPrice> productUnitPrices;

}
