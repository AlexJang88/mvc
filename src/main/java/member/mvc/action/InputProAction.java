package member.mvc.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.mvc.dao.MemberDAO;
import member.mvc.dto.MemberDTO;
import test.mvc.action.SuperAction;

public class InputProAction implements SuperAction{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		
		MemberDTO member = new MemberDTO();
		member.setBlog(request.getParameter("blog"));
		member.setEmail(request.getParameter("email"));
		member.setId(request.getParameter("id"));
		member.setJumin1(request.getParameter("jumin1"));
		member.setJumin2(request.getParameter("jumin2"));
		member.setName(request.getParameter("name"));
		member.setPasswd(request.getParameter("passwd"));
		member.setReg_date(new Timestamp(System.currentTimeMillis()) );
		MemberDAO manager = MemberDAO.getInstance();
	    
		try {
			manager.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/inputPro.jsp";
	}

}
