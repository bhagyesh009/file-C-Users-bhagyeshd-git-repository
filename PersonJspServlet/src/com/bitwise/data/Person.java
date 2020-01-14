package com.bitwise.data;

public class Person {
	private String name;
	private String mobno;
	
	
	public Person(String name, String mobno) {
		super();
		this.name = name;
		this.mobno = mobno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", mobno=" + mobno + "]";
	}
}
