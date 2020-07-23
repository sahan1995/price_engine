package lk.company.price_engine.service.impl;

import lk.company.price_engine.dto.ProductDTO;
import lk.company.price_engine.dto.ProductUnitPrice;
import lk.company.price_engine.entity.Product;
import lk.company.price_engine.repository.ProductRepository;
import lk.company.price_engine.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllProducts( int productUnits ) {

        List<Product> allProducts = productRepository.findAll();

        ArrayList<ProductDTO> productDTOS = new ArrayList<>();


        allProducts.forEach(( product ->  {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            ArrayList<ProductUnitPrice> productUnitPrices = new ArrayList<>();
            if (productUnits >0 ) {
                for ( int unit = 1; unit <=productUnits ; unit++ ) {
                    productUnitPrices.add( new ProductUnitPrice( unit , product.getPerUnitPrice() * unit ));
                }
                productDTO.setProductUnitPrices( productUnitPrices );
            }

            productDTOS.add( productDTO );
        }));
        return productDTOS;
    }
}
