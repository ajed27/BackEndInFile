package com.infile.api.controller;

import com.infile.api.data.session.LoginRequest;
import com.infile.api.data.session.RegisterRequest;
import com.infile.api.service.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    String api(){
        return "Hola soy la nueva api";
    }

    @PostMapping("/login")
    Map<String, Object> login(@RequestBody @Valid LoginRequest loginRequest){
        return this.sessionService.login(loginRequest);
    }

    @PostMapping("/register")
    Map<String, Object> register(@RequestBody @Valid RegisterRequest registerRequest){
        return this.sessionService.createUser(registerRequest);
    }

}
