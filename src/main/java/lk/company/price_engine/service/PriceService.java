package lk.company.price_engine.service;

import lk.company.price_engine.dto.req.ProductReq;
import lk.company.price_engine.dto.res.PriceRes;

import java.util.List;

public interface PriceService {



    PriceRes calculatePrice (List<ProductReq> productReqList);
}
