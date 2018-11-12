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

@EnableAutoConfiguration
@Controller
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductWithOrderInfoRepository productWithOrderInfoRepository;
	
	@RequestMapping(value = { "/orders" }, method = RequestMethod.GET)
	public String ordersGet(Model model) {

		model.addAttribute("orders", orderRepository.findAll());

		return "orders";
	}
	
	@RequestMapping(value = { "/orderDetails/{id}" }, method = RequestMethod.GET)
	public String orderDetailsGet(Model model, @PathVariable String id) {

		Long idLong = Long.parseLong(id);
		orderRepository.findById(idLong).ifPresent(order -> model.addAttribute("order", order));

		List<ProductWithOrderInfo> productsWithOrderInfo = productWithOrderInfoRepository
				.findAllProductsByOrderId(idLong);
		model.addAttribute("products", productsWithOrderInfo);

		model.addAttribute("maxOrderId", orderRepository.findMaxId());
		
		return "orderDetails";
	}
}