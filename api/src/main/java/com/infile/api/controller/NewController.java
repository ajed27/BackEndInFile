package com.infile.api.controller;

import com.infile.api.service.NewService;
import com.infile.api.structure.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("news")
public class NewController {

    @Autowired
    NewService newService;

    @GetMapping
    public ResponseMessage getAll(){
        return this.newService.getAll();
    }

    @GetMapping("recommend/{category}")
    public ResponseMessage getThree(@PathVariable(value = "category") Long idCategory){
        return this.newService.getAllByCategory(true, idCategory);
    }

    @GetMapping("category/{id}")
    public ResponseMessage getAllByCategory(@PathVariable(value = "id") Long idCategory){
        return this.newService.getAllByCategory(true, idCategory);
    }

    @GetMapping("/{id}")
    public ResponseMessage getById(@PathVariable(value = "id") Long idNew){
        return this.newService.get(idNew);
    }

}
