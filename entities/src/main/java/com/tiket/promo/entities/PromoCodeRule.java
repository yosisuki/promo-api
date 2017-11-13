package com.tiket.promo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
    Promo Rule : this will be used to validate the promo code based on each parameter used
    if no promo rule defined, we just pass it as without any validation
 **/
@Document(collection = "promo_code_rule")
public class PromoCodeRule {
    @Id
    private String _id;

    @Field("code")
    private String code;

    @Field("productType")
    //The values will be "flight", "hotel", "train", or any other product type
    private String productType;

    @Field("param_name")
    private String paramName;

    @Field("param_operator")
    private String paramOperator;

    @Field("param_value")
    private String paramValue;

    @Field("created_date")
    private Date createdDate;

    @Field("updated_date")
    private Date updatedDate;

    @Field("created_by")
    private int createdBy;

    @Field("updated_by")
    private int updatedBy;
}
