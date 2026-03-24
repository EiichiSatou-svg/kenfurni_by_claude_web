package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brexa.kenfurni.service.AdminEarningsService;

/**
 * 管理側売上一覧コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/earnings")
public class AdminEarningsController {

    private final AdminEarningsService adminEarningsService;

    public AdminEarningsController(AdminEarningsService adminEarningsService) {
        this.adminEarningsService = adminEarningsService;
    }

    /**
     * 売上一覧画面表示
     *
     * @param year 年度
     * @param model モデル
     * @return 売上一覧画面テンプレート名
     */
    @GetMapping
    public String showEarningsList(
            @RequestParam(value = "year", required = false, defaultValue = "2026") Integer year,
            Model model) {
        model.addAttribute("earningsList", adminEarningsService.findByYear(year));
        model.addAttribute("year", year);
        return "admin/earnings_list";
    }
}