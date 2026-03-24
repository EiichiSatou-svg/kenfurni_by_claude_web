package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brexa.kenfurni.service.CartService;

/**
 * カートコントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * カート詳細画面表示
     *
     * @param model モデル
     * @return カート画面テンプレート名
     */
    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        return "user/cart";
    }

    /**
     * カートに商品を追加する
     *
     * @param productId 商品ID
     * @param quantity 数量
     * @return リダイレクト先
     */
    @PostMapping("/add")
    public String addToCart(
            @RequestParam String productId,
            @RequestParam Integer quantity) {
        cartService.addItem(productId, quantity);
        return "redirect:/cart";
    }

    /**
     * カートから商品を削除する
     *
     * @param productId 商品ID
     * @return リダイレクト先
     */
    @PostMapping("/remove")
    public String removeFromCart(@RequestParam String productId) {
        cartService.removeItem(productId);
        return "redirect:/cart";
    }
}