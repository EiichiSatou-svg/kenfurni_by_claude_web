package com.brexa.kenfurni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * 中分類エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "m_subcategory")
@IdClass(MSubcategoryId.class)
public class MSubcategory {

    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @Id
    @Column(name = "subcategory_id")
    private Integer subcategoryId;

    @Column(name = "subcategory_name")
    private String subcategoryName;

    @Column(name = "valid_flag")
    private String validFlag;

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public Integer getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(Integer subcategoryId) { this.subcategoryId = subcategoryId; }

    public String getSubcategoryName() { return subcategoryName; }
    public void setSubcategoryName(String subcategoryName) { this.subcategoryName = subcategoryName; }

    public String getValidFlag() { return validFlag; }
    public void setValidFlag(String validFlag) { this.validFlag = validFlag; }
}