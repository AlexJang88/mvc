package board.mvc.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.dao.BoardDAO;
import board.mvc.dto.BoardDTO;
import test.mvc.action.SuperAction;

public class WriteProAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BoardDTO article = new BoardDTO();
		article.setReg_date(new Timestamp(System.currentTimeMillis()) );
		article.setIp(request.getRemoteAddr());
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPasswd(request.getParameter("passwd"));
		article.setContent(request.getParameter("content"));
		BoardDAO dbPro = BoardDAO.getInstance();
	    try {
			dbPro.insertArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "board/writePro.jsp";
	}

}
