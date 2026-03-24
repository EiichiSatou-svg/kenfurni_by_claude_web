package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 管理側ログインコントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    /**
     * 管理側ログイン画面表示
     *
     * @param error ログインエラーフラグ
     * @param logout ログアウトフラグ
     * @param model モデル
     * @return 管理側ログイン画面テンプレート名
     */
    @GetMapping("/login")
    public String showLoginForm(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "スタッフ名またはパスワードが正しくありません。");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "ログアウトしました。");
        }
        return "admin/login";
    }
}