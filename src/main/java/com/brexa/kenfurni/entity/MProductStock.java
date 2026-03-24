package com.brexa.kenfurni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 商品在庫エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "m_product_stock")
public class MProductStock {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_stock")
    private Integer productStock;

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public Integer getProductStock() { return productStock; }
    public void setProductStock(Integer productStock) { this.productStock = productStock; }
}