package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repository.SupplierRepository;
import repository.SupplyRepository;

/**
 * This class is a controller for "supplier" and "supplierDetails" pages.
 * 
 * @author Michał Sarniewicz
 *
 */
@EnableAutoConfiguration
@Controller
public class SupplierController {

	@Autowired
	private SupplyRepository supplyRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	/**
	 * This is a request mapping get method for "suppliers" page.
	 * The method retrieves all suppliers from the repository and adds to the model.
	 * 
	 * @param model
	 * @return "/suppliers"
	 */
	@RequestMapping(value = { "/suppliers" }, method = RequestMethod.GET)
	public String suppliersGet(Model model) {

		model.addAttribute("suppliers", supplierRepository.findAll());

		return "suppliers";
	}
	
	/**
	 * This is a request mapping get method for "supplierDetails" page.
	 * The method retrieves from the repository: details of one supplier and related supplies
	 * and adds to the model.
	 * 
	 * @param model
	 * @param id
	 * @return "/supplierDetails"
	 */
	@RequestMapping(value = { "/supplierDetails/{id}" }, method = RequestMethod.GET)
	public String supplierDetailsGet(Model model, @PathVariable String id) {

		Long idLong = Long.parseLong(id);
		supplierRepository.findById(idLong).ifPresent(supplier -> model.addAttribute("supplier", supplier));

		model.addAttribute("supplies", supplyRepository.findBySupplierId(idLong));

		//it helps to show 'next' button, only when next supplier exists
		model.addAttribute("maxSupplierId", supplierRepository.findMaxId());
		
		return "supplierDetails";
	}
}