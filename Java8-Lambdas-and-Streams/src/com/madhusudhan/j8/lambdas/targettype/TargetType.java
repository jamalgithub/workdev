package com.madhusudhan.j8.lambdas.targettype;

public class TargetType {
	
	public interface Email{
		public String constructEmail(String name);
	}
	
	public String getEmail(String name, Email email) {
		return email.constructEmail(name);
	}

	public static void main(String[] args) {
		Email email = s -> s+"@hotmail.com";
		//Email email = (s) -> {return s+"@hotmail.com";};
		//Email email = (String s) -> {return s+"@hotmail.com";};
		//System.out.println(email.constructEmail("adil"));
		
		System.out.println(new TargetType().getEmail("jamal", (String s) -> s+"@gmail.com"));
		System.out.println(new TargetType().getEmail("Said", email));
	}

}
