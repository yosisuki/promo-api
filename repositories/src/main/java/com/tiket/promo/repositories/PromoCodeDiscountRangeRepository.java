package com.tiket.promo.repositories;

import com.tiket.promo.entities.PromoCodeDiscountRange;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PromoCodeDiscountRangeRepository extends MongoRepository<PromoCodeDiscountRange, Long> {
    List<PromoCodeDiscountRange> findAll();
    PromoCodeDiscountRange insert(PromoCodeDiscountRange promoCodeDiscountRange);
    PromoCodeDiscountRange save(PromoCodeDiscountRange promoCodeDiscountRange);
}
