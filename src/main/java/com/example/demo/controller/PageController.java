package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral") 
	public String index() {
			return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value="a", defaultValue = "0") int angkaA, @RequestParam(value="b", defaultValue = "0") int angkaB, Model model) {
		
		String katahmm = "hm";
		String printout = "";
		
		if (angkaA < 1 && angkaB < 1) {
			printout += katahmm;
		} 
		
		else {
			
			if (angkaB < 1) {

				for (int i = 1; i < angkaA; i++) {
					katahmm += "m";
				}
				
				printout += katahmm;
			}
			
			else {
				
				for (int i = 1; i < angkaA; i++) {
					katahmm += "m";
				}
				
				for (int j = 0; j < angkaB; j++) {
					printout += (katahmm + " ");
				}
			}
		}
		
		model.addAttribute("a", angkaA);
		model.addAttribute("b", angkaB);
		model.addAttribute("printout", printout);
		
		return "generator";
	}
}
