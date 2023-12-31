package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/")
    public String home(Model model) {
        String storedValue = redisService.getFromRedis("exampleKey");
        model.addAttribute("storedValue", storedValue);
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam String value) {
        redisService.saveToRedis("exampleKey", value);
        return "redirect:/";
    }
}