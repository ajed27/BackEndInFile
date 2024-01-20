package com.infile.api.controller;

import com.infile.api.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("news")
public class NewController {

    @Autowired
    NewService newService;

    @GetMapping
    public Map<String, Object> getAll(){
        return this.newService.getAll();
    }

    @GetMapping("recommend")
    public Map<String, Object> getThree(){
        return this.newService.getThree();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable(value = "id") Long idNew){
        return this.newService.get(idNew);
    }

}
