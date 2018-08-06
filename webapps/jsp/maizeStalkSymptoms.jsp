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
							<li><a href="farmersProfile?farmerId=${farmerId}"><i class="fa fa-user"></i> Profile</a></li>
							<li class="divider"></li>
							<li><a href="resetpass">Resset Password</a></li>
							<li class="divider"></li>
							<li><a href="logout"><i class="fa fa-power-off"></i> Log
									Out</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>

		<div id="page-wrapper">
			<div class="row">

				<div class="panel panel-info col-lg-9 col-lg-offset-1">
					<div class="panel-heading">
						<h3 class="panel-title">Select the appropriate symptoms</h3>
					</div>
					<div class="panel-body">
						<div
							class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-lg-offset-1">
							<form:form action="maizeStalkDiag" method="post"
								commandName="maizeStalkSymptoms">

								<table class="table table-bordered table-hover">
									<tr>
										<th style="font-size:16px;">Symptoms</th>
										<th style="font-size:16px;">Checkbox</th>
									</tr>
									<tr>
										<td style="font-size: 16px;">Uniform or blotchy, shiny,
											black color on the outer stalk</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="shinyStalk" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Inner stalk may be black</td>
										<td><input type="checkbox" class="form-control"
											name="blackStalk" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Rotted internodes</td>
										<td><input type="checkbox" class="form-control"
											name="rottedInternodes" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Gray or black discoloration
											in the inside the rind</td>
										<td><input type="checkbox" class="form-control"
											name="blackDiscoloration" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Tiny black specks embedded
											in rind of lower stalk</td>
										<td><input type="checkbox" class="form-control"
											name="blackSpecks" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Inner stalk have shredded
											tissue and small, dark specks</td>
										<td><input type="checkbox" class="form-control"
											name="shreddedTissue" value="yes" /></td>
									</tr>

									<tr>
										<td style="font-size: 16px;">Vascular bundles appear
											reddish in color</td>
										<td><input type="checkbox" class="form-control"
											name="vascularBundles" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Small black specks on the
											stalk surface</td>
										<td><input type="checkbox" class="form-control"
											name="stalkSurface" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Infection site appear brown</td>
										<td><input type="checkbox" class="form-control"
											name="infectionSite" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Twisted or distorted stalks</td>
										<td><input type="checkbox" class="form-control"
											name="twistedStalk" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Red or pink discoloration of
											the root system</td>
										<td><input type="checkbox" class="form-control"
											name="pinkRootsystem" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Root mass can be reduced</td>
										<td><input type="checkbox" class="form-control"
											name="rootMass" value="yes" /></td>
									</tr>

									<tr>
										<td colspan="3" align="center"><input
											class="btn btn-info" type="submit" name="" value="Submit">
											&nbsp;&nbsp; <input type="reset" name="" value="Clear"
											class="btn btn-success"></td>
									</tr>

								</table>

							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
<%}%>