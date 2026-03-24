package com.brexa.kenfurni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 会員購入履歴商品明細エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "t_member_history_product_list")
public class TMemberHistoryProductList {

    @Id
    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column(name = "purchase_id_number")
    private Integer purchaseIdNumber;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_purchase_price")
    private Integer productPurchasePrice;

    @Column(name = "purchase_quantity")
    private Integer purchaseQuantity;

    public Integer getPurchaseId() { return purchaseId; }
    public void setPurchaseId(Integer purchaseId) { this.purchaseId = purchaseId; }

    public Integer getPurchaseIdNumber() { return purchaseIdNumber; }
    public void setPurchaseIdNumber(Integer purchaseIdNumber) { this.purchaseIdNumber = purchaseIdNumber; }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public Integer getProductPurchasePrice() { return productPurchasePrice; }
    public void setProductPurchasePrice(Integer productPurchasePrice) { this.productPurchasePrice = productPurchasePrice; }

    public Integer getPurchaseQuantity() { return purchaseQuantity; }
    public void setPurchaseQuantity(Integer purchaseQuantity) { this.purchaseQuantity = purchaseQuantity; }
}