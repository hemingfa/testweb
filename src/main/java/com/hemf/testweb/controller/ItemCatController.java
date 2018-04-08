package com.hemf.testweb.controller;

import com.hemf.testweb.pojo.EUTreeNode;
import com.hemf.testweb.service.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    IItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

        List<EUTreeNode> catList = itemCatService.getCatList(parentId);
        return catList;
    }
}
