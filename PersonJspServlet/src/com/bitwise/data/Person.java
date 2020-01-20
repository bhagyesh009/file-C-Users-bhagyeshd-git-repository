package com.bitwise.data;

public class Person {
	private String name="";
	private String mobno="";
	int id=(Integer) null;
	
	

	
	public int getId() {
		return id;
	}

	public Person(String name, String mobno, int id) {
		super();
		this.name = name;
		this.mobno = mobno;
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person(String name, String mobno) {
		super();
		this.name = name;
		this.mobno = mobno;
	}

	public String getName() {
		return name;
	}

	public String getMobno() {
		return mobno;
	}

	public void setName(String name) {
		this.name = name;
		
		

	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
		
		
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mobno=" + mobno + ", id=" + id + "]";
	}
}
