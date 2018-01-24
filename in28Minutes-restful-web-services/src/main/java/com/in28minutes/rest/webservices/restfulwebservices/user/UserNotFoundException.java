package com.in28minutes.rest.webservices.restfulwebservices.user;

/**
 * Exception thrown from resources when user is not found
 * @author jamal
 *
 */
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
}