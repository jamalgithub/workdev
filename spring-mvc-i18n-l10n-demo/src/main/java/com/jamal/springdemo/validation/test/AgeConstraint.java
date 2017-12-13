package com.jamal.springdemo.validation.test;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * The annotated element must be between the specified boundaries (included). 
 * @author jamal.moubarik
 *
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=AgeConstraintValidator.class)
public @interface AgeConstraint {
	
	/**
	 * message attribute
	 * @return the error message 
	 */
	String message() default "* Age must be between 18 and 60 years";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
	/**
	 * lower attribute
	 * @return the element must be higher or equal to
	 */
	int lower() default 18;
	
	/**
	 * upper attribute
	 * @return the element must be lower or equal to
	 */
	int upper() default 60;
}