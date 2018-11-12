package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.SupplyWithProductInfo;
import repository.SupplyRepository;
import repository.SupplyWithProductInfoRepository;

@EnableAutoConfiguration
@Controller
public class SupplyController {

	@Autowired
	private SupplyRepository supplyRepository;

	@Autowired
	private SupplyWithProductInfoRepository supplyWithProductInfoRepository;
	
	@RequestMapping(value = { "/supplies" }, method = RequestMethod.GET)
	public String suppliesGet(Model model) {

		model.addAttribute("supplies", supplyRepository.findAll());

		return "supplies";
	}	
	
	@RequestMapping(value = { "/supplyDetails/{id}" }, method = RequestMethod.GET)
	public String supplyDetailsGet(Model model, @PathVariable String id) {

		Long idLong = Long.parseLong(id);
		supplyRepository.findById(idLong).ifPresent(supply -> model.addAttribute("supply", supply));

		List<SupplyWithProductInfo> suppliesWithProductInfo = supplyWithProductInfoRepository
				.findAllProductsBySupplyId(idLong);
		model.addAttribute("products", suppliesWithProductInfo);

		model.addAttribute("maxSupplyId", supplyRepository.findMaxId());
		
		return "supplyDetails";
	}
	

}