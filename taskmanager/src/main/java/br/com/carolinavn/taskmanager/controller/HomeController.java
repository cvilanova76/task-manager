package br.com.carolinavn.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    

    @GetMapping("/home")
    public String home(){
        return "index";
    }
}
