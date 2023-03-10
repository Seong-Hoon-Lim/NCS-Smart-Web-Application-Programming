package com.kudangtang.jvx350.mvc.example5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("example5.addCustomerController")
@RequestMapping("/example5/customer")
public class AddCustomerController {	

	@GetMapping
	public String addCustomer(Model model) {
		model.addAttribute("customer", new CustomerCommand());
		return "example5/add_customer";
	}
	
	@PostMapping
	public String addCustomer(@ModelAttribute("customer")
								CustomerCommand customer, Model model) {
		customer.setEmail(customer.getEmail1() + "@" + customer.getEmail2());
		customer.setSsn(customer.getSsn1() + "-" + customer.getSsn2());
		customer.setPhone(customer.getPhone1() + "-" + customer.getPhone2() + "-" + customer.getPhone3());
		model.addAttribute("customer", customer);
		return "example5/success_add_customer";
	}
	
	@ModelAttribute("emailProviderList")
	public List<EmailProvider> getEmailProviderList() {
		List<EmailProvider> list = new ArrayList<>();
		list.add(new EmailProvider("구글", "gmail.com"));
		list.add(new EmailProvider("네이버", "naver.com"));
		list.add(new EmailProvider("다음", "daum.com"));
		list.add(new EmailProvider("MI6", "mi6.gov"));
		
		return list;			
	}		
	
	@ModelAttribute("phoneProviderList")
	public List<String> getPhoneProviderList() {
		List<String> list = new ArrayList<>();
		list.add("010");
		list.add("011");
		list.add("02");
		list.add("053");
		list.add("111");
		list.add("119");
		
		return list;
		
	}	
	
}
