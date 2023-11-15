package test.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		//request.setCharacterEncoding("UTF-8");
		String msg=request.getParameter("msg");
		msg+="_MVC";
		request.setAttribute("result", msg);
		request.setAttribute("result2", "Hello World");
		//application.setAttribute - 어디서든 사용가능
		//sesssion.setAttribute - 해당브라우저에서 사용가능
		//request.setAttribute - 전달한 페이지에서만 사용가능
		
		return "test/test.jsp";
	}
	
}
