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
public class PromoCodeService {
    @Autowired
    private PromoCodeRepository promoCodeRepository;

    @Autowired
    private PromoCodeDiscountRangeRepository promoCodeDiscountRangeRepository;

    public List<PromoCode> all(){
        return this.promoCodeRepository.findByDeletedByNot(1);
    }

    public List<PromoCode> find(String code){
        return this.promoCodeRepository.findByCode(code);
    }

    public boolean insert(
            String code,
            int qty,
            Double discount,
            Double discountPercent,
            Double maxDiscount,
            String startDate,
            String endDate) {
        if(this.isDuplicate(code)){
            return false;
        }
        PromoCode promoCode = new PromoCode();
        promoCode.setCode(code);
        promoCode.setQty(qty);
        promoCode.setUsed(0);
        promoCode.setCreatedBy(1);
        promoCode.setCreatedDate(new Date());
        promoCode.setMaxDiscount(maxDiscount);
        promoCode.setDiscountType("value");

        Date stDate = new Date();
        Date edDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            stDate = df.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            edDate = df.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        promoCode.setStartDate(stDate);
        promoCode.setEndDate(edDate);
        this.promoCodeRepository.insert(promoCode);

        //Insert Discount Range
        PromoCodeDiscountRange promoCodeDiscountRange = new PromoCodeDiscountRange();
        promoCodeDiscountRange.setCode(code);
        promoCodeDiscountRange.setStartRange(0.0);
        promoCodeDiscountRange.setEndRange(maxDiscount);
        promoCodeDiscountRange.setDiscount(discount);
        promoCodeDiscountRange.setDiscountPercent(discountPercent);
        promoCodeDiscountRange.setCreatedBy(1);
        promoCodeDiscountRange.setCreatedDate(new Date());
        this.promoCodeDiscountRangeRepository.insert(promoCodeDiscountRange);

        return true;
    }

    public boolean update(
            String code,
            int qty,
            Double discount,
            Double discountPercent,
            Double maxDiscount,
            String startDate,
            String endDate
    ) {
        List<PromoCode> promoCodes = this.promoCodeRepository.findByCode(code);
        PromoCode promoCode = promoCodes.get(0);
        promoCode.setCode(code);
        promoCode.setQty(qty);
        promoCode.setCreatedBy(1);
        promoCode.setCreatedDate(new Date());
        promoCode.setMaxDiscount(maxDiscount);
        promoCode.setDiscountType("value");

        Date stDate = new Date();
        Date edDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            stDate = df.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            edDate = df.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        promoCode.setStartDate(stDate);
        promoCode.setEndDate(edDate);
        this.promoCodeRepository.save(promoCode);

        //Insert Discount Range
        PromoCodeDiscountRange promoCodeDiscountRange = new PromoCodeDiscountRange();
        promoCodeDiscountRange.setCode(code);
        promoCodeDiscountRange.setStartRange(0.0);
        promoCodeDiscountRange.setEndRange(maxDiscount);
        promoCodeDiscountRange.setDiscount(discount);
        promoCodeDiscountRange.setDiscountPercent(discountPercent);
        promoCodeDiscountRange.setCreatedBy(1);
        promoCodeDiscountRange.setCreatedDate(new Date());
        this.promoCodeDiscountRangeRepository.insert(promoCodeDiscountRange);

        return true;
    }

    public boolean softDelete(
            String code
    ) {
        List<PromoCode> promoCodes = this.promoCodeRepository.findByCode(code);
        PromoCode promoCode = promoCodes.get(0);
        promoCode.setDeletedBy(1);
        promoCode.setDeletedDate(new Date());
        this.promoCodeRepository.save(promoCode);

        return true;
    }

    private boolean isDuplicate(String code){
        List<PromoCode> promoCodes = this.promoCodeRepository.findByCode(code);
        if(promoCodes.isEmpty()){
            return false;
        }
        return true;
    }
}
