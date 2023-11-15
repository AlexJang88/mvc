package board.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.dao.BoardDAO;
import board.mvc.dto.BoardDTO;
import test.mvc.action.SuperAction;

public class UpdateFormAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		 String pageNum = request.getParameter("pageNum");
		 BoardDAO dbPro = BoardDAO.getInstance();
		 request.setAttribute("pageNum", pageNum);
		 request.setAttribute("num", num);
		  try {
			BoardDTO article =  dbPro.updateGetArticle(num);
			request.setAttribute("article", article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/updateForm.jsp";
	}

}
