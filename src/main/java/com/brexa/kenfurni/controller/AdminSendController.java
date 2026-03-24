package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.service.AdminSendService;

/**
 * 管理側発送一覧コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/send")
public class AdminSendController {

    private final AdminSendService adminSendService;

    public AdminSendController(AdminSendService adminSendService) {
        this.adminSendService = adminSendService;
    }

    /**
     * 発送一覧画面表示
     *
     * @param model モデル
     * @return 発送一覧画面テンプレート名
     */
    @GetMapping
    public String showSendList(Model model) {
        model.addAttribute("sendList", adminSendService.findAll());
        return "admin/send_list";
    }
}