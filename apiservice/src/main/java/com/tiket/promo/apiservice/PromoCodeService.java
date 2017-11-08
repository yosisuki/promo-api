package com.tiket.promo.apiservice;

import com.tiket.promo.entities.PromoCode;
import com.tiket.promo.repositories.PromoCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoCodeService {
    private PromoCodeRepository promoCodeRepository;

    @Autowired
    public PromoCodeService(PromoCodeRepository promoCodeRepository){
        this.promoCodeRepository = promoCodeRepository;
    }

    public List<PromoCode> all(){
        return this.promoCodeRepository.findAll();
    }

    public List<PromoCode> find(String code){
        return this.promoCodeRepository.findByCode(code);
    }

    public boolean insert(String code, int qty) {
        if(this.isDuplicate(code)){
            return false;
        }
        PromoCode promoCode = new PromoCode();
        promoCode.setCode(code);
        promoCode.setQty(qty);
        this.promoCodeRepository.insert(promoCode);
        return true;
    }

    public boolean update(String code, int qty) {
        List<PromoCode> promoCodes = this.promoCodeRepository.findByCode(code);
        PromoCode promoCode = promoCodes.get(0);
        promoCode.setCode(code);
        promoCode.setQty(qty);
        this.promoCodeRepository.save(promoCode);
        return true;
    }

    private boolean isDuplicate(String code){
        List<PromoCode> promoCodes = this.promoCodeRepository.findByCode(code);
        if(!promoCodes.isEmpty()){
            return false;
        }
        return true;
    }
}
