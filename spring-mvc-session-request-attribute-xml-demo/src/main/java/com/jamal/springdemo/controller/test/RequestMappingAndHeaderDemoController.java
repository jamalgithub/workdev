package com.jamal.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/requestMappingAndHeaderDemo")
@Controller
public class RequestMappingAndHeaderDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndHeaderDemoController.class);
		
	/**
	 * test 1: Testing <b>@RequestMapping</b> with <b>Header</b><br>
	 * curl -i -H "key:val" http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndHeaderDemo/test1
	 * @return
	 */
	@RequestMapping(value = "/test1", headers = "key=val", method = RequestMethod.GET)
	@ResponseBody
	public String requestMappingWithHeader() {
		LOGGER.info("Test the request with the header key=val");
	    return "Get some Foos with Header";
	}
	/**
	 * test 2: Testing <b>@RequestMapping</b> with Consumes and Produces<br>
	 * curl -i -H "Accept:application/json" http://localhost:8080/spring-mvc-request-mapping-param-xml-demo/requestMappingAndHeaderDemo/test2
	 * @return
	 */
	@RequestMapping(value = "/test2", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseBody
	public String requestMappingWithProduces() {
		LOGGER.info("Test the request with the header Accept:application/json");
	    return "Get some Foos with Header Old";
	}
	
}
