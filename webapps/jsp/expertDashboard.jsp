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
<%!int count;%>
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
						<li><a href="exProfile?expertId=${expertId}"><i
								class="fa fa-user fa-fw"></i>User Profile</a></li>
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

			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
				<%
					count = 0;
				%>
				<table class="table table-bordered">
					<tr bgcolor="#04B173">
						<th>Id</th>
						<th>Photo</th>
						<th>Date</th>
						<th>Response</th>
						<th>Reply</th>
						<th>Delete</th>
					</tr>
					<c:if test="${empty photoList}">
						<tr>
							<td colspan="4"><font style="color: red;">No Photos
									Found</font></td>
						</tr>
					</c:if>
					<c:if test="${! empty photoList}">
						<c:forEach var="photo" items="${photoList}">
							<tr>
								<td><%=++count%></td>
								<td><img id="myImg"
									src='<c:out value="${photo.photoname}"></c:out>' height="50px"
									width="50px"></td>
								<td><c:out value="${photo.date}"></c:out></td>
								<td>${photo.reply}</td>
								<td><a href="sendResponse?photoId=${photo.photoId}">Reply</a></td>
								<td><a class="btn btn-danger"
												href="javascript:deletePhoto('deletePhoto?photoId=${photo.photoId}');"><span
													class="fa fa-trash-o"></span></a></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>

		</div>
		<!-- end page-wrapper -->
	</div>
	<!-- end wrapper -->

	
	<!-- Core Scripts - Include with every page -->
	<script src="js/photo.js"></script>
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