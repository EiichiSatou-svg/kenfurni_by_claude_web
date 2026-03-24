package com.brexa.kenfurni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.MProduct;

/**
 * 商品リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<MProduct, String> {

    /**
     * 有効な商品を全件取得
     *
     * @param validFlag 有効フラグ
     * @return 商品リスト
     */
    List<MProduct> findByValidFlag(String validFlag);

    /**
     * カテゴリIDと有効フラグで検索
     *
     * @param categoryId カテゴリID
     * @param validFlag 有効フラグ
     * @return 商品リスト
     */
    List<MProduct> findByCategoryIdAndValidFlag(Integer categoryId, String validFlag);

    /**
     * 商品名部分一致検索
     *
     * @param keyword キーワード
     * @param validFlag 有効フラグ
     * @return 商品リスト
     */
    List<MProduct> findByProductNameContainingAndValidFlag(String keyword, String validFlag);
}