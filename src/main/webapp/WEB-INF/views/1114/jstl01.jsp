<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<h2>
	JSTL
</h2>

<c:set var="id" value="test" />
<h3>set변수 => ${id}</h3>

<c:remove var="id"/>
<h3>remove 이후 set변수 => ${id}</h3>

<c:set var="country" value="korea"/>
<c:if test="${country!=null}">
	<h3>국가명 : ${country}</h3>
</c:if>
<c:if test="${name!=null && name=='hong'}">
	<h3>이름 : ${name} ${10+'10'}</h3>
</c:if>


<c:set var="count" value="55"/>
<c:choose>
	<c:when test="${count>=100}">100이상</c:when>
	<c:when test="${count>=50 }">100미만 50이상</c:when>
	<c:when test="${count>=0 }">50미만 0이상</c:when>
	<c:otherwise>0미만</c:otherwise>
</c:choose>
<br />
<c:forEach var="i" begin="1" end="10" step="1">
	${i}
</c:forEach>
<br />
<c:forEach var="a" items="${arr}">
	${a}
</c:forEach>
<br />
${d1.num} = ${d1.name}
<br />
${d2.num} = ${d2.name}
${d2.getName()}
<br />
<br />
<c:forEach var="d" items="${al}">
	${d.num} = ${d.name} <br />
</c:forEach>

<c:import url="http://localhost:8080/mvc/main.do" var="aa"/>
${aa}
${aa}
${aa}
<br>
<c:forTokens var="i" items="aa,bb,cc,dd,ee" delims=",">
	${i}
</c:forTokens>



