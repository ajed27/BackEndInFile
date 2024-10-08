package com.infile.api.controller;

import com.infile.api.data.session.LoginRequest;
import com.infile.api.data.session.RegisterRequest;
import com.infile.api.service.SessionService;
import com.infile.api.structure.response.ResponseMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @PostMapping("/login")
    ResponseMessage login(@RequestBody @Valid LoginRequest loginRequest){
        return this.sessionService.login(loginRequest);
    }

    @PostMapping("/register")
    ResponseMessage register(@RequestBody @Valid RegisterRequest registerRequest){
        return this.sessionService.createUser(registerRequest);
    }

}
