<!DOCTYPE html>
<head>

<title>jQuery Raty</title>

<link href="templates/labs.css" media="screen" rel="stylesheet"
	type="text/css">

<script src="templates/jquery.js"></script>
<script src="templates/jquery.raty.js"></script>

</head>
<body>

	<h1>jQuery Raty</h1>

	<div>A Star Rating Plugin</div>
	<div class="clearfix"></div>
	<h1>Click</h1>

	<div id="click"></div>

	<script>

		$(function() {

			$('#click').raty({
				number: 10,
				click : function(score) {
					alert("score: " + score);
				},
				path:"images",
				//start: 2, tại sao không được
			});

		});
	</script>
</body>