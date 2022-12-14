package com.nt.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ILocaleMgmtService;

@Controller("controller")
public class LocaleOperationsConstroller {
	@Autowired
	private ILocaleMgmtService service;

	@RequestMapping("/welcome")
	public String showHomePage() {
		// return LVN
		return "home";
	}

	@RequestMapping("/list_countries")
	public String fetchCountries(Map<String, Object> map) {
		System.out.println("model attributes shared memory obj is::" + map.getClass());
		// use service
		List<String> countriesList = service.fetchAllCountries();
		map.put("countriesInfo", countriesList);
		map.put("sysDate", LocalDate.now());
		// return LVN
		return "result";
	}

	@RequestMapping("/about_us") /// default mode is GET
	public String showAboutUsPage() {
		return "about_us";
	}

	@RequestMapping("/contact")
	public String showContactUsPage() {
		// return LVN
		return "contact_us";
	}

}
