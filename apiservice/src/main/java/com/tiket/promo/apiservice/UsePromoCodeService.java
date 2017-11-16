package com.tiket.promo.apiservice;

import com.tiket.promo.entities.PromoCode;
import com.tiket.promo.entities.PromoCodeDiscountRange;
import com.tiket.promo.repositories.PromoCodeDiscountRangeRepository;
import com.tiket.promo.repositories.PromoCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UsePromoCodeService {
    @Autowired
    private PromoCodeRepository promoCodeRepository;

    @Autowired
    private PromoCodeUsageService promoCodeUsageService;

    @Autowired
    private PromoCodeDiscountRangeRepository promoCodeDiscountRangeRepository;

    public boolean use(String code, Double totalAmount){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Date startDate = new Date();
        Date endDate = new Date();

        try {
            startDate = df.parse("01/01/2017");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            endDate = df.parse("01/02/2017");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<PromoCode> promoCodes = this.promoCodeRepository.findByCodeAndStartDateAndEndDate(code, startDate, endDate);
        if(promoCodes.isEmpty()){
            //If no Promo Code found, just end the usage process
            return false;
        }

        PromoCode promoCode = promoCodes.get(0);
        Double discount  = this.getDiscountFromRange(promoCode, totalAmount);
        if(discount <= 0.0){
            return false;
        }
        promoCode.setQty(promoCode.getQty() - 1);
        this.promoCodeRepository.save(promoCode);

        //Can be separated as kafka service
        this.promoCodeUsageService.createPromoCodeUsage(code);

        return true;
    }

    private Double getDiscountFromRange(PromoCode promoCode, Double totalAmount){
        List<PromoCodeDiscountRange> promoCodeDiscountRanges = this.promoCodeDiscountRangeRepository.findByCode(promoCode.getCode());
        int promoCodeDiscountRangesCount = promoCodeDiscountRanges.size();
        Double discount = 0.0;
        for(int a = 0; a < promoCodeDiscountRangesCount; a++){
            PromoCodeDiscountRange promoCodeDiscountRange = promoCodeDiscountRanges.get(a);
            if(promoCodeDiscountRange.getStartRange() >= totalAmount
                    && promoCodeDiscountRange.getEndRange() <= totalAmount){
                discount = promoCodeDiscountRange.getDiscount();
                break;
            }
        }

        return discount;
    }
}
