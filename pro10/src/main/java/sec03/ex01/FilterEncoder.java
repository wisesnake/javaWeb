package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//필터는 리소스(서블릿또는 정적 컨텐츠)에 대한 요청이나 리소스의 응답, 또는 둘 다에 대해 필터링 작업을 수행하는 클래스
@WebFilter("/*")
public class FilterEncoder implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("인코딩 필터 작동");
		request.setCharacterEncoding("utf-8");
		
//		long begin = System.currentTimeMillis();
//		long begin = System.nanoTime();
		chain.doFilter(request, response);
//		long end = System.currentTimeMillis();
//		long end = System.nanoTime();
//		System.out.println("작업 시간: " + (end - begin) + "ns");
	}

}
