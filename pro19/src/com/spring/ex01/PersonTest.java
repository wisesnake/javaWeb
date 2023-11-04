package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
//- 기본적인 의존성 주입을 지원하는 가장 간단한 형태의 컨테이너
import org.springframework.beans.factory.xml.XmlBeanFactory;
//- XmlBeanFactory : Resource 객체를 사용해 컨텍스트 정의 파일을 로딩하는 단순한 BeanFactory
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		// 기존 객체 생성 클래스 접근 방식
//		PersonServiceImpl personService = new PersonServiceImpl();
//		personService.setName("hong");
//		personService.sayHello();

		// 스프링방식(DI,IoC,AOP),
		// -DI-
		// 의존성 주입은 어딘가에서 객체를 가져와서 (이 경우 "person.xml" 구성에서) 객체에 설정하는 것을 의미합니다.
		// 이 작업을 수행하려면 구성 파일에 객체와 해당 종속성을 정의해야 합니다.

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
//		1. XML파일에 기술되어 있는 정의를 바탕으로 Bean을 생성시켜 SpringFramework를 초기화 시킴
//		2. XMLBeanFactory의 생성자에 XML파일을 로딩시켜주는 Resource타입의 객체를 넘겨줌
//		3. Resource의 생성자에 이용하고자 하는 Spring 설정파일의 위치를 알려줌
		PersonService person = (PersonService) factory.getBean("personService");
		// id 가 "personService"인 객체를 가져옴. 즉, person.xml 에서 beans > bean 안에 id 를
		// personService로 생성해두었던
		// name 프로퍼티를 "홍길동"으로 갖고있는 객체를 가져와서, sayhello 메소드를 사용하고 name필드를 갖고있는 객체로 사용하기 위해
		// personService 인터페이스 참조형 변수에 캐스팅하여 객체를 대입, 그리고 밑에서처럼 sayHello()메서드를 실행하면
		// PersonServiceImpl에서 구현했던것처럼 이름을 콘솔에 찍는 결과가 나오게 됨.
		person.sayHello();
		
		PersonService person2 = (PersonService) factory.getBean("personService2");
		person2.sayHello();
	}

}
