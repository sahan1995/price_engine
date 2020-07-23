package lk.company.price_engine.controller;

import lk.company.price_engine.dto.ProductDTO;
import lk.company.price_engine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products" )
@CrossOrigin(value = "*")
public class ProductController {


    @Autowired
    private ProductService productService;


    @GetMapping()
    public List<ProductDTO> findAllProducts(@RequestParam int productUnits){
        return productService.findAllProducts( productUnits );
    }

}
