package lk.company.price_engine.service;

import lk.company.price_engine.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts( int productUnits );

}
