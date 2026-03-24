package com.brexa.kenfurni.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.brexa.kenfurni.entity.MProduct;
import com.brexa.kenfurni.form.CartItem;
import com.brexa.kenfurni.repository.ProductRepository;

/**
 * カートサービス（セッションスコープ）
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
@SessionScope
public class CartService {

    private final ProductRepository productRepository;
    private List<CartItem> cartItems = new ArrayList<>();

    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * カートに商品を追加する
     *
     * @param productId 商品ID
     * @param quantity 数量
     */
    public void addItem(String productId, Integer quantity) {
        // すでにカートにある場合は数量を加算
        for (CartItem item : cartItems) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        // 新規追加
        Optional<MProduct> product = productRepository.findById(productId);
        if (product.isPresent()) {
            MProduct p = product.get();
            Integer price = p.getProductDiscountPrice() != null
                    ? p.getProductDiscountPrice() : p.getProductPrice();
            cartItems.add(new CartItem(productId, p.getProductName(), price, quantity));
        }
    }

    /**
     * カートから商品を削除する
     *
     * @param productId 商品ID
     */
    public void removeItem(String productId) {
        cartItems.removeIf(item -> item.getProductId().equals(productId));
    }

    /**
     * カート内容を取得する
     *
     * @return カートアイテムリスト
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * 合計金額を取得する
     *
     * @return 合計金額
     */
    public Integer getTotalAmount() {
        return cartItems.stream().mapToInt(CartItem::getSubtotal).sum();
    }

    /**
     * カートを空にする
     */
    public void clear() {
        cartItems.clear();
    }
}