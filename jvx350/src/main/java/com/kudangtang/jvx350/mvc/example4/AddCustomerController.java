package com.kudangtang.jvx350.mvc.example4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("example4.addCustomerController")
public class AddCustomerController {

	@GetMapping("/example4/customer")
	public String addCustomerForm() {
		
		return "example4/add_customer";
	}
	
	@PostMapping("/example4/customer")
	public String addCustomer(CustomerCommand customerCommand, Model model) {
		model.addAttribute("customer", customerCommand);
		return "example4/success_add_customer";
		
	}
}
