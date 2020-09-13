<%@page import="model.dao.RatingDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<title>jQuery Raty</title>

<link href="<%=request.getContextPath() %>/rating/templates/labs.css" media="screen" rel="stylesheet"
	type="text/css">

<script src="<%=request.getContextPath() %>/rating/templates/jquery.js"></script>
<script src="<%=request.getContextPath() %>/rating/templates/jquery.raty.min.js"></script>

</head>
<body>

	<h1>jQuery Raty</h1>

	<div>A Star Rating Plugin</div>
	<div class="clearfix"></div>
	<h1>Tin thời sự</h1>
	<p>Đây là tin thời sự</p>
	
	<span>Đánh giá tin này</span>
	<div id="click"></div>
	
	<%
		RatingDAO ratingDao = new RatingDAO();
	    float rating = 0;
	    if(request.getAttribute("score")!=null){
	    	rating = (Float) request.getAttribute("score");
	    }
	%>

	<script>
		$.fn.raty.defaults.path = '/ratingdemo/rating/images/';

		$(function() {

			$('#click').raty({
				number: 10,
				click : function(score) {
					if(score==null) score = 0;
					$.ajax({
						url: '<%=request.getContextPath()%>/rating',
						type: 'POST',
						cache: false,
						data: {
							aid: 1,
							ascore: score
						},
						success: function(data){
							alert(data);
						},
						error: function (){
							alert('Có lỗi xảy ra');
						}
					});
					return false;
				},
				cancel: true,
				cancelPlace: 'left',
				half: true,
				start: <%=rating%>,
			});

		});
	</script>
</body>