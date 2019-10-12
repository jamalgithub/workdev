package com.madhusudhan.j8.domain;

public class Student {

	private String name = null;
	private Teacher teacher = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public boolean hasTeacher() {
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", teacher=" + teacher + "]";
	}

}
