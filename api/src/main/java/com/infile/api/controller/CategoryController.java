package com.infile.api.controller;

import com.infile.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public Map<String, Object> getAll(){
        return this.categoryService.getAll();
    }
}
