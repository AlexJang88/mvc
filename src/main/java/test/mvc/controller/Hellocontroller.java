package test.mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.action.MainAction;
import test.mvc.action.SuperAction;
import test.mvc.action.TestAction;

public class Hellocontroller extends HttpServlet{
	
	private Map map = new HashMap<String,SuperAction>();


	@Override
	public void init(ServletConfig config) throws ServletException {
		// init() 주로하는 역할 :  외부정보를 읽는다.
		// 여기선 properties 파일 읽는 작업을 할것임
		String commandURI = config.getInitParameter("commandURI"); //properties 경로
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(commandURI);
			Properties p = new Properties();
			p.load(fis);
			Iterator iter = p.keySet().iterator();
			while(iter.hasNext()) {
				String key=(String)iter.next(); // 첫번째 Key
				String value=p.getProperty(key);
				Class c = Class.forName(value);
				Object obj = c.newInstance();
				map.put(key, obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//웹 상에서 요청받는방식 GET,POST (JSP에서만) / PUT,DELETE(모든곳에서)
		
		
				//URL
				//http://localhost:8080/mvc/board/main/list.do
				
				//URI - ip:port 제외한 나머지 주소
				//   /mvc/board/main/list.do
		String uri=request.getRequestURI();
		
//		action class(MODEL)
//		properties파일 쓰기전에했던 작업
		String view="/WEB-INF/views/";
		SuperAction sa = (SuperAction)map.get(uri);
		view+=sa.action(request, response);
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}
	
	
}
