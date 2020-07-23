package lk.company.price_engine.controller;

import lk.company.price_engine.dto.req.ProductReq;
import lk.company.price_engine.dto.res.PriceRes;
import lk.company.price_engine.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "calculate")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PutMapping
    public PriceRes calculatePrice(@RequestBody List<ProductReq> productReqList) {
       return priceService.calculatePrice(productReqList);
    }

}
