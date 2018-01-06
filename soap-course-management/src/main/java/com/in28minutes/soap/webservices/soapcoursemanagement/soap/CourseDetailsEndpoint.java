package com.in28minutes.soap.webservices.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.DeleteCourseDetailsRequest;
import com.in28minutes.courses.DeleteCourseDetailsResponse;
import com.in28minutes.courses.GetAllCourseDetailsRequest;
import com.in28minutes.courses.GetAllCourseDetailsResponse;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.exception.CourseNotFoundException;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService.Status;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsService service;
	
	// method
	// input - GetCourseDetailsRequest
	// output - GetCourseDetailsResponse

	// http://in28minutes.com/courses
	// GetCourseDetailsRequest
	/**
	 * this methode handle all request (in xml format) with the namespace = "http://in28minutes.com/courses" and the name = "GetCourseDetailsRequest"<br>
	 * The endpoint use xsd to map(convert) from xml to java (methode input : GetCourseDetailsRequest) and vice verca (methode output : GetCourseDetailsResponse)<br>
	 * @param request GetCourseDetailsRequest
	 * @return GetCourseDetailsResponse
	 */
	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		Course course = service.findById(request.getId());
		if (course == null)
			throw new CourseNotFoundException("Invalid Course Id " + request.getId());
		return mapCourseDetails(course);
	}
	
	/**
	 * this methode handle all request (in xml format) with the namespace = "http://in28minutes.com/courses" and the name = "GetllCourseDetailsRequest"<br>
	 * The endpoint use xsd to map(convert) from xml to java (methode input : GetllCourseDetailsRequest) and vice verca (methode output : GetAllCourseDetailsResponse)<br>
	 * @param request GetAllCourseDetailsRequest
	 * @return GetAllCourseDetailsResponse
	 */
	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		
		List<Course> courses = service.findAll();
		
		return mapAllCourseDetails(courses);
	}

	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse processDeleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {
		
		Status status = service.deleteById(request.getId());
		
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(mapStatus(status));
		
		return response;
	}
	
	private com.in28minutes.courses.Status mapStatus(Status status) {
		if(status == Status.FAILURE)
			return com.in28minutes.courses.Status.FAILURE;
		return com.in28minutes.courses.Status.SUCCESS;
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		response.setCourseDetails(mapCourse(course));
		
		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		
		for(Course course:courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		
		return response;
	}

	/**
	 * map Course to CourseDetails
	 * @param course
	 * @return
	 */
	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}
	
}