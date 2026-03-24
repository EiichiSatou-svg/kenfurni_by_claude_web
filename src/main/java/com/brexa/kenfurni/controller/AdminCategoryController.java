package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.entity.MCategory;
import com.brexa.kenfurni.entity.MSubcategory;
import com.brexa.kenfurni.service.AdminCategoryService;

/**
 * 管理側分類コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    private final AdminCategoryService adminCategoryService;

    public AdminCategoryController(AdminCategoryService adminCategoryService) {
        this.adminCategoryService = adminCategoryService;
    }

    @GetMapping
    public String showCategoryList(Model model) {
        model.addAttribute("categoryList", adminCategoryService.findAllCategories());
        model.addAttribute("subcategoryList", adminCategoryService.findAllSubcategories());
        return "admin/category_list";
    }

    @GetMapping("/new")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new MCategory());
        return "admin/category_form";
    }

    @PostMapping("/new")
    public String createCategory(@ModelAttribute MCategory category) {
        category.setValidFlag("0");
        adminCategoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/{categoryId}/edit")
    public String showCategoryEditForm(@PathVariable Integer categoryId, Model model) {
        model.addAttribute("category", adminCategoryService.findCategoryById(categoryId));
        return "admin/category_form";
    }

    @PostMapping("/{categoryId}/edit")
    public String updateCategory(@PathVariable Integer categoryId,
            @ModelAttribute MCategory category) {
        category.setCategoryId(categoryId);
        adminCategoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/{categoryId}/subcategories/new")
    public String showSubcategoryForm(@PathVariable Integer categoryId, Model model) {
        MSubcategory sub = new MSubcategory();
        sub.setCategoryId(categoryId);
        model.addAttribute("subcategory", sub);
        model.addAttribute("category", adminCategoryService.findCategoryById(categoryId));
        return "admin/subcategory_form";
    }

    @PostMapping("/{categoryId}/subcategories/new")
    public String createSubcategory(@PathVariable Integer categoryId,
            @ModelAttribute MSubcategory subcategory) {
        subcategory.setCategoryId(categoryId);
        subcategory.setValidFlag("0");
        adminCategoryService.saveSubcategory(subcategory);
        return "redirect:/admin/categories";
    }

    @GetMapping("/{categoryId}/subcategories/{subcategoryId}/edit")
    public String showSubcategoryEditForm(@PathVariable Integer categoryId,
            @PathVariable Integer subcategoryId, Model model) {
        model.addAttribute("subcategory",
                adminCategoryService.findSubcategoryById(categoryId, subcategoryId));
        model.addAttribute("category", adminCategoryService.findCategoryById(categoryId));
        return "admin/subcategory_form";
    }

    @PostMapping("/{categoryId}/subcategories/{subcategoryId}/edit")
    public String updateSubcategory(@PathVariable Integer categoryId,
            @PathVariable Integer subcategoryId,
            @ModelAttribute MSubcategory subcategory) {
        subcategory.setCategoryId(categoryId);
        subcategory.setSubcategoryId(subcategoryId);
        adminCategoryService.saveSubcategory(subcategory);
        return "redirect:/admin/categories";
    }
}