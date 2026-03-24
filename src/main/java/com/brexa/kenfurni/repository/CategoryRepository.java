package com.brexa.kenfurni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.MCategory;

/**
 * 大分類リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface CategoryRepository extends JpaRepository<MCategory, Integer> {

    List<MCategory> findByValidFlag(String validFlag);
}