package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@Controller
public class HomeController {

	@RequestMapping(value = { "/","/home" }, method = RequestMethod.GET)
	public String menuGet(Model model) {

		return "/home";
	}
}