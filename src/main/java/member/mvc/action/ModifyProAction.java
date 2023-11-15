package member.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.mvc.dao.MemberDAO;
import member.mvc.dto.MemberDTO;
import test.mvc.action.SuperAction;

public class ModifyProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		MemberDTO dto = new MemberDTO();
		dto.setBlog(request.getParameter("blog"));
		dto.setEmail(request.getParameter("email"));
		dto.setId(id);
		dto.setName(request.getParameter("name"));
		dto.setPasswd(request.getParameter("passwd"));
		MemberDAO manager = MemberDAO.getInstance();
		try {
			manager.updateMember(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/modifyPro.jsp";
	}

}
