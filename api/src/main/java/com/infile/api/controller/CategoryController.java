package com.infile.api.controller;

import com.infile.api.service.CategoryService;
import com.infile.api.structure.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseMessage getAll(){
        return this.categoryService.getAll();
    }
}
