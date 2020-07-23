package lk.company.price_engine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "auto_increment")
    @TableGenerator(name = "auto_increment", allocationSize =  1, valueColumnName = "seq_no")
    private int ID;

    private String product_name;

    private  double cartoon_price;

    private double units_per_cartoon;

    @Formula( value = "(cartoon_price / units_per_cartoon ) * 0.3 ")
    private double perUnitPrice;
}
