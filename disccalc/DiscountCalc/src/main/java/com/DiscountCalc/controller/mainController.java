package com.DiscountCalc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DiscountCalc.entity.Customer;

@Controller
public class mainController {
		
	@RequestMapping("/home")
	public String home() {
		
		return"home";
	}
	
	@RequestMapping(value = "/calculate",method = RequestMethod.POST)
	public String regular( @ModelAttribute Customer customer,Model model,HttpSession session) {
		System.out.println("customer***"+customer);
		int amt = customer.getAmount();
	
		String type = customer.getType();
		
		if (type.equals("Premium")) {
			int[] arr = checkPremium(amt);
			model.addAttribute("mrp",amt);
			model.addAttribute("dicount_rs", arr[0]);
			model.addAttribute("dicount_percentage", arr[2]);
			model.addAttribute("finalamt", arr[1]);
			model.addAttribute("message", "true");
			System.out.println("premium****");
			return"home";
	
		}
		
		else {
			
			int[] arr = checkRegular(amt);
			model.addAttribute("mrp",amt);
			model.addAttribute("dicount_rs", arr[0]);
			model.addAttribute("dicount_percentage", arr[2]);
			model.addAttribute("finalamt", arr[1]);
			model.addAttribute("message", "true");
			System.out.println(amt);
			System.out.println("regular****");
			return"home";
		}
		
		
		
	}

	private int[] checkRegular(int amt) {
		
		int ans[] = new int[3];
		if (amt<5000) {
			ans[0]= amt;
			ans[1]= amt;
			ans[2] = 0;
		}
		if (amt>=5000 && amt<=10000) {
			ans[0]= amt*10/100;
			ans[1] = amt-ans[0];
			ans[2] = 10;
			
		}
		if (amt>=10000) {
			ans[0]= amt*20/100;
			ans[1] = amt-ans[0];
			ans[2] = 20;
		}
		
		return ans;
	}
	
	private int[] checkPremium(int amt) {
		
		int ans[] = new int[3];
		
		if (amt<4000) {
			ans[0]= amt*10/100;
			ans[1] = amt-ans[0];
			ans[2] = 10;
		}
		
		if (amt>=4000 && amt<8000) {
			ans[0] = amt*15/100;
			ans[1] = amt-ans[0];
			ans[2] = 15;
		}
		
		if (amt>=8000 && amt<12000) {
			ans[0] = amt*20/100;
			ans[1] = amt-ans[0];
			ans[2] = 20;
		}
		
		if (amt>=12000 ) {
			ans[0]= amt*30/100;
			ans[1] = amt-ans[0];
			ans[2] = 30;
		}
		
		return ans;
	}
	
	
}
