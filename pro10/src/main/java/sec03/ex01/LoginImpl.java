package sec03.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//객체가 세션에 바인딩되거나 해제될 때 객체에 알림이 표시되도록 함.

public class LoginImpl implements HttpSessionBindingListener{
	
	String user_name;
	String user_pw;
	
	public static int tot_user = 0;

	
	
	public LoginImpl(String user_name, String user_pw) {
		super();
		this.user_name = user_name;
		this.user_pw = user_pw;
	}


	//이 유형의 이벤트는 세션에서 바인딩되거나 바인딩 해제될 때, http~bindinglistner를
	//구현하는 객체로 전송되거나 속성이 바인딩되거나 해제되거나 고쳐질 때 배포 설명자에 구성된
	//http~attr~lisnter를 통해 실행됨.
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSessionBindingListener.super.valueBound(event);
		
		System.out.println("사용자 접속");
		++tot_user;
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSessionBindingListener.super.valueUnbound(event);
		
		System.out.println("사용자 접속 해제");
		--tot_user;
	}
	
}
