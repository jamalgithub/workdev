package com.jamal.springdemo.controller.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	/** 
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo<b>/requestMappingAndParamDemo/home</b>
	 * @return View name
	 */
	@RequestMapping(value = "/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	/**
	 * test 1: Testing <b>@RequestParam</b> without <b>explicit attributes</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test1?<b>orgname=xxx</b>
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
	 * test 2: Testing <b>@RequestMapping</b> with <b>method</b> attribute<br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test2?orgname=xxx
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
	 * Testing @RequestMapping with multiple HTTP request methods to the same controller method<br>
	 * curl -i -X GET http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test12<br>
	 * curl -i -X PUT http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test12<br>
	 * curl -i -X POST http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test12<br>
	 * 
	 * @return
	 */
	@RequestMapping(value = "/test22", method = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })
	@ResponseBody
	public String requestMappingTest22() {
	    return "Advanced - GET, PUT and POST within single method";
	}

	/**
	 * test 3: Testing <b>@RequestMapping</b> with <b>fall back</b> feature<br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/<b>[ , xxx, test3, test3/xxx]</b>
	 * @return View name
	 */
	@RequestMapping(value = "*", method = RequestMethod.GET)
	// @RequestMapping(value="*", method = {RequestMethod.GET, RequestMethod.POST})
	public String requestMappingAndParamTest3() {
		return "fallback";
	}

	/**
	 * test 4: Testing <b>@RequestParam</b> with <b>defaultValue</b> attribute<br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test4<b>[</b>?orgname=smi<b>]</b>
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
	 * test 5: Testing <b>@RequestParam</b> without <b>'name'</b>or <b>'value'</b> attributes<br>
	 * request param and handler method parameter name must be the same<br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test5?<b>orgname</b>=smi
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
	 * test 6, subtest 1: Testing removal of <b>@RequestMapping</b> ambiguity with the same base <b>URI</b> but with a <b>different parameter</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo<b>/test6</b>?<b>orgname</b>=<b>xxx</b>
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
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo<b>/test6</b>?<b>empcount</b>=<b>xxx</b>
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
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test6/subtest3?<b>orgname</b>=xxxx&<b>empcount</b>=yyy
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
	 * test 6, subtest 4: Testing <b>@RequestMapping</b> with <b>multiple request params</b> and <b>@RequestParam</b> with <b>single param</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test6/subtest4?<b>orgname</b>=xxxx&<b>empcount</b>=yyy
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
	 * test 6, subtest 5: Testing removal of @RequestMapping with <b>multiple request params</b> and <b>@RequestParam</b> with Map<br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo/test6/subtest5?<b>orgname</b>=xxxx&<b>empcount</b>=yyy
	 * @param orgname
	 * @param empcount
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test6/subtest5", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest5(@RequestParam Map<String, String> queryMap, Model model) {		
		model.addAttribute("param", queryMap);
		model.addAttribute("testserial", "test6-subtest5");
		
		return "requestMappingAndParamResults2";
	}
	
	/**
	 * test 7 & 8: Testing <b>@RequestParam</b> with <b>multiple request URI's</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo<b>/test7</b>?orgname=xxxx<br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo<b>/test8</b>?orgname=xxxx
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
	
	/**
	 * test 9: Testing <b>@RequestMapping</b> with <b>Path Variables (Dynamic URI's)</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo<b>/test9</b>/<b>xxx</b>/<b>yyy</b>
	 * @param orgname
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test9/{orgname}/{testserial}", method = RequestMethod.GET)
	public String requestMappingAndParamTest9(@PathVariable(value = "orgname") String orgname, @PathVariable String testserial, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", testserial);
		
		return "requestMappingAndParamResults";
	}
	
	/**
	 * test 10: Testing <b>@RequestMapping</b> with <b>Path Variables (Dynamic URI's)</b> and <b>@RequestParam</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo<b>/test10</b>/<b>xxx</b>?<b>testserial</b>=yyy
	 * @param orgname
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test10/{orgname}", method = RequestMethod.GET)
	public String requestMappingAndParamTest10(@PathVariable(value = "orgname") String orgname, @RequestParam String testserial, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", testserial);
		
		return "requestMappingAndParamResults";
	}
	
	/**
	 * test 11: Testing <b>@RequestMapping</b> with <b>Path Variables (Dynamic URI's)</b> and <b>RegEx</b><br>
	 * http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndParamDemo<b>/test11</b>/<b>xxx</b>/<b>111</b>
	 * @param orgname
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/test11/{orgname}/{testserial:[\\d]+}", method = RequestMethod.GET)
	public String requestMappingAndParamTest11(@PathVariable String orgname, @PathVariable int testserial, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", testserial);
		
		return "requestMappingAndParamResults";
	}	
	
}
