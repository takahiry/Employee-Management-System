package com.takahiry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        //具體的業務：
        if ( !StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html" ;
        }
        else {
            //失敗
            model.addAttribute("msg", "用戶名或密碼錯誤！");
            return "index";
        }

    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate() ;
        return "redirect:/index.html" ;
    }
}
