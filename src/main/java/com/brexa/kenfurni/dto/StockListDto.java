package com.brexa.kenfurni.dto;

/**
 * 商品在庫一覧DTO
 *
 * @author BREXA Technology
 * @version 1.0
 */
public class StockListDto {

    private String productId;
    private String productName;
    private Integer productStock;

    public StockListDto(String productId, String productName, Integer productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productStock = productStock;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public Integer getProductStock() { return productStock; }
}