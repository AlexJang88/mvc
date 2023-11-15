package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.mvc.dao.MemberDAO;
import test.mvc.action.SuperAction;

public class DeleteProAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String passwd  = request.getParameter("passwd");
		MemberDAO manager = MemberDAO.getInstance();
		try {
			int check = manager.deleteMember(id,passwd);
			request.setAttribute("check", check);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/deletePro.jsp";
	}

}
