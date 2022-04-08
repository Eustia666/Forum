package cn.chonglang.forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DevelopController {
    @GetMapping("/dev")
    public String chat(HttpServletRequest request, Model model) {
        model.addAttribute("noticeTitle","敬请期待");
        model.addAttribute("noticeMessage","敬请期待！");
        model.addAttribute("navtype", "devnav");
        return "other/notice";
    }
}
