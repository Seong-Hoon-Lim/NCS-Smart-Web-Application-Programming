package com.kudangtang.jvx350.mvc.example5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("example5.addAccountController")
public class AddAccountController {
	
	@GetMapping("/example5/account")
	public String addAccountForm(AccountCommand account) {
		return "example5/add_account";
	}
	
	@PostMapping("/example5/account")
	public String addAccount(AccountCommand account, Model model) {
		System.out.println(account.getBalance());
		System.out.println(account.getAccountType());
		System.out.println(account.getCustomer().getName());
		
		model.addAttribute("account", account);
		
		return "example5/success_add_account";
	}
	
	
	@ModelAttribute("accountTypeList")
	public List<AccountType> getAccountTypeList() {
		List<AccountType> list = new ArrayList<>();
		list.add(new AccountType("SA", "SavingsAccount"));
		list.add(new AccountType("CA", "CheckingAccount"));
		
		return list;
	}

}
