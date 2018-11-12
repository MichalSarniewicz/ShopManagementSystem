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

@EnableAutoConfiguration
@Controller
public class SupplierController {

	@Autowired
	private SupplyRepository supplyRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	@RequestMapping(value = { "/suppliers" }, method = RequestMethod.GET)
	public String suppliersGet(Model model) {

		model.addAttribute("suppliers", supplierRepository.findAll());

		return "suppliers";
	}

	@RequestMapping(value = { "/supplierDetails/{id}" }, method = RequestMethod.GET)
	public String supplierDetailsGet(Model model, @PathVariable String id) {

		Long idLong = Long.parseLong(id);
		supplierRepository.findById(idLong).ifPresent(supplier -> model.addAttribute("supplier", supplier));

		model.addAttribute("supplies", supplyRepository.findBySupplierId(idLong));

		model.addAttribute("maxSupplierId", supplierRepository.findMaxId());
		
		return "supplierDetails";
	}
}