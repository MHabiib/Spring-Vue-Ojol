package com.future.jpa.controller;

import com.future.jpa.model.requestResponse.LoginRequest;
import com.future.jpa.model.requestResponse.LoginResponse;
import com.future.jpa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse authenticate(@RequestBody LoginRequest request){
        return loginService.authenticate(request);
    }
}
