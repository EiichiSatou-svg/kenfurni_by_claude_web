package com.brexa.kenfurni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brexa.kenfurni.entity.MStaff;
import com.brexa.kenfurni.service.AdminStaffService;

/**
 * 管理側社員コントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/staff")
public class AdminStaffController {

    private final AdminStaffService adminStaffService;

    public AdminStaffController(AdminStaffService adminStaffService) {
        this.adminStaffService = adminStaffService;
    }

    @GetMapping
    public String showStaffList(Model model) {
        model.addAttribute("staffList", adminStaffService.findAll());
        return "admin/staff_list";
    }

    @GetMapping("/new")
    public String showStaffForm(Model model) {
        model.addAttribute("staff", new MStaff());
        return "admin/staff_form";
    }

    @PostMapping("/new")
    public String createStaff(@ModelAttribute MStaff staff) {
        staff.setValidFlag("0");
        adminStaffService.save(staff);
        return "redirect:/admin/staff";
    }

    @GetMapping("/{staffId}/edit")
    public String showStaffEditForm(@PathVariable Integer staffId, Model model) {
        model.addAttribute("staff", adminStaffService.findById(staffId));
        return "admin/staff_form";
    }

    @PostMapping("/{staffId}/edit")
    public String updateStaff(@PathVariable Integer staffId,
            @ModelAttribute MStaff staff) {
        staff.setStaffId(staffId);
        adminStaffService.save(staff);
        return "redirect:/admin/staff";
    }
}