package com.brexa.kenfurni.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brexa.kenfurni.entity.MCategory;
import com.brexa.kenfurni.entity.MSubcategory;
import com.brexa.kenfurni.entity.MSubcategoryId;
import com.brexa.kenfurni.repository.CategoryRepository;
import com.brexa.kenfurni.repository.SubcategoryRepository;

/**
 * 管理側分類サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class AdminCategoryService {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public AdminCategoryService(CategoryRepository categoryRepository,
            SubcategoryRepository subcategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    public List<MCategory> findAllCategories() {
        return categoryRepository.findAll();
    }

    public List<MSubcategory> findAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public MCategory findCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("分類が見つかりません"));
    }

    public MSubcategory findSubcategoryById(Integer categoryId, Integer subcategoryId) {
        return subcategoryRepository.findById(new MSubcategoryId() {{
            setCategoryId(categoryId);
            setSubcategoryId(subcategoryId);
        }}).orElseThrow(() -> new RuntimeException("中分類が見つかりません"));
    }

    @Transactional
    public void saveCategory(MCategory category) {
        categoryRepository.save(category);
    }

    @Transactional
    public void saveSubcategory(MSubcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }
}