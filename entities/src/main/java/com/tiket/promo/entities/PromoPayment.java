package com.tiket.promo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "promo_payment")
public class PromoPayment {
    @Id
    private String _id;

    @Field("code")
    private String paymentType;
}
