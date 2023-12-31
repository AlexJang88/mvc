package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.mvc.dao.MemberDAO;
import test.mvc.action.SuperAction;

public class LoginProAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");
		
		MemberDAO manager = MemberDAO.getInstance();
		try {
			int check= manager.userCheck(id,passwd);
			request.setAttribute("check", check);
			request.setAttribute("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/loginPro.jsp";
	}

}
