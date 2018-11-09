package controller;

import static java.lang.Math.toIntExact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.Order;
import app.OrderDetailsRepository;
import app.OrderRepository;
import app.Product;
import app.ProductRepository;
import app.SupplierRepository;
import app.Supply;
import app.SupplyDetailsRepository;
import app.SupplyRepository;

@EnableAutoConfiguration
@Controller
public class MainController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private SupplyRepository supplyRepository;

	@Autowired
	private SupplyDetailsRepository supplyDetailsRepository;

	@Autowired
	private SupplierRepository supplierRepository;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String indexGet(Model model) {

		return "redirect:/menu";
	}

	@RequestMapping(value = { "menu" }, method = RequestMethod.GET)
	public String menuGet(Model model) {

		return "menu";
	}
	
	  // Login form
	  @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }

	  // Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }
	  
	  @RequestMapping("/logout")
	  public String logout() {
	    return "login";
	  }
	  
	  
	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public String productsGet(Model model) {

		model.addAttribute("products", productRepository.findAll());

		return "products";
	}

	@RequestMapping(value = { "/productDetails" }, method = RequestMethod.GET)
	public String productDetailsGet(Model model) {

		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("orderDetails", orderDetailsRepository.findAll());
		model.addAttribute("orders", orderRepository.findAll());

		model.addAttribute("supplyDetails", supplyDetailsRepository.findAll());
		model.addAttribute("supply", supplyRepository.findAll());

		int size = orderRepository.findAll().size();
		Order[] orderArray = new Order[size + 1];

		for (Order order : orderRepository.findAll()) {
			orderArray[toIntExact(order.getId())] = order;
		}
		model.addAttribute("orderArray", orderArray);

		size = supplyRepository.findAll().size();
		Supply[] supplyArray = new Supply[size + 1];

		for (Supply supply : supplyRepository.findAll()) {
			supplyArray[toIntExact(supply.getId())] = supply;
		}
		model.addAttribute("supplyArray", supplyArray);

		return "productDetails";
	}

	@RequestMapping(value = { "/orderDetails" }, method = RequestMethod.GET)
	public String orderDetailsGet(Model model) {

		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("orderDetails", orderDetailsRepository.findAll());
		model.addAttribute("orders", orderRepository.findAll());

		int size = productRepository.findAll().size();
		Product[] productArray = new Product[size + 1];

		for (Product product : productRepository.findAll()) {
			productArray[toIntExact(product.getId())] = product;
		}
		model.addAttribute("productArray", productArray);

		return "orderDetails";
	}

	@RequestMapping(value = { "/orders" }, method = RequestMethod.GET)
	public String ordersGet(Model model) {

		model.addAttribute("orders", orderRepository.findAll());

		return "orders";
	}

	@RequestMapping(value = { "/supplyDetails" }, method = RequestMethod.GET)
	public String supplyDetailsGet(Model model) {
		
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("supplyDetails", supplyDetailsRepository.findAll());
		model.addAttribute("supplies", supplyRepository.findAll());

		int size = productRepository.findAll().size();
		Product[] productArray = new Product[size + 1];

		for (Product product : productRepository.findAll()) {
			productArray[toIntExact(product.getId())] = product;
		}
		model.addAttribute("productArray", productArray);

		return "supplyDetails";
	}

	@RequestMapping(value = { "/supplies" }, method = RequestMethod.GET)
	public String suppliesGet(Model model) {

		model.addAttribute("supplies", supplyRepository.findAll());

		return "supplies";
	}
	
	@RequestMapping(value = { "/suppliers" }, method = RequestMethod.GET)
	public String suppliersGet(Model model) {

		model.addAttribute("suppliers", supplierRepository.findAll());

		return "suppliers";
	}
	
	@RequestMapping(value = { "/supplierDetails" }, method = RequestMethod.GET)
	public String supplierDetailsGet(Model model) {
		
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("supplies", supplyRepository.findAll());

		return "supplierDetails";
	}
	
}