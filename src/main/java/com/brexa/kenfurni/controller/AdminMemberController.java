package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.service.AdminMemberService;

/**
 * 管理側会員コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/members")
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    public AdminMemberController(AdminMemberService adminMemberService) {
        this.adminMemberService = adminMemberService;
    }

    /**
     * 会員一覧画面表示
     *
     * @param model モデル
     * @return 会員一覧画面テンプレート名
     */
    @GetMapping
    public String showMemberList(Model model) {
        model.addAttribute("memberList", adminMemberService.findAll());
        return "admin/member_list";
    }

    /**
     * 会員詳細画面表示
     *
     * @param memberId 会員ID
     * @param model モデル
     * @return 会員詳細画面テンプレート名
     */
    @GetMapping("/{memberId}")
    public String showMemberDetail(@PathVariable Integer memberId, Model model) {
        model.addAttribute("member", adminMemberService.findById(memberId));
        model.addAttribute("historyList", adminMemberService.findHistoryByMemberId(memberId));
        return "admin/member_detail";
    }
}