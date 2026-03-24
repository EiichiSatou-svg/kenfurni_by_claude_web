package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brexa.kenfurni.service.PasswordResetService;

/**
 * パスワード再発行コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/member/password-reset")
public class PasswordResetController {

    private final PasswordResetService passwordResetService;

    public PasswordResetController(PasswordResetService passwordResetService) {
        this.passwordResetService = passwordResetService;
    }

    /**
     * パスワード再発行画面表示
     *
     * @return パスワード再発行画面テンプレート名
     */
    @GetMapping
    public String showForm() {
        return "user/password_reset";
    }

    /**
     * パスワード再発行処理
     *
     * @param memberMail メールアドレス
     * @param newPassword 新しいパスワード
     * @param newPasswordConfirm 新しいパスワード（確認）
     * @param model モデル
     * @return リダイレクト先またはテンプレート名
     */
    @PostMapping
    public String reset(
            @RequestParam String memberMail,
            @RequestParam String newPassword,
            @RequestParam String newPasswordConfirm,
            Model model) {

        if (!newPassword.equals(newPasswordConfirm)) {
            model.addAttribute("errorMessage", "パスワードが一致しません。");
            model.addAttribute("memberMail", memberMail);
            return "user/password_reset";
        }

        boolean result = passwordResetService.resetPassword(memberMail, newPassword);

        if (!result) {
            model.addAttribute("errorMessage", "メールアドレスが登録されていません。");
            return "user/password_reset";
        }

        return "redirect:/login?passwordReset";
    }
}