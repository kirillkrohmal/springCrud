package ru.demo.crud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/newForm")
    public String index() {
        return "/form";
    }
}
