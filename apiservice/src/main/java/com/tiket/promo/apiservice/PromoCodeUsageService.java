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
    private PromoCodeUsageRepository promoCodeUsageRepository;

    public void createPromoCodeUsage(String code){
        PromoCodeUsage promoCodeUsage = new PromoCodeUsage();
        promoCodeUsage.setCode(code);
        promoCodeUsage.setCreatedDate(new Date());
        promoCodeUsage.setTransactionId(1);
        this.promoCodeUsageRepository.insert(promoCodeUsage);
    }
}
