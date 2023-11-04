package com.spring.ex01;

public class PersonServiceImpl implements PersonService {

	private String name;
	private String sung;

	private int age;

	
	public PersonServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PersonServiceImpl(String name, String sung, int age) {
		this.name = name;
		this.sung = sung;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSung(String Sung) {
		this.sung = Sung;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void sayHello() {
		System.out.println(name);
		System.out.println(sung + " " + name + " 하잉");
		System.out.println("나이는 " + age);
		System.out.println("=======");
	}

}
