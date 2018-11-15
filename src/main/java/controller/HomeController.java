package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class is a controller for home page.
 * 
 * @author Michał Sarniewicz
 *
 */
@EnableAutoConfiguration
@Controller
public class HomeController {

	/**
	 * This is a request mapping get method for home page
	 * @param model
	 * @return "/home"
	 */
	@RequestMapping(value = { "/","/home" }, method = RequestMethod.GET)
	public String menuGet(Model model) {

		return "/home";
	}
}