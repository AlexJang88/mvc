<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8");%>

	<c:if test="${check==1}">
	  <meta http-equiv="Refresh" content="0;url=/mvc/board/list.bo?pageNum=${pageNum}" >
	</c:if>
	<c:if test="${check!=1}">
       <script language="JavaScript">           
         alert("비밀번호가 맞지 않습니다");
         history.go(-1);
      </script>
      </c:if>
