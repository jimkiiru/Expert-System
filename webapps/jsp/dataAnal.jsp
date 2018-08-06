<%@include file="taglib_includes.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img1/favicon.png">

<title>Cancer Registry</title>

<!-- Bootstrap CSS -->
<link href="css1/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="css1/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="css1/elegant-icons-style.css" rel="stylesheet" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- full calendar css-->
<link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css"
	rel="stylesheet" />
<link href="assets/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" />
<!-- easy pie chart-->
<link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- owl carousel -->
<link rel="stylesheet" href="css1/owl.carousel.css" type="text/css">
<link href="css1/jquery-jvectormap-1.2.2.css" rel="stylesheet">
<!-- Custom styles -->
<link rel="stylesheet" href="css1/fullcalendar.css">
<link href="css1/widgets.css" rel="stylesheet">
<link href="css1/style.css" rel="stylesheet">
<link href="css1/style-responsive.css" rel="stylesheet" />
<link href="css1/xcharts.min.css" rel=" stylesheet">
<link href="css1/jquery-ui-1.10.4.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->
</head>

<body>
	<!-- container section start -->
	<section id="container" class="">


		<header class="header dark-bg">
			<div class="toggle-nav">
				<div class="icon-reorder tooltips"
					data-original-title="Toggle Navigation" data-placement="bottom">
					<i class="fa fa-align-justify"></i>
				</div>
			</div>

			<!--logo start-->
			<a href="#" class="logo">Registrar</a>
			<!--logo end-->


			<div class="top-nav notification-row">
				<!-- notificatoin dropdown start-->
				<ul class="nav pull-right top-menu">

					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <span class="profile-ava">
								<img alt="" src="img1/user.jpg">
						</span> <span class="username" style="color: #fff;">Gilbert</span> <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<div class="log-arrow-up"></div>
							<li class="eborder-top"><a href="#"><i
									class="fa fa-user"></i> My Profile</a></li>
							<li><a href="logout"><i class="fa fa-sign-out"></i> Log
									Out</a></li>
						</ul></li>
					<!-- user login dropdown end -->
				</ul>
				<!-- notificatoin dropdown end-->
			</div>
		</header>
		<!--header end-->

		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu">

					<li class="sub-menu active"><a href="savePatient" class="">
							<span>Add Patient</span>
					</a></li>
					<li class="sub-menu"><a href=viewAllPatients class=""> <span>View/Edit
								Patient</span>
					</a></li>
					
					<li><a class="" href="viewAllTumours"> <span>View/Edit
								Tumour</span>
					</a></li>

					<li class="sub-menu"><a href="saveHospital" class=""> <span>Add
								Hospital</span>
					</a></li>
					<li><a class="" href="viewAllHospitals"> <span>View/Edit
								Hospital</span>
					</a></li>

					<li class="sub-menu"><a href="datanal" class=""> <span>Data
								analysis</span>
					</a></li>

				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!--overview start-->
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">
							<i class="fa fa-laptop"></i> Dashboard
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="#">Home</a></li>
							<li>Add tumour</li>
						</ol>
					</div>
				</div>

				<div class="container ">

					<div class="panel panel-info">
						<div class="panel-heading">
							<span class="lead col-lg-offset-4">Select County</span>
						</div>

						<form:form action="datanal" method="post" commandName="dataAnal">
							<table class="table borderless">
								<tr>
									<td>
										<div class="form-group col-md-12">
											<div class="col-md-7">
												<label for="Age">County<font style="color: red">*</font></label>
												<select name="county">
													<option value="nyeri">Nyeri</option>
													<option value="nairobi">Nairobi</option>
													<option value="kiambu">Kiambu</option>
												</select>
											</div>
										</div>
									</td>									
								</tr>
								<tr>									
									<td>
										<div class="form-group col-md-12">
											<div class="col-md-7">
												<label for="Address">Morphology<font
													style="color: red">*</font></label> <select name="morphology">
													<option value="bladder cancer">Bladder cancer</option>
													<option value="lung cancer">Lung cancer</option>
													<option value="brain cancer">Brain cancer</option>
													<option value="melanoma">Melanoma</option>
													<option value="breast cancer">Breast cancer</option>
													<option value="non-hodgkin lymphoma">Non-Hodgkin lymphoma</option>
													<option value="cervical cancer">Cervical cancer</option>
													<option value="ovarian cancer">Ovarian cancer</option>
												</select>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="form-group col-md-12">
											<div class="col-md-7">
												<label for="Year">Year<font style="color: red">*</font></label>
												<input name="year" placeholder="Enter Year" />
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="3" align="center"><input class="btn btn-info"
										type="submit" name="" value="Submit"> 
									</td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
			</section>
		</section>
		<!--main content end-->
	</section>
	<!-- container section start -->

	<!-- javascripts -->
	<script src="js1/jquery.js"></script>
	<script src="js1/jquery-ui-1.10.4.min.js"></script>
	<script src="js1/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- bootstrap -->
	<script src="js1/bootstrap.min.js"></script>
	<!-- nice scroll -->
	<script src="js1/jquery.scrollTo.min.js"></script>
	<script src="js1/jquery.nicescroll.js" type="text/javascript"></script>
	<!-- charts scripts -->
	<script src="assets/jquery-knob/js/jquery.knob.js"></script>
	<script src="js1/jquery.sparkline.js" type="text/javascript"></script>

	<script src="js1/owl.carousel.js"></script>
	<!-- jQuery full calendar -->

	<!-- Full Google Calendar - Calendar -->

	<script src="js1/jquery.rateit.min.js"></script>
	<!-- custom select -->
	<script src="js1/jquery.customSelect.min.js"></script>


	<!--custome script for all page-->
	<script src="js1/scripts.js"></script>
	<!-- custom script for this page-->

	<script src="js1/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="js1/jquery-jvectormap-world-mill-en.js"></script>

	<script src="js1/jquery.autosize.min.js"></script>
	<script src="js1/jquery.placeholder.min.js"></script>
	<script src="js1/gdp-data.js"></script>
	<script src="js1/morris.min.js"></script>
	<script src="js1/sparklines.js"></script>

	<script src="js1/jquery.slimscroll.min.js"></script>

	<script src="js/admin.js"></script>
	<script src="js/analyst.js"></script>
	<script src="js/branchsupervisor.js"></script>
	<script src="js/hospital.js"></script>
	<script src="js/minorsupervisor.js"></script>
	<script src="js/patient.js"></script>
	<script src="js/registra.js"></script>
	<script src="js/supervisor.js"></script>
	<script src="js/tumour.js"></script>

</body>
</html>
