package com.brexa.kenfurni.dto;

/**
 * 売上一覧DTO
 *
 * @author BREXA Technology
 * @version 1.0
 */
public class EarningsListDto {

    private String productId;
    private String productName;
    private Integer year;
    private Integer totalAmount;

    public EarningsListDto(String productId, String productName, Integer year, Integer totalAmount) {
        this.productId = productId;
        this.productName = productName;
        this.year = year;
        this.totalAmount = totalAmount;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public Integer getYear() { return year; }
    public Integer getTotalAmount() { return totalAmount; }
}