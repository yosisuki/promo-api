package com.tiket.promo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "promo_code")
public class PromoCode {
    @Id
    private String _id;

    @Field("code")
    private String code;

    @Field("description")
    private String description;

    @Field("qty")
    // Number of Promo Codes available
    private int qty;

    @Field("used")
    // Number of Promo Codes usage
    private int used;

    @Field("allowed_product")
    private String allowedProduct;

    @Field("booking_platform")
    private String bookingPlatform;

    @Field("discount_type")
    // Discount Type will determine if this promo code only gives discount or any other discount method such as "Buy 1 get 1"
    private String discountType;

    @Field("max_discount")
    // Maximum amount of discount can be obtained by using this promo code, mostly affect the percentage discount
    private Double maxDiscount;

    @Field("min_transaction")
    // Minimum amount of transaction which will be able to use the promo code
    private Double minTransaction;

    @Field("limit_type")
    // The limitation of promo code usage
    // value will be "unlimited", "once_per_day", "one_time", "first_transaction"
    private String limit_type;

    @Field("start_date")
    // When will the promo_code can be used
    private Date startDate;

    @Field("end_date")
    // When will this promo_code validity will expired
    private Date endDate;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public String getAllowedProduct() {
        return allowedProduct;
    }

    public void setAllowedProduct(String allowedProduct) {
        this.allowedProduct = allowedProduct;
    }

    public String getBookingPlatform() {
        return bookingPlatform;
    }

    public void setBookingPlatform(String bookingPlatform) {
        this.bookingPlatform = bookingPlatform;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public Double getMinTransaction() {
        return minTransaction;
    }

    public void setMinTransaction(Double minTransaction) {
        this.minTransaction = minTransaction;
    }

    public String getLimit_type() {
        return limit_type;
    }

    public void setLimit_type(String limit_type) {
        this.limit_type = limit_type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
