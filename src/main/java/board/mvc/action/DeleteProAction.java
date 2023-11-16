package board.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.dao.BoardDAO;
import test.mvc.action.SuperAction;

public class DeleteProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		  String pageNum = request.getParameter("pageNum");
		  String passwd = request.getParameter("passwd");
		  request.setAttribute("pageNum", pageNum);
		  BoardDAO dbPro = BoardDAO.getInstance();
		  try {
			int check = dbPro.deleteArticle(num, passwd);
			request.setAttribute("check", check);
		  } catch (Exception e) {
			e.printStackTrace();
		}
		  return "board/deletePro.jsp";
	}

}
