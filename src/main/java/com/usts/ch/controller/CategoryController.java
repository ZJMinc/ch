package com.usts.ch.controller;

import com.usts.ch.pojo.Category;
import com.usts.ch.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @CrossOrigin
    @GetMapping("/api/category/list")
    public List<Category> list() throws Exception{
        return categoryService.list();
    }
}
