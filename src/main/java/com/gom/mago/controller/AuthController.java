package com.gom.mago.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gom.mago.dto.APIResponse;
import com.gom.mago.dto.auth.CreateMember;
import com.gom.mago.dto.auth.Login;
import com.gom.mago.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

	private final AuthService authService;

    @PostMapping("/signup")
    public APIResponse<CreateMember.Response> signup(@Valid @RequestBody final CreateMember.Request request){
    	log.info("signup");
        return APIResponse.of(authService.signup(request));
    }
    
	@PostMapping("/login")
	public APIResponse<Login.Response> login(@RequestBody final Login.Request request) {
		log.info("login");
        log.info("email = {}", request.getEmail());
        return APIResponse.of(authService.login(request));
	}

	@PostMapping("/logout")
	public String logout() {
		log.info("logout");
		return "logout";
	}
}
