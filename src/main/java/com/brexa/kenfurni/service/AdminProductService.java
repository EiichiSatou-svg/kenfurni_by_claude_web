package com.brexa.kenfurni.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brexa.kenfurni.entity.MProduct;
import com.brexa.kenfurni.repository.ProductRepository;

/**
 * 管理側商品サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class AdminProductService {

    private final ProductRepository productRepository;

    public AdminProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<MProduct> findAll() {
        return productRepository.findAll();
    }

    public MProduct findById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("商品が見つかりません"));
    }

    @Transactional
    public void save(MProduct product) {
        productRepository.save(product);
    }
}