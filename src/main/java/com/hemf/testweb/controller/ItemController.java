package com.hemf.testweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    @RequestMapping("/item-add")
    public String addItem() {
        return "item-add";
    }
}
