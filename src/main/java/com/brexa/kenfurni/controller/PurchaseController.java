package com.brexa.kenfurni.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.service.CartService;
import com.brexa.kenfurni.service.PurchaseService;

/**
 * 購入コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    private final CartService cartService;
    private final PurchaseService purchaseService;

    public PurchaseController(CartService cartService, PurchaseService purchaseService) {
        this.cartService = cartService;
        this.purchaseService = purchaseService;
    }

    /**
     * 購入確認画面表示
     *
     * @param model モデル
     * @return 購入確認画面テンプレート名
     */
    @GetMapping("/confirm")
    public String showConfirm(Model model) {
        if (cartService.getCartItems().isEmpty()) {
            return "redirect:/cart";
        }
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        return "user/purchase_confirm";
    }

    /**
     * 購入確定処理
     *
     * @param principal ログインユーザー情報
     * @param model モデル
     * @return リダイレクト先
     */
    @PostMapping("/complete")
    public String complete(Principal principal, Model model) {
        if (cartService.getCartItems().isEmpty()) {
            return "redirect:/cart";
        }

        purchaseService.purchase(principal.getName(), cartService);
        cartService.clear();
        return "redirect:/purchase/done";
    }

    /**
     * 購入完了画面表示
     *
     * @return 購入完了画面テンプレート名
     */
    @GetMapping("/done")
    public String showDone() {
        return "user/purchase_complete";
    }
}