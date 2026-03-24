package com.brexa.kenfurni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 商品エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "m_product")
public class MProduct {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "subcategory_id")
    private Integer subcategoryId;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "product_discount_price")
    private Integer productDiscountPrice;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "product_size")
    private String productSize;

    @Column(name = "product_color")
    private String productColor;

    @Column(name = "product_material")
    private String productMaterial;

    @Column(name = "product_weight")
    private String productWeight;

    @Column(name = "product_packingsize")
    private String productPackingsize;

    @Column(name = "product_manufacture")
    private String productManufacture;

    @Column(name = "product_sale_startday")
    private LocalDate productSaleStartday;

    @Column(name = "product_sale_stopday")
    private LocalDate productSaleStopday;

    @Column(name = "comment")
    private String comment;

    @Column(name = "valid_flag")
    private String validFlag;

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public Integer getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(Integer subcategoryId) { this.subcategoryId = subcategoryId; }

    public Integer getProductPrice() { return productPrice; }
    public void setProductPrice(Integer productPrice) { this.productPrice = productPrice; }

    public Integer getProductDiscountPrice() { return productDiscountPrice; }
    public void setProductDiscountPrice(Integer productDiscountPrice) { this.productDiscountPrice = productDiscountPrice; }

    public String getProductImage() { return productImage; }
    public void setProductImage(String productImage) { this.productImage = productImage; }

    public String getProductSize() { return productSize; }
    public void setProductSize(String productSize) { this.productSize = productSize; }

    public String getProductColor() { return productColor; }
    public void setProductColor(String productColor) { this.productColor = productColor; }

    public String getProductMaterial() { return productMaterial; }
    public void setProductMaterial(String productMaterial) { this.productMaterial = productMaterial; }

    public String getProductWeight() { return productWeight; }
    public void setProductWeight(String productWeight) { this.productWeight = productWeight; }

    public String getProductPackingsize() { return productPackingsize; }
    public void setProductPackingsize(String productPackingsize) { this.productPackingsize = productPackingsize; }

    public String getProductManufacture() { return productManufacture; }
    public void setProductManufacture(String productManufacture) { this.productManufacture = productManufacture; }

    public LocalDate getProductSaleStartday() { return productSaleStartday; }
    public void setProductSaleStartday(LocalDate productSaleStartday) { this.productSaleStartday = productSaleStartday; }

    public LocalDate getProductSaleStopday() { return productSaleStopday; }
    public void setProductSaleStopday(LocalDate productSaleStopday) { this.productSaleStopday = productSaleStopday; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getValidFlag() { return validFlag; }
    public void setValidFlag(String validFlag) { this.validFlag = validFlag; }
}