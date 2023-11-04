package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
//얘가 기존에 action-servlet.xml설정 파일에서 /test/*.do 역할 하던놈.
public class MainController {
   @RequestMapping(value="/main1.do")
   //얘가 기존에 action-servlet에서 메소드리졸버 핸들러 역할 했던놈.
   
   //즉, 밑의 main1 메소드는 요청을 pro26/test/main1.do 로 요청하면 호출됨.
   public ModelAndView main1(HttpServletRequest request, HttpServletResponse response)  throws Exception{
      ModelAndView mav=new ModelAndView();
      mav.addObject("msg","main1");
      mav.setViewName("main");
      return mav;
   }
   //마찬가지로 밑의 main2 메소드는 요청을 pro26/test/main2.do 로 요청하면 호출.
   @RequestMapping(value="/main2.do" ,method = RequestMethod.GET)
   public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception{
      ModelAndView mav=new ModelAndView();
      mav.addObject("msg","main2");
      mav.setViewName("main");
      return mav;
   }
}
