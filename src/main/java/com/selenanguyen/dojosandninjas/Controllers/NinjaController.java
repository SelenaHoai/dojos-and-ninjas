package com.selenanguyen.dojosandninjas.Controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selenanguyen.dojosandninjas.Models.Dojo;
import com.selenanguyen.dojosandninjas.Models.Ninja;
import com.selenanguyen.dojosandninjas.Services.DojoService;
import com.selenanguyen.dojosandninjas.Services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	
	// ================= Display ==================
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		
		return "addNinja.jsp";
	}
	
//	@RequestMapping("/dojos/{id}")
//	public String showNinjas(@PathVariable("id") Long id, Model model) {
//		Dojo dojo=dojoService.getOne(id);
//		model.addAttribute("dojos", dojo);
//		
//		return "showDojo.jsp";
//	}
	
	
	// ================= Action ================
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		if (result.hasErrors()) {
			return "addNinjas.jsp";
		}else {		
			ninjaService.save(ninja);
			
			return "redirect:/dojos";
		}
	}

}
