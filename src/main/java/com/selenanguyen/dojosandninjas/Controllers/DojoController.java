package com.selenanguyen.dojosandninjas.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.selenanguyen.dojosandninjas.Models.Dojo;
import com.selenanguyen.dojosandninjas.Services.DojoService;
import com.selenanguyen.dojosandninjas.Services.NinjaService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
	
	// =============== Display ====================
	@GetMapping("/dojos")
	public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		
		return "newDojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoInfo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.getOne(id));
		
		return "showDojo.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {		
		return "newDojo.jsp";
	}
	
	// ================= Action ================
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			dojoService.save(dojo);	
			
			return "redirect:/ninjas/new";
		}
	}
	
    @DeleteMapping("/dojos/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        dojoService.delete(id);
        return "redirect:/dojos";
    }
}
