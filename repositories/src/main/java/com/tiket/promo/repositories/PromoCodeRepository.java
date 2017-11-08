package com.tiket.promo.repositories;

import com.tiket.promo.entities.PromoCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PromoCodeRepository extends MongoRepository<PromoCode, Long> {
    List<PromoCode> findAll();
    PromoCode insert(PromoCode promoCode);
    PromoCode save(PromoCode promoCode);
    List<PromoCode> findByCode(String code);
    List<PromoCode> findByCodeAndStartDateAndEndDate(String code, Date startDate, Date endDate);
}
