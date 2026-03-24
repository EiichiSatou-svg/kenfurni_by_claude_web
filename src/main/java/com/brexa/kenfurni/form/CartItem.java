package com.brexa.kenfurni.form;

/**
 * カートアイテム
 *
 * @author BREXA Technology
 * @version 1.0
 */
public class CartItem {

    private String productId;
    private String productName;
    private Integer productPrice;
    private Integer quantity;

    public CartItem(String productId, String productName, Integer productPrice, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    /**
     * 小計を返す
     *
     * @return 小計
     */
    public Integer getSubtotal() {
        return productPrice * quantity;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getProductPrice() { return productPrice; }
    public void setProductPrice(Integer productPrice) { this.productPrice = productPrice; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}