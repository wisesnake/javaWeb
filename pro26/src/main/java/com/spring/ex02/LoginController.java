package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "loginController")
@RequestMapping(value = "/test")
public class LoginController {
	
	@RequestMapping(value = "/loginForm.do")
	ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
//	@RequestMapping(value = "/login.do")
//	ModelAndView login(String userID,@RequestParam("userName") String userName,
//			HttpServletRequest request, HttpServletResponse response) {
//		//위의 ID 매개변수를 보면, name 매개변수처럼 애너테이션으로 Param임을 지정해주지 않았어도 
//		//매개변수의 변수명이 전단계의 view에서 리퀘스트로 보내온 parameter와 같으면 알아서 찾아냄.
//		System.out.println("전달받은거 : "+ userID+" | "+userName);
//		ModelAndView mav = new ModelAndView();
////		String userID =  request.getParameter("userID");
////		String userName =  request.getParameter("userName");
//		//리퀘스트 매개변수를 사용하면 쓸 필요 없음.
//		mav.addObject("userID", userID);
//		mav.addObject("userName", userName);
//		mav.setViewName("result");
//		return mav;
//	}
	
	
	
//	//required 이용
//	@RequestMapping(value = "/login.do")
//	ModelAndView login(String userID,@RequestParam(value = "userName",required = true) String userName,
//			HttpServletRequest request, HttpServletResponse response) {
//		//name 의 name 매개변수의 애너테이션의 프로퍼티 required 를 true로 잡으면, 해당 요청에
//		//파라미터에 userName이 반드시 포함되어있어야 호출 가능, 없으면 예외발생함.
//		System.out.println("전달받은거 : "+ userID+" | "+userName);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userID", userID);
//		mav.addObject("userName", userName);
//		mav.setViewName("result");
//		return mav;
//	}
//	//map 이용
//	@RequestMapping(value = "/login.do")
//	ModelAndView login(@RequestParam Map<String,String> info,
//			HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("info",info);
//		//이미 키밸류형태의 파라미터로 넘어왔으므로, 매개변수를 그저 Map참조 변수로 선언하여 해당 변수만
//		//mav에 추가해주기만 하면 알아서 담겨서 view로 날라감.
//		mav.setViewName("result");
//		return mav;
//	}
	
//	//VO 이용
//	@RequestMapping(value = "/login.do")
//	ModelAndView login(@ModelAttribute("info") LoginVO loginVO,
//			HttpServletRequest request, HttpServletResponse response) {
//		//@ModelAttribute의 경우, 뒤에 온 클래스의 참조객체를 생성, 그리고 해당 객체의 속성과
//		//파라미터가 같은 것을 알아서 찾아가서 속성 초기화를 함, 그리고 애너테이션 속성값에 바인드함.
//		//따라서 vo 에 해당하는 필드 2개가 view에서 전달해온 파라미터와 변수명이 같기때문에 알아서
//		//vo객체의 속성이 초기화되었고, 해당 vo객체는 info 라는 key에 바인드되어 mav와 함께 넘어간거임.
//		//따라서 jsp에서 info.userID 와 같이 해당 vo객체의 필드에 바로 접근이 가능한거임.
//		ModelAndView mav = new ModelAndView();
//		System.out.println("vo_id : "+loginVO.getUserID()+"\nvo_name : "+loginVO.getUserName());
//		mav.setViewName("result");
//		return mav;
//	}
//	
	//Model 이용.
	@RequestMapping(value = "/login.do")
	String login(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("userID",request.getParameter("userID"));
		model.addAttribute("userName",request.getParameter("userName"));
		//메소드 호출 시  model객체가 생성되며, addAttr~ 메소드를 사용하여 전달할 데이터를
		//키밸류로 바인딩 가능, 이후 해당 메소드로 포워딩되는 view 페이지에 전달됨.
		//Model 객체를 사용하여 메소드에서 추가한 데이터는 해당 메소드가 반환하는 뷰 페이지에만 전달됩니다.
		//즉, 이 데이터는 해당 요청에 대한 응답으로 사용되는 뷰 페이지에만 지역적으로 사용됩니다.
		return "result";
	}
	
	
}
