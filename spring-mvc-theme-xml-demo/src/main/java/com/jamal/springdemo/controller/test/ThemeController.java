package com.jamal.springdemo.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/themeDemo")
public class ThemeController {

	@RequestMapping("/home")
	public String index(Model model) {
		return "test/themeViews/themeHome";
	}
}
