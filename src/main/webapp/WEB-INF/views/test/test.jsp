<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>
	/WEB-INF/views/test/test/jsp
</h2>
<h3>${id}님 환영합니다.</h3>
<h3><%=request.getAttribute("result")%></h3>
<h3><%=request.getAttribute("result2")%></h3>

<h3>표현언어(EL) => ${result}</h3> 
<h3>${result2}</h3>
<hr />
<%--
	표현언어 특징
	 	- NULL : 빈공백으로 출력한다.
	 	- 문자를 표현할때 "" , '' 모두 사용가능
	 	- 대입 개념이 없다.    ex) ${ 10==10 } ${ 10 eq 10 } 
	 	- 리턴타입이 void 인 메서드는 호출할수없다.  ex) ${dto.setId('aa')}
	 	- ${list.size()} ${arr.length} 출력가능 (void 가 아니라서) 하지만 action에서 처리를해서 값만 전달해주는게 훨씬 좋다
	 	- 
	 	

--%>

