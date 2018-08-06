<%
	if ((session.getAttribute("logid") == null)
			|| (session.getAttribute("logid") == "")) {
%>
<script>
 alert("You must be logged in to access this page");
 window.location.href="loginC";
</script>
<%}else{ %>
<%@include file="taglib_includes.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Expert System</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/local.css" />

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<!-- you need to include the shieldui css and js assets in order for the charts to work -->
<link rel="stylesheet" type="text/css"
	href="http://www.shieldui.com/shared/components/latest/css/shieldui-all.min.css" />
<link rel="stylesheet" type="text/css"
	href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
<script type="text/javascript"
	src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript"
	src="http://www.prepbootstrap.com/Content/js/gridData.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<script>
	$(document).ready(
			function() {
				setInterval(function() {
					var randomnumber = Math.floor(Math.random() * 100);
					$('#show').text(
							'I am getting refreshed every 3 seconds..! Random Number ==> '
									+ randomnumber);
				}, 3000);
			});
</script>

<style>
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
	padding-left: 150px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 55%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>

</head>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="farmersdashboard">Farmer Dashboard</a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="farmersdashboard"><i
							class="fa fa-bullseye"></i> Dashboard</a></li>
					<li><a href="partsaffected"><i class="fa fa-grains"></i>
							Rice</a></li>
					<li><a href="maizepartsaffected"><i class="fa fa-maxcdn"></i>
							Maize</a></li>
					<li><a href="potatopartsaffected"><i
							class="fa fa-pagelines"></i> Potatoes</a></li>
					<li><a href="soybeanpartsaffected"><i class="fa fa-leaf"></i>
							Soybean</a></li>
					<li><a href="savePhoto"><i class="fa fa-picture-o"></i>
							Upload Photo</a></li>
					<li><a href="viewExpertsF">
							View Experts</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right navbar-user">
					<li class="dropdown user-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-user"></i> farmer<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
							<li class="divider"></li>
							<li><a href="logout"><i class="fa fa-power-off"></i> Log
									Out</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>

		<div id="page-wrapper">

			<div class="panel panel-info col-lg-9 col-lg-offset-1">
				<div class="panel-heading">
					<h3 class="panel-title">Profile</h3>
				</div>
				<div class="panel-body">
					<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
						<table class="table table-bordered">
							<c:if test="${empty list}">
								<tr>
									<td colspan="4"><font style="color: red;">No
											records found</font></td>
								</tr>
							</c:if>
							<c:if test="${! empty list}">
								<c:forEach var="far" items="${list}">
									<tr>
										<td><b>Profile Picture</b></td>
										<td><img src='<c:out value="${far.profilePic}"></c:out>'
											height="100px" width="100px"> &nbsp&nbsp <!-- <a
											href="updateFarProfilePic"><button id="login"
													class="btn btn-success" data-toggle="modal">Edit
													Pic</button></a> -->
											<button
												onclick="document.getElementById('id01').style.display='block'"
												style="width: auto;">Edit Pic</button></td>
									</tr>
									<tr>
										<td><b>Surname</b></td>
										<td><c:out value="${far.surname}"></c:out></td>
									</tr>
									<tr>
										<td><b>FirstName</b></td>
										<td><c:out value="${far.fname}"></c:out></td>
									</tr>
									<tr>
										<td><b>LastName</b></td>
										<td><c:out value="${far.lname}"></c:out></td>
									</tr>
									<tr>
										<td><b>EmailAddress</b></td>
										<td><c:out value="${far.emailaddress}"></c:out></td>
									</tr>
									<tr>
										<td><b>PhoneNumber</b></td>
										<td><c:out value="${far.phonenum}"></c:out></td>
									</tr>
									<tr>
										<td><b>Occupation</b></td>
										<td><c:out value="${far.occupation}"></c:out></td>
									</tr>
									<tr>
										<td><b>County</b></td>
										<td><c:out value="${far.county}"></c:out></td>
									</tr>
									<tr>
										<td><b>NationalId</b></td>
										<td><c:out value="${far.nationalId}"></c:out></td>
									</tr>

								</c:forEach>
							</c:if>
						</table>

						<!-- Begin modal -->


						<div id="id01" class="modal">

							<form class="modal-content animate" action="updateFarProfilePic"
								enctype="multipart/form-data" method="post">
								
								<div class="imgcontainer">
									<span
										onclick="document.getElementById('id01').style.display='none'"
										class="close" title="Close Modal">&times;</span> 
								</div>

								<div class="container">
									<div class="row col-lg-6 col-md-6 col-sm-6">
										<label><b>Profile Pic</b></label> <input type="file"
											path="profilePic" name="fileUpload" id="fileChooser"
											class="form-control btn-info" required>
										<button type="submit">Upload</button>
										<button type="button"
											onclick="document.getElementById('id01').style.display='none'"
											class="cancelbtn">Cancel</button>
									</div>
								</div>

							</form>
						</div>
						<!-- End modal -->

					</div>
				</div>
			</div>

		</div>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>
<%}%>