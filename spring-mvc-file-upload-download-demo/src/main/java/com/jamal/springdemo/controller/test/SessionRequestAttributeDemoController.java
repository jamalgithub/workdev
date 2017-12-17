package com.jamal.springdemo.controller.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jamal.springdemo.domain.test.Visitor;
import com.jamal.springdemo.domain.test.VisitorCount;
import com.jamal.springdemo.domain.test.VisitorData;
import com.jamal.springdemo.service.VisitorService;

@Controller
@SessionAttributes(names={"visitordata","visitorcount"})
@RequestMapping("/visitorRegister")
public class SessionRequestAttributeDemoController {
	
	@Autowired
	public VisitorService visitorService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(SessionRequestAttributeDemoController.class);
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("test/sessionRequestAttributeViews/sessionRequestAttributeHome", "visitorstats", new VisitorData());
	}

	@ModelAttribute("visitordata")
	public VisitorData addVisitorData() {
		List<Visitor> visitors = new ArrayList<Visitor>();
		VisitorData vData = new VisitorData(null, null, visitors);
		return vData;
	}
	
	@ModelAttribute("visitorcount")
	public VisitorCount countVisitors() {
		return new VisitorCount(0);
	}
	
	/**
	 * Before invoking any handler methods annotated with @RequestMapping, Spring calls all @ModelAttribute methods.<br>
	 * All return values of @ModelAttribute methods are populated in the Model object.<br>
	 * Spring then moves to next step and prepares to call the target handler method (the one which matches the request). On finding @ModelAttribute in the target handler method parameters, Spring tries to find the named object in the Model map.
	 * On finding the matching named object, Spring populates the handler parameter with its value and calls the handler.<br>
	 * Also, if there's <b>@SessionAttributes</b> annotation on the controller class, then Spring first checks whether the named value for the handler's @ModelAttribute parameter exists in the HttpSession, if yes, then it will be used rather than invoking the related method with @ModelAttribute.<br>
	 * If there's no match found then Spring attempts to instantiate the object using it's default constructor, then assign to the parameter and call the handler.<br><br>
	 * In our case Spring create an instance of VisitorData then assign to the parameter currentVisitor
	 * @param currentVisitor
	 * @param session
	 * @param sessionStatus
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/visitor", method=RequestMethod.POST)
	public String getVisitors(@ModelAttribute("visitor") VisitorData currentVisitor,
								HttpSession session,
								SessionStatus sessionStatus,
								HttpServletRequest request,
								@SessionAttribute(name="sessionStartTime") LocalDateTime startTime,
								@RequestAttribute(name="currentTime") LocalDateTime clockTime,
								Model model) {
		
		VisitorData visitorDataFromSession = (VisitorData) session.getAttribute("visitordata");
		visitorService.registerVisitor(visitorDataFromSession, currentVisitor);
		VisitorCount visitorCount = (VisitorCount) session.getAttribute("visitorcount");
		visitorService.updateCount(visitorCount);
		
		Long currentSessionDuration = visitorService.computeDuration(startTime);
		
		if(visitorCount.getCount() == 5) {
			sessionStatus.setComplete();
//			session.invalidate();
		}
		
//		model.addAttribute("timeHeading", visitorService.describeCurrentTime(clockTime));
//		model.addAttribute("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));
		
		Map<String, Object> modelMap = model.asMap();
		modelMap.put("timeHeading", visitorService.describeCurrentTime(clockTime));
		modelMap.put("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));
		
		// debug code
		LOGGER.info(visitorDataFromSession.toString());
		
		/*if(request.getMethod().equalsIgnoreCase("POST")) {
			LOGGER.info("This is a POST request");
		} else {
			LOGGER.info("This is a GET request");
		}*/
		
		return "test/sessionRequestAttributeViews/sessionRequestAttributeResult";
	}
}