package com.brexa.kenfurni.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 中分類エンティティ複合キー
 *
 * @author BREXA Technology
 * @version 1.0
 */
public class MSubcategoryId implements Serializable {

    private Integer categoryId;
    private Integer subcategoryId;

    public MSubcategoryId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MSubcategoryId)) return false;
        MSubcategoryId that = (MSubcategoryId) o;
        return Objects.equals(categoryId, that.categoryId) &&
               Objects.equals(subcategoryId, that.subcategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, subcategoryId);
    }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public Integer getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(Integer subcategoryId) { this.subcategoryId = subcategoryId; }
}