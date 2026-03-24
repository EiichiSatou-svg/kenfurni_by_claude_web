package com.brexa.kenfurni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.TProductSend;

/**
 * 発送リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface ProductSendRepository extends JpaRepository<TProductSend, Integer> {
}