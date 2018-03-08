<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% String path=request.getContextPath()+"/HKProject/"; %>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
			<title>index</title>
			<link href="<%=path %>css/jumbotron.css" rel="stylesheet">
				<link href="<%=path %>css/carousel.css" rel="stylesheet">
					<link rel="stylesheet" href="<%=path %>libs/bootstrap3/css/bootstrap.min.css">
						<script src="<%=path %>libs/jquery-3.3.1.min.js"></script>
						<script src="<%=path %>libs/bootstrap3/js/bootstrap.min.js"></script>
						<style type="text/css">
#navtop {
	width: 60%;
}

#order {
	
}
</style>
${requestScope.notice }