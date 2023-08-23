package com.zensar.controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.client.RestTemplate;
//
//import com.zensar.service.ApiService;
//
//import java.util.List;
//
//@Controller
//public class UIController {
//
//    private final ApiService apiService;
//
//    @Autowired
//    public UIController(ApiService apiService) {
//        this.apiService = apiService;
//    }
//
//    @GetMapping("/")
//    public String showUI(Model model) {
//        List<String> staticDropdownValues = List.of("sanity", "regression", "currency", "easyhelp", "market", "LVC", "free games");
//        model.addAttribute("staticDropdownValues", staticDropdownValues);
//
//        List<String> dynamicDropdownValues = apiService.fetchDeviceDropdownValues();
//        model.addAttribute("dynamicDropdownValues", dynamicDropdownValues);
//
//        return "ui";
//    }
//}
//
//

//UIController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zensar.service.ApiService;

@Controller
public class UIController {

	private final ApiService apiService;

	@Autowired
	public UIController(ApiService apiService) {
		this.apiService = apiService;
	}

	@GetMapping("/tor")
	public String showUI(Model model) {
		List<String> staticDropdownValues = List.of("sanity", "regression", "currency", "easyhelp", "market", "LVC",
				"free games");
		model.addAttribute("staticDropdownValues", staticDropdownValues);

		List<String> dynamicDropdownValues = apiService.fetchDeviceDropdownValues();
		model.addAttribute("dynamicDropdownValues", dynamicDropdownValues);

		return "ui";

	}

	@GetMapping("/welcome")
	public String greet() {

		return "ui";
	}
}
