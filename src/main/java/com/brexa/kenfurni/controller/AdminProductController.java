package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.entity.MProduct;
import com.brexa.kenfurni.service.AdminCategoryService;
import com.brexa.kenfurni.service.AdminProductService;

/**
 * 管理側商品コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    private final AdminProductService adminProductService;
    private final AdminCategoryService adminCategoryService;

    public AdminProductController(AdminProductService adminProductService,
            AdminCategoryService adminCategoryService) {
        this.adminProductService = adminProductService;
        this.adminCategoryService = adminCategoryService;
    }

    @GetMapping
    public String showProductList(Model model) {
        model.addAttribute("productList", adminProductService.findAll());
        return "admin/product_list";
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new MProduct());
        model.addAttribute("categoryList", adminCategoryService.findAllCategories());
        model.addAttribute("subcategoryList", adminCategoryService.findAllSubcategories());
        return "admin/product_form";
    }

    @PostMapping("/new")
    public String createProduct(@ModelAttribute MProduct product) {
        adminProductService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/{productId}/edit")
    public String showProductEditForm(@PathVariable String productId, Model model) {
        model.addAttribute("product", adminProductService.findById(productId));
        model.addAttribute("categoryList", adminCategoryService.findAllCategories());
        model.addAttribute("subcategoryList", adminCategoryService.findAllSubcategories());
        return "admin/product_form";
    }

    @PostMapping("/{productId}/edit")
    public String updateProduct(@PathVariable String productId,
            @ModelAttribute MProduct product) {
        product.setProductId(productId);
        adminProductService.save(product);
        return "redirect:/admin/products";
    }
}