package com.future.jpa.service;

import com.future.jpa.model.requestResponse.LoginRequest;
import com.future.jpa.model.requestResponse.LoginResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginService {
    LoginResponse authenticate(@RequestBody LoginRequest request);
}
