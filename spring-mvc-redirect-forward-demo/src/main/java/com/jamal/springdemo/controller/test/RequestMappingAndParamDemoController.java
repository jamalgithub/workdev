package com.jamal.springdemo.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	/** 
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo<b>/home</b>
	 * @return View name
	 */
	@RequestMapping(value = "/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	/**
	 * test 1: Testing @RequestParam without <b>explicit attributes</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo/test1?<b>orgname=xxx</b>
	 * @param orgName
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		
		return "requestMappingAndParamResults";
	}

	/**
	 * test 2: Testing @RequestMapping <b>'method' attribute</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo/test2?orgname=smi
	 * @param orgName
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		
		return "requestMappingAndParamResults";
	}

	/**
	 * test 3: Testing @RequestMapping fall back feature<br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo<b>/xxx</b>
	 * @return View name
	 */
	@RequestMapping(value = "*", method = RequestMethod.GET)
	// @RequestMapping(value="*", method = {RequestMethod.GET, RequestMethod.POST})
	public String requestMappingAndParamTest3() {
		return "fallback";
	}

	/**
	 * test 4: Testing @RequestParam <b>'defaultValue' attribute</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo/test4<b>[</b>?orgname=smi<b>]</b>
	 * @param orgName
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(@RequestParam(value = "orgname", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		
		return "requestMappingAndParamResults";
	}

	/**
	 * test 5: Testing @RequestParam <b>without 'name'or 'value' attributes</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo/test5?orgname=smi
	 * @param orgname
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");
		
		return "requestMappingAndParamResults";
	}

	/**
	 * test 6, subtest 1: Testing removal of @RequestMapping ambiguity with <b>the same base URI</b> but with a <b>different parameter</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo<b>/test6</b>?<b>orgname</b>=xxxx
	 * @param orgname
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test6", params = "orgname")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		
		return "requestMappingAndParamResults2";
	}

	/**
	 * test 6, subtest 2: Testing removal of @RequestMapping ambiguity with <b>the same base URI</b> but with a <b>different parameter</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo<b>/test6</b>?<b>empcount</b>=xxxx
	 * @param empcount
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test6", params = "empcount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		
		return "requestMappingAndParamResults2";
	}
	
	/**
	 * test 6, subtest 3: Testing removal of @RequestMapping with <b>multiple request params</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo/test6/subtest3?<b>orgname</b>=xxxx&<b>empcount</b>=yyy
	 * @param orgname
	 * @param empcount
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest3(@RequestParam String orgname, @RequestParam String empcount, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empCount", empcount);
		model.addAttribute("testserial", "test6-subtest3");
		
		return "requestMappingAndParamResults2";
	}
	
	/**
	 * test 6, subtest 4: Testing with <b>multiple request params</b> and @RequestParam with <b>single param</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo/test6/subtest4?<b>orgname</b>=xxxx&<b>empcount</b>=yyy
	 * @param orgname
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest4");
		
		return "requestMappingAndParamResults2";
	}
	
	/**
	 * test 7 & 8: Testing @RequestParam with <b>multiple request URI's</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo<b>/test7</b>?orgname=xxxx
	 * http://localhost:8080/spring-mvc-request-mapping-param-demo/requestMappingAndParamDemo<b>/test7</b>?orgname=xxxx
	 * @param orgname
	 * @param model
	 * @param request
	 * @return View name
	 */
	@RequestMapping(value = {"/test7", "/test8"}, method = RequestMethod.GET)
	public String requestMappingAndParamTest7and8(@RequestParam String orgname, Model model, HttpServletRequest request) {
		model.addAttribute("orgname", orgname);
		
		LOGGER.info(request.getRequestURL().toString());
		
		if(request.getRequestURL().toString().contains("test7")) {
			model.addAttribute("testserial", "test7");
		} else {
			model.addAttribute("testserial", "test8");
		}
		
		return "requestMappingAndParamResults2";
	}

}
