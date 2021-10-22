package com.ubosque.tiendavirtual;
import com.ubosque.DTO.Login;
import com.ubosque.DTO.Status;
import com.ubosque.DAO.LoginDAO;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController

@RequestMapping("/Login")
public class LoginController {
	@GetMapping
	public Status loginReques(@RequestBody Login login) {
		return LoginDAO.loginReques(login);
	}
}