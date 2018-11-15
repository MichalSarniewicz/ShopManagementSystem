package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.ProductWithOrderInfo;
import repository.OrderRepository;
import repository.ProductWithOrderInfoRepository;

/**
 * This class is a controller for orders and orderDetails pages.
 * 
 * @author Michał Sarniewicz
 *
 */
@EnableAutoConfiguration
@Controller
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductWithOrderInfoRepository productWithOrderInfoRepository;
	
	/**
	 * This is a request mapping get method for "orders" page.
	 * The method retrieves all orders from the repository and adds to the model.
	 * 
	 * @param model
	 * @return "/orders"
	 */
	@RequestMapping(value = { "/orders" }, method = RequestMethod.GET)
	public String ordersGet(Model model) {

		model.addAttribute("orders", orderRepository.findAll());

		return "orders";
	}
	
	/**
	 * This is a request mapping get method for "orderDetails" page.
	 * The method retrieves details of one order from the repository and adds to the model.
	 * Then retrieves the list of ordered products with more data about products.
	 * 
	 * @param model
	 * @param id
	 * @return "/orders"
	 */
	@RequestMapping(value = { "/orderDetails/{id}" }, method = RequestMethod.GET)
	public String orderDetailsGet(Model model, @PathVariable String id) {

		Long idLong = Long.parseLong(id);
		orderRepository.findById(idLong).ifPresent(order -> model.addAttribute("order", order));

		List<ProductWithOrderInfo> productsWithOrderInfo = productWithOrderInfoRepository
				.findAllProductsByOrderId(idLong);
		model.addAttribute("products", productsWithOrderInfo);

		//it helps to show 'next' button, only when order exists
		model.addAttribute("maxOrderId", orderRepository.findMaxId());
		
		return "orderDetails";
	}
}