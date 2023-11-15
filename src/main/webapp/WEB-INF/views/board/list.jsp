<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resources/etc/color.jsp"%>


<html>
<head>
<title>게시판</title>
<link href="/mvc/resources/css/style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="${bodyback_c}">
<center><b>글목록(전체 글:${count})</b>
<table width="700">
<tr>
    <td align="right" bgcolor="${value_c}">
    	<a href="/mvc/board/writeForm.bo">글쓰기</a>
    </td>
</table>
<c:if test="${count==0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
    <td align="center">
    게시판에 저장된 글이 없습니다.
    </td>
</table>
</c:if>
<c:if test="${count!=0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}"> 
       <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td> 
      <td align="center"  width="100" >IP</td>   
    </tr>
    <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" > ${number}</td>
    <c:set var="number" value="${number-1}"/>
    <td  width="250" >
	<c:set var="wid" value="0"/>
	<c:if test="${article.re_level>0}">
	<c:set var="wid" value="${article.re_level*20}"/>
	</c:if>
	  <img src="/mvc/resources/images/level.gif" width="${wid}" height="16">
	  <img src="/mvc/resources/images/re.gif">
	<c:if test="${article.re_level<=0}">  
	  <img src="/mvc/resources/images/level.gif" width="${wid}" height="16">
     </c:if>      
      <a href="/mvc/board/content.bo?num=${article.num}&pageNum=${currentPage}">
           ${article.subject}</a> 
     <c:if test="${article.readcount>=20}">
         <img src="/mvc/resources/images/hot.gif" border="0"  height="16">
         </c:if>
         </td>
    <td align="center"  width="100"> 
       <a href="mailto:${article.email}">${article.writer}</a></td>
    <td align="center"  width="150"><fmt:formatDate value="${article.reg_date}" type="date"/></td>
    <td align="center"  width="50">${article.readcount}</td>
    <td align="center" width="100" >${article.ip}</td>
  </tr>
  </c:forEach>
</table>
</c:if>
	
		<c:if test="${startPage>10}">
        <a href="/mvc/board/list.bo?pageNum=${startPage-10}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
        <a href="/mvc/board/list.bo?pageNum=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${endPage<pageCount}">
        <a href="/mvc/board/list.bo?pageNum=${startPage+10}">[다음]</a>
		</c:if>

</center>
</body>
</html>