package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//HttpSessionBindingListener를 제외한 Listener를 구현한 모든 이벤트 핸들러는
//반드시 애너테이션을 이용해서 Listener로 등록해야 함.
@WebListener
public class LoginImpl2 implements HttpSessionListener{
	
	String user_name;
	String user_pw;
	
	static int tot_user = 0;

    public LoginImpl2() {
    	//※기본생성자가 없을경우 리스너가 제대로 실행되지 않아 컨텍스트 자체가 뻗어버림.
    	//코드에서 LoginImpl2 클래스는 세션 리스너이며, 새 세션이 생성될 때 서블릿 컨테이너는 리플렉션을 
    	//사용하여 LoginImpl2 클래스의 인스턴스를 만들려고 합니다. 
    	//그러나 LoginImpl2에 기본 생성자(인자가 없는 생성자)가 없으면, 서블릿 컨테이너는 해당 클래스의 
    	//인스턴스를 생성할 수 없습니다. 결과적으로 리스너 등록이 실패할 수 있으며, 컨텍스트가 예상대로 
    	//작동하지 않을 수 있으며, 경우에 따라는 오류로 인해 컨텍스트가 비정상 종료될 수 있습니다.
    	
    	//리플렉션 : 실행 도중에 타입(클래스,인터페이스)를 검사하고 구성 멤버를 조사하는 것을 말한다.
    }
	
	public LoginImpl2(String user_name, String user_pw) {
		super();
		this.user_name = user_name;
		this.user_pw = user_pw;
	}


	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		System.out.println("사용자 접속");
		++tot_user;
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		System.out.println("사용자 접속");
		--tot_user;
	}
	
	
}
