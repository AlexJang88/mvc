package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.mvc.action.SuperAction;

public class InputFormAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "member/inputForm.jsp";
	}

}
