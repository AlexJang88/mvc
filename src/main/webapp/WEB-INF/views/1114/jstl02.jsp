<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
money : <fmt:formatNumber value="${money}"/><br />
money : <fmt:formatNumber value="${money}" type="currency" currencySymbol="\\" /><br />
money : <fmt:formatNumber value="${money}" type="currency" currencySymbol="\$" /><br />
pi : <fmt:formatNumber value="${pi}" type="percent" /><br />
pi : <fmt:formatNumber value="${pi}" pattern=".0000000" /><br />
pi : <fmt:formatNumber value="${pi}" pattern=".0" /><br />

day : <fmt:formatDate value="${day}"/><br />
day : <fmt:formatDate value="${day}" type="date" /><br />
day : <fmt:formatDate value="${day}" type="time" /><br />
day : <fmt:formatDate value="${day}" type="both" /><br />

day : <fmt:formatDate value="${day}" type="date" dateStyle="full"/><br />
day : <fmt:formatDate value="${day}" type="date" dateStyle="long"/><br />
day : <fmt:formatDate value="${day}" type="date" dateStyle="medium"/><br />
day : <fmt:formatDate value="${day}" type="date" dateStyle="short"/><br />
day : <fmt:formatDate value="${day}" type="date" dateStyle="default"/><br />

day : <fmt:formatDate value="${day}" type="time" timeStyle="full"/><br />
day : <fmt:formatDate value="${day}" type="time" timeStyle="long"/><br />
day : <fmt:formatDate value="${day}" type="time" timeStyle="medium"/><br />
day : <fmt:formatDate value="${day}" type="time" timeStyle="short"/><br />
day : <fmt:formatDate value="${day}" type="time" timeStyle="default"/><br />

