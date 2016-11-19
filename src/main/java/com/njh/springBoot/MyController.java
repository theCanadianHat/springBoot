package com.njh.springBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@RequestMapping("/sup")
	public String sup(@RequestParam(value="name", required=false, defaultValue="bitches")String name,
			Model model){
		model.addAttribute("studentId", "bitches");
		return "student";
	}
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
