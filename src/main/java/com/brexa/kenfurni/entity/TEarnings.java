package com.brexa.kenfurni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * 売上エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "t_earnings")
@IdClass(TEarningsId.class)
public class TEarnings {

    @Id
    @Column(name = "year")
    private Integer year;

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "subcategory_id")
    private Integer subcategoryId;

    @Column(name = "sales_count_01") private Integer salesCount01;
    @Column(name = "sales_amount_01") private Integer salesAmount01;
    @Column(name = "sales_count_02") private Integer salesCount02;
    @Column(name = "sales_amount_02") private Integer salesAmount02;
    @Column(name = "sales_count_03") private Integer salesCount03;
    @Column(name = "sales_amount_03") private Integer salesAmount03;
    @Column(name = "sales_count_04") private Integer salesCount04;
    @Column(name = "sales_amount_04") private Integer salesAmount04;
    @Column(name = "sales_count_05") private Integer salesCount05;
    @Column(name = "sales_amount_05") private Integer salesAmount05;
    @Column(name = "sales_count_06") private Integer salesCount06;
    @Column(name = "sales_amount_06") private Integer salesAmount06;
    @Column(name = "sales_count_07") private Integer salesCount07;
    @Column(name = "sales_amount_07") private Integer salesAmount07;
    @Column(name = "sales_count_08") private Integer salesCount08;
    @Column(name = "sales_amount_08") private Integer salesAmount08;
    @Column(name = "sales_count_09") private Integer salesCount09;
    @Column(name = "sales_amount_09") private Integer salesAmount09;
    @Column(name = "sales_count_10") private Integer salesCount10;
    @Column(name = "sales_amount_10") private Integer salesAmount10;
    @Column(name = "sales_count_11") private Integer salesCount11;
    @Column(name = "sales_amount_11") private Integer salesAmount11;
    @Column(name = "sales_count_12") private Integer salesCount12;
    @Column(name = "sales_amount_12") private Integer salesAmount12;

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public Integer getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(Integer subcategoryId) { this.subcategoryId = subcategoryId; }
    public Integer getSalesCount01() { return salesCount01; }
    public void setSalesCount01(Integer salesCount01) { this.salesCount01 = salesCount01; }
    public Integer getSalesAmount01() { return salesAmount01; }
    public void setSalesAmount01(Integer salesAmount01) { this.salesAmount01 = salesAmount01; }
    public Integer getSalesCount02() { return salesCount02; }
    public void setSalesCount02(Integer salesCount02) { this.salesCount02 = salesCount02; }
    public Integer getSalesAmount02() { return salesAmount02; }
    public void setSalesAmount02(Integer salesAmount02) { this.salesAmount02 = salesAmount02; }
    public Integer getSalesCount03() { return salesCount03; }
    public void setSalesCount03(Integer salesCount03) { this.salesCount03 = salesCount03; }
    public Integer getSalesAmount03() { return salesAmount03; }
    public void setSalesAmount03(Integer salesAmount03) { this.salesAmount03 = salesAmount03; }
    public Integer getSalesCount04() { return salesCount04; }
    public void setSalesCount04(Integer salesCount04) { this.salesCount04 = salesCount04; }
    public Integer getSalesAmount04() { return salesAmount04; }
    public void setSalesAmount04(Integer salesAmount04) { this.salesAmount04 = salesAmount04; }
    public Integer getSalesCount05() { return salesCount05; }
    public void setSalesCount05(Integer salesCount05) { this.salesCount05 = salesCount05; }
    public Integer getSalesAmount05() { return salesAmount05; }
    public void setSalesAmount05(Integer salesAmount05) { this.salesAmount05 = salesAmount05; }
    public Integer getSalesCount06() { return salesCount06; }
    public void setSalesCount06(Integer salesCount06) { this.salesCount06 = salesCount06; }
    public Integer getSalesAmount06() { return salesAmount06; }
    public void setSalesAmount06(Integer salesAmount06) { this.salesAmount06 = salesAmount06; }
    public Integer getSalesCount07() { return salesCount07; }
    public void setSalesCount07(Integer salesCount07) { this.salesCount07 = salesCount07; }
    public Integer getSalesAmount07() { return salesAmount07; }
    public void setSalesAmount07(Integer salesAmount07) { this.salesAmount07 = salesAmount07; }
    public Integer getSalesCount08() { return salesCount08; }
    public void setSalesCount08(Integer salesCount08) { this.salesCount08 = salesCount08; }
    public Integer getSalesAmount08() { return salesAmount08; }
    public void setSalesAmount08(Integer salesAmount08) { this.salesAmount08 = salesAmount08; }
    public Integer getSalesCount09() { return salesCount09; }
    public void setSalesCount09(Integer salesCount09) { this.salesCount09 = salesCount09; }
    public Integer getSalesAmount09() { return salesAmount09; }
    public void setSalesAmount09(Integer salesAmount09) { this.salesAmount09 = salesAmount09; }
    public Integer getSalesCount10() { return salesCount10; }
    public void setSalesCount10(Integer salesCount10) { this.salesCount10 = salesCount10; }
    public Integer getSalesAmount10() { return salesAmount10; }
    public void setSalesAmount10(Integer salesAmount10) { this.salesAmount10 = salesAmount10; }
    public Integer getSalesCount11() { return salesCount11; }
    public void setSalesCount11(Integer salesCount11) { this.salesCount11 = salesCount11; }
    public Integer getSalesAmount11() { return salesAmount11; }
    public void setSalesAmount11(Integer salesAmount11) { this.salesAmount11 = salesAmount11; }
    public Integer getSalesCount12() { return salesCount12; }
    public void setSalesCount12(Integer salesCount12) { this.salesCount12 = salesCount12; }
    public Integer getSalesAmount12() { return salesAmount12; }
    public void setSalesAmount12(Integer salesAmount12) { this.salesAmount12 = salesAmount12; }
}