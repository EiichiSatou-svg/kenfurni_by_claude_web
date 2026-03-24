package com.brexa.kenfurni.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理側メニューコントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminMenuController {

    /**
     * メニュー画面表示
     *
     * @param authentication 認証情報
     * @param model モデル
     * @return メニュー画面テンプレート名
     */
    @GetMapping("/menu")
    public String showMenu(Authentication authentication, Model model) {
        model.addAttribute("staffName", authentication.getName());
        model.addAttribute("authorities", authentication.getAuthorities());
        return "admin/menu";
    }
}