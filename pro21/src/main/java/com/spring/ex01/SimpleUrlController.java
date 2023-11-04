package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//웹 MVC 프레임워크에서 Model 및 View를 보유하는 홀더입니다. 
//이들은 완전히 다릅니다. 이 클래스는 컨트롤러가 단일 반환 값으로 모델 및 뷰를 반환할 수 있도록 하는 데 사용됩니다.
//핸들러에 의해 반환된 모델과 뷰를 나타내며, DispatcherServlet에 의해 해결되어야 합니다. 
//뷰는 ViewResolver 개체에 의해 해결되어야 할 문자열 뷰 이름의 형식을 취할 수 있으며, 
//대안으로 View 개체를 직접 지정할 수도 있습니다. 모델은 이름별로 키가 지정된 여러 객체의 사용을 허용하는 Map입니다.
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mv = new ModelAndView("index2.jsp");
		System.out.println(mv);
		return mv;
	}
}
