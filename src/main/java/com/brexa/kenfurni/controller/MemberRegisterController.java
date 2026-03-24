package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.form.MemberRegisterForm;
import com.brexa.kenfurni.service.MemberRegisterService;

/**
 * 会員登録コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/member/register")
public class MemberRegisterController {

    private final MemberRegisterService memberRegisterService;

    public MemberRegisterController(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    /**
     * 会員登録画面表示
     *
     * @param model モデル
     * @return 会員登録画面テンプレート名
     */
    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("memberRegisterForm", new MemberRegisterForm());
        return "user/member_register";
    }

    /**
     * 会員登録処理
     *
     * @param form 会員登録フォーム
     * @param model モデル
     * @return リダイレクト先
     */
    @PostMapping
    public String register(@ModelAttribute MemberRegisterForm form, Model model) {

        // パスワード一致チェック
        if (!form.getMemberPassword().equals(form.getMemberPasswordConfirm())) {
            model.addAttribute("errorMessage", "パスワードが一致しません。");
            model.addAttribute("memberRegisterForm", form);
            return "user/member_register";
        }

        // メールアドレス重複チェック
        if (memberRegisterService.existsByMemberMail(form.getMemberMail())) {
            model.addAttribute("errorMessage", "このメールアドレスはすでに登録されています。");
            model.addAttribute("memberRegisterForm", form);
            return "user/member_register";
        }

        memberRegisterService.register(form);
        return "redirect:/login?registered";
    }
}