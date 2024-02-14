package oop8;

import java.util.ArrayList;

public class Person 
{
	String name, phone, email, gender, hometown, job;
	ArrayList<String> hobbies = new ArrayList<String>();
	
	@Override
	public String toString() {
		return name + ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", hometown="
				+ hometown + ", job=" + job + ", hobbies=" + hobbies;
	} 
	
	
}