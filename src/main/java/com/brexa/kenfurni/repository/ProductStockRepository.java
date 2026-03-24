package com.brexa.kenfurni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.MProductStock;

/**
 * 商品在庫リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface ProductStockRepository extends JpaRepository<MProductStock, String> {
}