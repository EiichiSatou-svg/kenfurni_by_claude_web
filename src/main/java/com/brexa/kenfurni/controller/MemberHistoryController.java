package com.brexa.kenfurni.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.entity.TMemberHistory;
import com.brexa.kenfurni.service.MemberMypageService;

/**
 * 購入履歴コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/member/history")
public class MemberHistoryController {

    private final MemberMypageService memberMypageService;

    public MemberHistoryController(MemberMypageService memberMypageService) {
        this.memberMypageService = memberMypageService;
    }

    /**
     * 購入履歴画面表示
     *
     * @param principal ログインユーザー情報
     * @param model モデル
     * @return 購入履歴画面テンプレート名
     */
    @GetMapping
    public String showHistory(Principal principal, Model model) {
        List<TMemberHistory> historyList = memberMypageService.findHistoryByMemberMail(principal.getName());
        model.addAttribute("historyList", historyList);
        return "user/member_history";
    }
}