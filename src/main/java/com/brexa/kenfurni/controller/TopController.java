package com.brexa.kenfurni.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brexa.kenfurni.entity.MProduct;
import com.brexa.kenfurni.service.TopService;

/**
 * トップ画面コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
public class TopController {

    private final TopService topService;

    public TopController(TopService topService) {
        this.topService = topService;
    }

    /**
     * トップ画面表示
     *
     * @param keyword 検索キーワード
     * @param categoryId カテゴリID
     * @param model モデル
     * @return トップ画面テンプレート名
     */
    @GetMapping("/top")
    public String showTop(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            Model model) {

        List<MProduct> products;

        if (keyword != null && !keyword.isBlank()) {
            products = topService.findByKeyword(keyword);
            model.addAttribute("keyword", keyword);
        } else if (categoryId != null) {
            products = topService.findByCategory(categoryId);
            model.addAttribute("categoryId", categoryId);
        } else {
            products = topService.findAllProducts();
        }

        model.addAttribute("products", products);
        return "user/top";
    }
}