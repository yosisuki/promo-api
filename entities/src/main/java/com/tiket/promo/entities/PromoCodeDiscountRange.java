package com.tiket.promo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "promo_code_discount_range")
public class PromoCodeDiscountRange {
    @Id
    private String _id;

    @Field("code")
    private String code;

    @Field("start_range")
    private Double startRange;

    @Field("end_range")
    private Double endRange;

    @Field("discount")
    private Double discount;

    @Field("discount_percent")
    private Double discountPercent;

    @Field("created_date")
    private Date createdDate;

    @Field("updated_date")
    private Date updatedDate;

    @Field("created_by")
    private int createdBy;

    @Field("updated_by")
    private int updatedBy;

    @Field("deleted_date")
    private Date deletedDate;

    @Field("deleted_by")
    private int deletedBy;

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

    public Double getStartRange() {
        return startRange;
    }

    public void setStartRange(Double startRange) {
        this.startRange = startRange;
    }

    public Double getEndRange() {
        return endRange;
    }

    public void setEndRange(Double endRange) {
        this.endRange = endRange;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public int getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(int deletedBy) {
        this.deletedBy = deletedBy;
    }
}
