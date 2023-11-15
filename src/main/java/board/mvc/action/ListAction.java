package board.mvc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.dao.BoardDAO;
import test.mvc.action.SuperAction;

public class ListAction implements SuperAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) {
	        pageNum = "1";
	    }

	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1;
	    int endRow = currentPage * pageSize;
	    int count = 0;
	    int number=0;
	    request.setAttribute("currentPage", currentPage);
	    List articleList = null;
	    BoardDAO dbPro = BoardDAO.getInstance();
	    
	    try {
			count = dbPro.getArticleCount();
			request.setAttribute("count", count);
			if (count > 0) {
		        articleList = dbPro.getArticles(startRow, endRow);
		    }
			number=count-(currentPage-1)*pageSize;
			request.setAttribute("number", number);
			request.setAttribute("articleList", articleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    if(count>0) {
	    int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
        int startPage = (int)(currentPage/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) {
        	endPage = pageCount;
        }
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("startPage", startPage);
        request.setAttribute("pageBlock", pageBlock);
        request.setAttribute("endPage", endPage);
	    }
        
		return "board/list.jsp";
	}

}
