package board.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.action.SuperAction;

public class WriteFormAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		int num=0,ref=1,re_step=0,re_level=0;
		    if(request.getParameter("num")!=null){
				num=Integer.parseInt(request.getParameter("num"));
				ref=Integer.parseInt(request.getParameter("ref"));
				re_step=Integer.parseInt(request.getParameter("re_step"));
				re_level=Integer.parseInt(request.getParameter("re_level"));
			}
		  request.setAttribute("num", num); 
		  request.setAttribute("ref", ref); 
		  request.setAttribute("re_step", re_step); 
		  request.setAttribute("re_level", re_level); 
		return "board/writeForm.jsp";
	}

}
