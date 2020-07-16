package com.ashetm.project.kafka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewControllerImpl implements ViewController {

    @GetMapping
    public String index() {
        return "index.html";
    }

}
