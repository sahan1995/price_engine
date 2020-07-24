package lk.company.price_engine.service.impl;

import lk.company.price_engine.dto.LineItems;
import lk.company.price_engine.dto.req.ProductReq;
import lk.company.price_engine.dto.res.PriceRes;
import lk.company.price_engine.entity.Product;
import lk.company.price_engine.repository.ProductRepository;
import lk.company.price_engine.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public PriceRes calculatePrice(List<ProductReq> productReqList) {
        PriceRes priceRes = new PriceRes();

        ArrayList<LineItems> lineItems = new ArrayList<>();

        HashMap<Integer, Double> discountProducts = new HashMap<>();


        Set<Integer> productIds = productReqList.stream().map(productReq -> productReq.getId())
                .collect((Collectors.toSet()));

        List<Product> allById = productRepository.findAllById(productIds);

        productReqList.forEach(cartoonProducts -> {

            if ( cartoonProducts.getType().equals("cartoon") ) {
                Double cartoon_price = allById.stream().filter((product -> product.getID() == cartoonProducts.getId()))
                        .map(product -> product.getCartoon_price())
                        .collect(Collectors.toList()).get(0);

                if ( cartoonProducts.getQty() >= 3 ) {
                    discountProducts.put(cartoonProducts.getId(), cartoon_price );
                }

                lineItems.add( new LineItems( cartoonProducts.getIndex(), cartoonProducts.getQty() * cartoon_price ));

            } else {
                Product product = allById.stream().filter((p -> p.getID() == cartoonProducts.getId()))
                        .collect(Collectors.toList()).get(0);

                if ( cartoonProducts.getQty() < product.getUnits_per_cartoon()  ) {
                    lineItems.add( new LineItems( cartoonProducts.getIndex(), cartoonProducts.getQty() * product.getPerUnitPrice() ));
                } else {

                    long cartoons = Math.round(cartoonProducts.getQty() / product.getUnits_per_cartoon());

                    long remain_single_units =   Math.round(cartoonProducts.getQty() %  product.getUnits_per_cartoon());

                    lineItems.add( new LineItems( cartoonProducts.getIndex(),
                            cartoons * (product.getCartoon_price() +  remain_single_units * product.getPerUnitPrice()), cartoons, remain_single_units ));


                }
            }

        });

        double discountAmount  = discountProducts.values().stream().map(catoon_price -> (0.1 * catoon_price) ).reduce(0.00, Double::sum );

        Double total = lineItems.stream().map(lineItem -> lineItem.getSub_total()).reduce(0.00, Double::sum);


        priceRes.setDiscount(discountAmount);

        priceRes.setSubtotal(total);

        priceRes.setTotal( total - discountAmount );

        priceRes.setLineItems(lineItems);

        return priceRes;

    }
}
