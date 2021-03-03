package com.game.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.bankline.entity.Login;
import com.game.bankline.entity.Sessao;
import com.game.bankline.service.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired()
	private LoginService loginService;
	
	@PostMapping()
	private Sessao fazerLogin(@RequestBody Login login) {
		return loginService.fazerLogin(login);
	}
	
}
