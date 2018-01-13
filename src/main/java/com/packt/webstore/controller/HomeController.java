package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String welcome(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!");
        redirectAttributes.addFlashAttribute("tagline", "The one an only amazing web store");
        return "redirect:/welcome/greeting";
    }

    @RequestMapping("/welcome/greeting")
    public String greeting() {
        return "welcome";
    }

}
