<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- spring의 custom tag를 이용하기 위한 라이브러리 설정
 custom tag: 제공되는 것이 아닌 직접 생성한 태그 -->
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<!-- Controller 가 넘겨준 member라는 Command 객체를 form에 매핑 -->
	<form:form modelAttribute="member">

		<label for="id">아이디</label>
		<form:input path="id" />
		<form:errors path="id"/>
		<br/>
		
		<label for="pw">비밀번호</label>
		<form:password path="pw"/>
		<form:errors path="pw"/>
		<br/>
		
		<label for="name">이름</label>
		<form:input path="name"/><br/>
		
		<label for="nickname">닉네임</label>
		<form:input path="nickname"/>
		<form:errors path="nickname"/>
		<br/>
		
		<label for="mobile">모바일</label>
		<form:input path="mobile"/><br/>
		
		<input type="submit" value="회원가입"/>
		<input type="button" value="메인으로"/>
	</form:form>
	
</body>
</html>