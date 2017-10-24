package com.tutorialspoint.log4j;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Log4jExample {
	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(Log4jExample.class);

	public static void main(String[] args)throws IOException,SQLException{
		DOMConfigurator.configure("src/main/resources/log4j.xml");
		//PropertyConfigurator.configure("src/main/resources/log4j.properties");
		
		log.trace("Hello this is an trace message");
		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");
		log.warn("Hello this is an warn message");
		log.fatal("Hello this is an fatal message");
		log.error("Hello this is an error message");
	}

}
