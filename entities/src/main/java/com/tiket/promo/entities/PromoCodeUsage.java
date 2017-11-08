package com.tiket.promo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
    Promo Code Usage : this will be used for counting every usage of promo code during transaction
    Per Record will also record transaction id and customer id
 **/
@Document(collection = "promo_code_usage")
public class PromoCodeUsage {
    @Id
    private String _id;

    @Field("code")
    private String code;

    @Field("created_date")
    private Date createdDate;

    @Field("transaction_id")
    private int transactionId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
