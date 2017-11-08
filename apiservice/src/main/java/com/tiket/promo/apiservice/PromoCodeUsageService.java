package com.tiket.promo.apiservice;

import com.tiket.promo.entities.PromoCode;
import com.tiket.promo.entities.PromoCodeUsage;
import com.tiket.promo.repositories.PromoCodeRepository;
import com.tiket.promo.repositories.PromoCodeUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromoCodeUsageService {
    private PromoCodeRepository promoCodeRepository;
    private PromoCodeUsageRepository promoCodeUsageRepository;

    @Autowired
    public PromoCodeUsageService(PromoCodeRepository promoCodeRepository, PromoCodeUsageRepository promoCodeUsageRepository){
        this.promoCodeRepository = promoCodeRepository;
        this.promoCodeUsageRepository = promoCodeUsageRepository;
    }

    public boolean usePromoCode(String code){
        List<PromoCode> promoCodes = this.promoCodeRepository.findByCode(code);
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
