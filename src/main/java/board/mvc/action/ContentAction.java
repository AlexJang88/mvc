package board.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.dao.BoardDAO;
import board.mvc.dto.BoardDTO;
import test.mvc.action.SuperAction;

public class ContentAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardDTO article;
		try {
			article = dbPro.getArticle(num);
			int ref=article.getRef();
			int re_step=article.getRe_step();
			int re_level=article.getRe_level();
			request.setAttribute("ref", ref);
			request.setAttribute("re_step", re_step);
			request.setAttribute("re_level", re_level);
			request.setAttribute("article", article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "board/content.jsp";
	}

}
