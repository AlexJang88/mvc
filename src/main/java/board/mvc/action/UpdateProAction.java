package board.mvc.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.dao.BoardDAO;
import board.mvc.dto.BoardDTO;
import test.mvc.action.SuperAction;

public class UpdateProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String pageNum = request.getParameter("pageNum");
		request.setAttribute("pageNum", pageNum);
		BoardDTO article = new BoardDTO();
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPasswd(request.getParameter("passwd"));
		article.setContent(request.getParameter("content"));
		article.setNum(Integer.parseInt(request.getParameter("num")));
		BoardDAO dbPro = BoardDAO.getInstance();
	    try {
			int check = dbPro.updateArticle(article);
			request.setAttribute("check", check);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/updatePro.jsp";
	}

}
