package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is a controller for login page.
 * 
 * @author Michał Sarniewicz
 *
 */
@EnableAutoConfiguration
@Controller
public class LoginController {

	/**
	 * This is a request mapping get method for login page.
	 * @return "/login"
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}