package com.brexa.kenfurni.controller;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

/**
 * エラーコントローラー
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Controller
public class SystemErrorController implements ErrorController {

    /**
     * システムエラー画面表示
     *
     * @param request リクエスト
     * @param model モデル
     * @return システムエラー画面テンプレート名
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object statusCodeObj = request.getAttribute("jakarta.servlet.error.status_code");
        Integer statusCode = (statusCodeObj != null) ? Integer.valueOf(statusCodeObj.toString()) : null;
        model.addAttribute("statusCode", statusCode);
        return "error";
    }
}