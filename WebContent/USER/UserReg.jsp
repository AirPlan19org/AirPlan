<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>邮箱验证页面</h3>
<form action="" method="get" >
邮&nbsp;&nbsp;&nbsp;箱：<input type="number" name="to" value="${requestScope.to==null? null:requestScope.to }" />@qq.com
<input type="submit" value="获得验证码" />
</form>
<form action="" method="post" >
验证码：<input type="number" name="authno" value="" />
<input type="submit" value="提交" />
<input type="hidden" name="to" value="${requestScope.to==null? null:requestScope.to }" /><br/>
</form>
</body>
</html>