package com.jamal.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jamal.springdemo.domain.Address;

@RequestMapping(value = "/redirectAndForwardDemo")
@Controller
public class RedirectAndForwardController {
	private static Logger LOGGER = LoggerFactory.getLogger(RedirectAndForwardController.class);
	
	/**
	 * url : http://localhost:8080/spring-mvc-request-mapping-param-demo/redirectAndForwardDemo<b>/home</b>
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/home")
	public ModelAndView home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test/redirectForwardViews/redirectAndForwardHome");
		mav.addObject("anAddress", new Address());
		
		return mav;
	}
	
	/**
	 * Redirect With the Prefix redirect
	 * @param anAddress
	 * @param model
	 * @return the redirect URL <br>The redirect will respond with a 302 and the new URL in the Location header.<br>The browser will then make another request to the new URL<br>
	 * curl -L --verbose -X POST http://localhost:8080/spring-mvc-form-tags-validation-xml-demo/redirectAndForwardDemo/redirectTest1
	 */
	@RequestMapping(value="/redirectTest1", method=RequestMethod.POST)
	public String redirectTest1(@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		LOGGER.info("INSIDE redirectTest1");
		
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		
		return "redirect:redirectedUrl";		
	}
	
	/**
	 * Redirect With <b>RedirectView</b><br>
	 * @param anAddress
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/redirectTest2", method=RequestMethod.POST)
    public RedirectView redirectTest2 (@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		LOGGER.info("INSIDE redirectTest2");
		
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		
        RedirectView rv = new RedirectView();
        rv.setContextRelative(false);
        rv.setUrl("redirectedUrl");
        return rv;
    }
	
	/**
	 * Redirect With <b>RedirectView</b><br>
	 * curl -i http://localhost:8080/spring-mvc-form-tags-validation-xml-demo/redirectAndForwardDemo/redirectTest3/pathValue/11
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/redirectTest3/{id}")
    public RedirectView redirectTest3 (Model model) {
        model.addAttribute("attr", "attrVal");
        model.addAttribute("testPath", "pathValue");

        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("{testPath}/{id}");
        return rv;
    }
	
	/**
	 * Redirect With <b>RedirectView</b> and <b>RedirectAttributes</b><br>
	 * <b>flash attribute</b> is an attribute that won’t make it into the URL. We can access it using @ModelAttribute(“flashAttribute”) only in the method that is the final target of the redirect<br>
	 * curl -i http://localhost:8080/spring-mvc-form-tags-validation-xml-demo/redirectAndForwardDemo/redirectTest4
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/redirectTest4")
    public RedirectView redirectTest4 (RedirectAttributes attributes) {        
        attributes.addFlashAttribute("flashAttribute", "flash Attribute");
        attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
        
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("redirectedUrl2");
        return rv;
    }
    
	/**
	 * Forward With the Prefix forward
	 * @return the forward URL <br>The forward happens entirely on a server side. <br>The Servlet container forwards the same request to the target URL. <br>The URL won’t change in the browser
	 */
	@RequestMapping(value="/forwardTest1", method=RequestMethod.POST)
	public String forwardTest1(/*@ModelAttribute(value="anAddress") Address anAddress, ModelMap model*/) {
		LOGGER.info("INSIDE forwardTest1");
		
		//model.addAttribute("testdata5A", anAddress.getCity());
		//model.addAttribute("testdata5B", anAddress.getZipCode());
		
		//return "modelAttributeTest";
		return "forward:forwardUrl";
	}
	
	@RequestMapping(value="/redirectedUrl")
	public String redirectTest11(@RequestParam("testdata5A") String testdata5A, @RequestParam("testdata5B") String testdata5B, Model model) {
		LOGGER.info("INSIDE redirectTest11");
		
		model.addAttribute("testdata5A", testdata5A);
		model.addAttribute("testdata5B", testdata5B);
		
		return "test/redirectForwardViews/redirectforwardTest";
	}
	
	@RequestMapping(value="/redirectedUrl2")
	public String redirectTest13(Model model, @ModelAttribute("flashAttribute") Object flashAttribute) {
		LOGGER.info("INSIDE redirectTest13");
		
		model.addAttribute("flashAtt", flashAttribute);
		
		return "test/redirectForwardViews/redirectforwardTest";
	}
	
	@RequestMapping("/redirectTest3/{testPath}/{id}")
    public String redirectTest12 (@PathVariable("testPath") String testPath, @PathVariable("id") String id,
                                 @RequestParam("attr") String attr, Model model) {

        model.addAttribute("testPath", testPath);
        model.addAttribute("id", id);
        model.addAttribute("attr", attr);
        return "test/redirectForwardViews/redirectforwardTest";
    }
	
	@RequestMapping(value="/forwardUrl", method=RequestMethod.POST)
	public String forwardTest11(@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		LOGGER.info("INSIDE forwardTest11");				
		
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		
		return "test/redirectForwardViews/redirectforwardTest";
	}
}
