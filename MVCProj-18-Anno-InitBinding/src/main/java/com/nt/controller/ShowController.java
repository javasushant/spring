package com.nt.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;
import com.nt.validator.CustomerValidator;

@Controller
public class ShowController {
	@Autowired
	private ICustomerMgmtService service;
	@Autowired
	private CustomerValidator validator;
	
	@GetMapping("/welcome")
	public String showForm(@ModelAttribute("cust") Customer cust) {
		cust.setCadd("SPJ");
		return "home";
	}
	
	@PostMapping("/welcome")
	public String show(
			                                     @ModelAttribute("cust") Customer cust,
			                                     BindingResult errors,
			                                     RedirectAttributes redirectAttr) {
		//perform server side form validation only when client side form validation is not done
		if(validator.supports(cust.getClass()))
			validator.validate(cust, errors);
		if(errors.hasErrors())
			return "home";
		//use service class
		System.out.println(cust);
		String resultMsg=service.logic(cust);
//		map.put("resultMsg", resultMsg);
		redirectAttr.addFlashAttribute("resultMsg", resultMsg);
		redirectAttr.addFlashAttribute("resultMsg", cust);
		return "redirect:show";
	}
	@GetMapping("/show")
	public String ShowH() {
		return "result";
	}
	//reference data using ModelAttribute
	@ModelAttribute("genderList")
	public List<String> populateGender(){
		System.out.println("ShowController.populateGender()");
		return List.of("male","female");
	}
	
	//reference data using ModelAttribute
	@ModelAttribute("listHobbies")
	public List<String> populateHobbies(){
		System.out.println("ShowController.populateHobbies()");
		return List.of("Reading books","Playing games","Cooking","Eating");
	}
	@ModelAttribute("listCountries")
	public Set<String> populateCountries(){
		System.out.println("ShowController.populateCountries()");
		Locale locales[]= Locale.getAvailableLocales();
		Set<String> countriesSet= new HashSet();
		for(Locale l:locales)
			countriesSet.add(l.getDisplayCountry());
		return countriesSet;
	}
	@ModelAttribute("LangList")
	 public Set<String> populatLang(){
		 System.out.println("ShowController.populatLang()");
		 Locale locales[]= Locale.getAvailableLocales();
			Set<String> langSet= new HashSet();
			for(Locale l1:locales)
				langSet.add(l1.getDisplayLanguage());
			return langSet;
	 }
	@InitBinder
	public void myInit(ServletRequestDataBinder binder) {
		System.out.println("ShowController.myInitBinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
