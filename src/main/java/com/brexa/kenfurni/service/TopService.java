package com.brexa.kenfurni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brexa.kenfurni.entity.MProduct;
import com.brexa.kenfurni.repository.ProductRepository;

/**
 * トップ画面サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class TopService {

    private final ProductRepository productRepository;

    public TopService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 有効な商品を全件取得
     *
     * @return 商品リスト
     */
    public List<MProduct> findAllProducts() {
        return productRepository.findByValidFlag("0");
    }

    /**
     * カテゴリで絞り込み
     *
     * @param categoryId カテゴリID
     * @return 商品リスト
     */
    public List<MProduct> findByCategory(Integer categoryId) {
        return productRepository.findByCategoryIdAndValidFlag(categoryId, "0");
    }

    /**
     * キーワードで絞り込み
     *
     * @param keyword キーワード
     * @return 商品リスト
     */
    public List<MProduct> findByKeyword(String keyword) {
        return productRepository.findByProductNameContainingAndValidFlag(keyword, "0");
    }
}