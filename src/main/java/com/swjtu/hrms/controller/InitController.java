package com.swjtu.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {
    @RequestMapping("/logins")
    public String login(){
        return "login";
    }
    @RequestMapping("/denied")
    public  String denied(){
        return "denied";
    }
}
