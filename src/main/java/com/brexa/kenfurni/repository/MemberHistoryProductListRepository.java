package com.brexa.kenfurni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.TMemberHistoryProductList;

/**
 * 会員購入履歴商品明細リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface MemberHistoryProductListRepository extends JpaRepository<TMemberHistoryProductList, Integer> {
}