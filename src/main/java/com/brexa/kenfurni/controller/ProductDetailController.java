package com.brexa.kenfurni.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brexa.kenfurni.entity.MProduct;
import com.brexa.kenfurni.service.ProductDetailService;

/**
 * 商品詳細コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    /**
     * 商品詳細画面表示
     *
     * @param productId 商品ID
     * @param model モデル
     * @return 商品詳細画面テンプレート名
     */
    @GetMapping("/products/{productId}")
    public String showProductDetail(@PathVariable String productId, Model model) {

        Optional<MProduct> product = productDetailService.findById(productId);

        if (product.isEmpty()) {
            return "redirect:/top";
        }

        model.addAttribute("product", product.get());
        return "user/product_detail";
    }
}