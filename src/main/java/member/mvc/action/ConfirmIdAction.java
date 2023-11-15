package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.mvc.dao.MemberDAO;
import test.mvc.action.SuperAction;

public class ConfirmIdAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println(id);
		MemberDAO manager = MemberDAO.getInstance();
		try {
			int check= manager.confirmId(id);
			request.setAttribute("check", check);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		
		return "member/confirmId.jsp";
	}

}
