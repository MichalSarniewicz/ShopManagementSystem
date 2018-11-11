package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@Controller
public class LoginController {

	// Login form
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}