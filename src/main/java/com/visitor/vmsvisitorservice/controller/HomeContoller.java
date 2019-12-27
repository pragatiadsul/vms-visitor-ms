package com.visitor.vmsvisitorservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
	
	/**
	 * Loads the index page
	 * @return
	 */
	@GetMapping(value="/")
	public String homepage()
	{
		return "index";
	}

}
