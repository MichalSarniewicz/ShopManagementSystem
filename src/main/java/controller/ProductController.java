package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.OrderWithOrderDetailsInfo;
import model.SupplyWithSupplyDetailsInfo;
import repository.OrderWithOrderDetailsInfoRepository;
import repository.ProductRepository;
import repository.SupplyWithSupplyDetailsInfoRepository;

/**
 * This class is a controller for "products" and "productDetails" pages.
 * 
 * @author Michał Sarniewicz
 *
 */
@EnableAutoConfiguration
@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderWithOrderDetailsInfoRepository orderWithOrderDetailsInfoRepository;

	@Autowired
	private SupplyWithSupplyDetailsInfoRepository supplyWithSupplyDetailsInfoRepository;

	/**
	 * This is a request mapping get method for "products" page.
	 * The method retrieves all products from the repository and adds to the model.
	 * 
	 * @param model
	 * @return "/products"
	 */
	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public String productsGet(Model model) {

		model.addAttribute("products", productRepository.findAll());

		return "products";
	}
	
	/**
	 * This is a request mapping get method for "productDetails" page.
	 * The method retrieves from the repository: details of one product, related orders, supplies 
	 * with more info and adds to the model.
	 * 
	 * @param model
	 * @param id
	 * @return "/products"
	 */
	@RequestMapping(value = { "/productDetails/{id}" }, method = RequestMethod.GET)
	public String productDetailsGet(Model model, @PathVariable String id) {

		Long idLong = Long.parseLong(id);

		productRepository.findById(idLong).ifPresent(product -> model.addAttribute("product", product));

		List<OrderWithOrderDetailsInfo> ordersWithOrderDetailsInfo = orderWithOrderDetailsInfoRepository.findAllOrdersByProductId(idLong);
		model.addAttribute("orders", ordersWithOrderDetailsInfo);
		
		List<SupplyWithSupplyDetailsInfo> supplyWithSupplyDetailsInfo = supplyWithSupplyDetailsInfoRepository.findAllSuppliesByProductId(idLong);
		model.addAttribute("supplies", supplyWithSupplyDetailsInfo);
		
		//it helps to show 'next' button, only when next product exists
		model.addAttribute("maxProductId", productRepository.findMaxId());

		return "productDetails";
	}
}