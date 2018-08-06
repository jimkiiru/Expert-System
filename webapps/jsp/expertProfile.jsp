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
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Expert System</title>
<!-- Core CSS - Include with every page -->
<link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="assets/plugins/pace/pace-theme-big-counter.css"
	rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/main-style.css" rel="stylesheet" />
<!-- Page-Level CSS -->
<link href="assets/plugins/morris/morris-0.4.3.min.css" rel="stylesheet" />

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
	<!--  wrapper -->
	<div id="wrapper">
		<!-- navbar top -->
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			id="navbar">
			<!-- navbar-header -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<!-- end navbar-header -->
			<!-- navbar-top-links -->
			<ul class="nav navbar-top-links navbar-right">

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user"></i>
						expert<b class="caret"></b>
				</a> <!-- dropdown user-->
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i>User
								Profile</a></li>
						<li class="divider"></li>
						<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>Logout</a>
						</li>
					</ul> <!-- end dropdown-user --></li>
				<!-- end main dropdown -->
			</ul>
			<!-- end navbar-top-links -->

		</nav>
		<!-- end navbar top -->

		<!-- navbar side -->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<!-- sidebar-collapse -->
			<div class="sidebar-collapse">
				<!-- side-menu -->
				<ul class="nav" id="side-menu">
					<li class="selected"><a href="expertDash"><i
							class="fa fa-dashboard fa-fw"></i>Dashboard</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-grain"></i>
							Rice<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="saveRiceDisease">Update Diseases</a></li>
							<li><a href="viewAllRiceDiseases">View Diseases</a></li>
						</ul> <!-- second-level-items --></li>

					<li><a href="#"><i class="fa fa-maxcdn"></i> Maize<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="saveMaizeDisease">Update Diseases</a></li>
							<li><a href="viewAllMaizeDiseases">View Diseases</a></li>
						</ul></li>

					<li><a href="#"><i class="fa fa-pagelines"></i> Potatoes<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="savePotatoDisease">Update Diseases</a></li>
							<li><a href="viewAllPotatoDiseases">View Diseases</a></li>
						</ul></li>

					<li><a href="#"><i class="fa fa-leaf"></i> Soybean<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="saveSoybeanDisease">Update Diseases</a></li>
							<li><a href="viewAllSoybeanDiseases">View Diseases</a></li>
						</ul></li>

					<li><a href="#"><i class="fa fa-align-justify"></i> Other
							Operations<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="saveExpert">Add new Expert</a></li>
							<li><a href="viewAllFarmers">Registered Farmers</a></li>
							<li><a href="viewAllExperts">Registered Experts</a></li>
						</ul></li>
				</ul>
				<!-- end side-menu -->
			</div>
			<!-- end sidebar-collapse -->
		</nav>
		<!-- end navbar side -->
		<!--  page-wrapper -->
		<div id="page-wrapper">
			<div class="row">
				<!-- Page Header -->
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
				</div>
			</div>

			<div class="panel panel-info col-lg-9 col-lg-offset-1">
				<div class="panel-heading">
					<h3 class="panel-title">Profile</h3>
				</div>
				<div class="panel-body">
					<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
						<table class="table table-bordered">
							<c:if test="${empty list}">
								<tr>
									<td colspan="4"><font style="color: red;">No Expert
											has been Registered</font></td>
								</tr>
							</c:if>
							<c:if test="${! empty list}">
								<c:forEach var="exp" items="${list}">
									<tr>
										<td><b>Profile Picture</b></td>
										<td><img src='<c:out value="${exp.profilePic}"></c:out>'
											height="100px" width="100px"> &nbsp&nbsp <!-- <a
											href="updateProfilePic"><button id="login"
													class="btn btn-success" data-toggle="modal">Edit
													Pic</button></a> -->
											<button
												onclick="document.getElementById('id01').style.display='block'"
												style="width: auto;">Edit Pic</button></td>
									</tr>
									<tr>
										<td><b>Surname</b></td>
										<td><c:out value="${exp.surname}"></c:out></td>
									</tr>
									<tr>
										<td><b>FirstName</b></td>
										<td><c:out value="${exp.fname}"></c:out></td>
									</tr>
									<tr>
										<td><b>LastName</b></td>
										<td><c:out value="${exp.lname}"></c:out></td>
									</tr>
									<tr>
										<td><b>EmailAddress</b></td>
										<td><c:out value="${exp.emailaddress}"></c:out></td>
									</tr>
									<tr>
										<td><b>PhoneNumber</b></td>
										<td><c:out value="${exp.phonenum}"></c:out></td>
									</tr>
									<tr>
										<td><b>JobDescription</b></td>
										<td><c:out value="${exp.jobDescription}"></c:out></td>
									</tr>
									<tr>
										<td><b>Department</b></td>
										<td><c:out value="${exp.department}"></c:out></td>
									</tr>
									<tr>
										<td><b>County</b></td>
										<td><c:out value="${exp.county}"></c:out></td>
									</tr>
								</c:forEach>
							</c:if>
						</table>

						<!-- Begin modal -->


						<div id="id01" class="modal">
							<form class="modal-content animate" action="updateProfilePic"
								enctype="multipart/form-data" method="post">
								<div class="imgcontainer">
									<span
										onclick="document.getElementById('id01').style.display='none'"
										class="close" title="Close Modal">&times;</span>
								</div>
								<div class="container">
									<div class="row col-lg-6 col-md-6 col-sm-6">
										<label><b>Profile Pic</b></label> <input type="file"
											path="profilePic" name="fileUpload"
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
		<!-- end page-wrapper -->
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

	<!-- end wrapper -->

	<!-- Core Scripts - Include with every page -->

	<script src="assets/plugins/jquery-1.10.2.js"></script>
	<script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
	<script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
	<!-- <script src="assets/plugins/pace/pace.js"></script> -->
	<script src="assets/scripts/siminta.js"></script>
	<!-- Page-Level Plugin Scripts-->
	<script src="assets/plugins/morris/raphael-2.1.0.min.js"></script>
	<script src="assets/plugins/morris/morris.js"></script>
	<script src="assets/scripts/dashboard-demo.js"></script>
</body>
</html>
<%}%>