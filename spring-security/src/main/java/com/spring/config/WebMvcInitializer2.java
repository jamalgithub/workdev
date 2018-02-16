package com.spring.config;

import com.spring.security.WebSecurityConfig;

public class WebMvcInitializer2 {

   //@Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { WebSecurityConfig.class };
   }

   //@Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebMvcConfig.class };
   }

   //@Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}
