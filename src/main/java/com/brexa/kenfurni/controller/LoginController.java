package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ログインコントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
public class LoginController {

    /**
     * ログイン画面表示
     *
     * @param error ログインエラーフラグ
     * @param logout ログアウトフラグ
     * @param model モデル
     * @return ログイン画面テンプレート名
     */
	@GetMapping("/")
	public String root() {
	    return "redirect:/top";
	}
	
	@GetMapping("/login")
    public String showLoginForm(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "メールアドレスまたはパスワードが正しくありません。");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "ログアウトしました。");
        }

        return "user/login";
    }
}