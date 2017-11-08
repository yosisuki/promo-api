package com.tiket.promo.apiservice;

import com.tiket.promo.entities.PromoCode;
import com.tiket.promo.entities.PromoCodeUsage;
import com.tiket.promo.repositories.PromoCodeRepository;
import com.tiket.promo.repositories.PromoCodeUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PromoCodeUsageService {
    @Autowired
    private PromoCodeRepository promoCodeRepository;

    @Autowired
    private PromoCodeUsageRepository promoCodeUsageRepository;



    public boolean usePromoCode(String code){
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
        PromoCode promoCode = promoCodes.get(0);
        promoCode.setQty(promoCode.getQty() - 1);
        this.promoCodeRepository.save(promoCode);

        PromoCodeUsage promoCodeUsage = new PromoCodeUsage();
        promoCodeUsage.setCode(code);
        promoCodeUsage.setCreatedDate(new Date());
        promoCodeUsage.setTransactionId(1);
        this.promoCodeUsageRepository.insert(promoCodeUsage);

        return true;
    }
}
