package com.brexa.kenfurni.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brexa.kenfurni.entity.MProduct;
import com.brexa.kenfurni.repository.ProductRepository;

/**
 * 商品詳細サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class ProductDetailService {

    private final ProductRepository productRepository;

    public ProductDetailService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 商品IDで商品を取得
     *
     * @param productId 商品ID
     * @return 商品情報
     */
    public Optional<MProduct> findById(String productId) {
        return productRepository.findById(productId);
    }
}