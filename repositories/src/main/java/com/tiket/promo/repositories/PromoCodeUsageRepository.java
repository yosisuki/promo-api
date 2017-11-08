package com.tiket.promo.repositories;

import com.tiket.promo.entities.PromoCodeUsage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeUsageRepository extends MongoRepository<PromoCodeUsage, Long> {
    PromoCodeUsage insert(PromoCodeUsage promoCodeUsage);
}