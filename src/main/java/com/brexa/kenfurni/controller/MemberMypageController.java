package com.brexa.kenfurni.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.form.MemberUpdateForm;
import com.brexa.kenfurni.service.MemberMypageService;

/**
 * マイページコントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/member/mypage")
public class MemberMypageController {

    private final MemberMypageService memberMypageService;

    public MemberMypageController(MemberMypageService memberMypageService) {
        this.memberMypageService = memberMypageService;
    }

    /**
     * 会員情報確認画面表示
     *
     * @param principal ログインユーザー情報
     * @param model モデル
     * @return 会員情報確認画面テンプレート名
     */
    @GetMapping
    public String showMypage(Principal principal, Model model) {
        TMember member = memberMypageService.findByMemberMail(principal.getName());
        model.addAttribute("member", member);
        return "user/mypage";
    }

    /**
     * 会員情報更新画面表示
     *
     * @param principal ログインユーザー情報
     * @param model モデル
     * @return 会員情報更新画面テンプレート名
     */
    @GetMapping("/edit")
    public String showEdit(Principal principal, Model model) {
        TMember member = memberMypageService.findByMemberMail(principal.getName());
        MemberUpdateForm form = new MemberUpdateForm();
        form.setMemberName(member.getMemberName());
        form.setMemberKana(member.getMemberKana());
        form.setMemberPost(member.getMemberPost());
        form.setMemberAddress(member.getMemberAddress());
        form.setMemberPhone(member.getMemberPhone());
        form.setMemberBirthday(member.getMemberBirthday().toString());
        form.setMemberPayment(member.getMemberPayment());
        model.addAttribute("memberUpdateForm", form);
        return "user/mypage_edit";
    }

    /**
     * 会員情報更新処理
     *
     * @param principal ログインユーザー情報
     * @param form 会員情報更新フォーム
     * @return リダイレクト先
     */
    @PostMapping("/edit")
    public String update(Principal principal, @ModelAttribute MemberUpdateForm form) {
        memberMypageService.update(principal.getName(), form);
        return "redirect:/member/mypage";
    }
}