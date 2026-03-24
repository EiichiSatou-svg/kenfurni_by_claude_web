package com.brexa.kenfurni.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 売上エンティティ複合キー
 *
 * @author BREXA Technology
 * @version 1.0
 */
public class TEarningsId implements Serializable {

    private Integer year;
    private String productId;

    public TEarningsId() {}

    public TEarningsId(Integer year, String productId) {
        this.year = year;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TEarningsId)) return false;
        TEarningsId that = (TEarningsId) o;
        return Objects.equals(year, that.year) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, productId);
    }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
}