package com.brexa.kenfurni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.MSubcategory;
import com.brexa.kenfurni.entity.MSubcategoryId;

/**
 * 中分類リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface SubcategoryRepository extends JpaRepository<MSubcategory, MSubcategoryId> {

    List<MSubcategory> findByCategoryId(Integer categoryId);
}