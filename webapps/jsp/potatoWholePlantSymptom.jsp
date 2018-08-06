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
							<form:form action="potatoWholePlantDiag" method="post"
								commandName="potatoWholePlantSymptom">

								<table class="table table-bordered table-hover">
									<tr>
										<th style="font-size:16px;">Symptoms</th>
										<th style="font-size:16px;">Checkbox</th>
									</tr>
									<tr>
										<td style="font-size: 16px;">Dark lessions on the stem
											and slightly sunken areas.</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="darkLessions" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Leaf spots are round and
											brown.</td>
										<td><input type="checkbox" class="form-control"
											name="roundLeafspot" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Yellow leaves.</td>
										<td><input type="checkbox" class="form-control"
											name="yellowLeaves" value="yes" /></td>
									</tr>

									<tr>
										<td style="font-size: 16px;">Potato tubers have dark,
											sunken spots surrounded by a purplish brown raised border.</td>
										<td><input type="checkbox" class="form-control"
											name="darkTubers" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Rough, corky dry tissue can
											be seen below tuber spots when cut open</td>
										<td><input type="checkbox" class="form-control"
											name="corkyTissue" value="yes" /></td>
									</tr>

									<tr>
										<td style="font-size: 16px;">Shrivelled leaves, stems and
											petioles</td>
										<td><input type="checkbox" class="form-control"
											name="shrivelledLeaves" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Large irregular olive to
											brown leaf spots</td>
										<td><input type="checkbox" class="form-control"
											name="irregularOlive" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Powdery white fungal growth
											can be seen on infected tissue in wet weather</td>
										<td><input type="checkbox" class="form-control"
											name="powderyFungalgrowth" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Irregular sunken, dull brown
											to purple lesions around the eyes on potato tubers</td>
										<td><input type="checkbox" class="form-control"
											name="purpleLesions" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Inside of potato tuber has a
											reddish-brown dry rot</td>
										<td><input type="checkbox" class="form-control"
											name="reddishDryrot" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Stems have elongated
											yellowish-brown dry lesions</td>
										<td><input type="checkbox" class="form-control"
											name="elongatedLesions" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Leaves wilt but remain green</td>
										<td><input type="checkbox" class="form-control"
											name="leavesWilt" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Fluffy white fungal growth
											and small hard black fungal sclerotia can be found on or in
											infected stems</td>
										<td><input type="checkbox" class="form-control"
											name="fluffyFungalgrowth" value="yes" /></td>
									</tr>

									<tr>
										<td style="font-size: 16px;">Irregular patches of gray
											discoloration on surface of the potato tuber</td>
										<td><input type="checkbox" class="form-control"
											name="irregularPatches" value="yes" /></td>
									</tr>

									<tr>
										<td style="font-size: 16px;">Black dots can be seen on
											infected stems and tubers</td>
										<td><input type="checkbox" class="form-control"
											name="blackDots" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Brown to black slimy sunken
											lesions on stems</td>
										<td><input type="checkbox" class="form-control"
											name="slimyLesions" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Plant is stunted</td>
										<td><input type="checkbox" class="form-control"
											name="stuntedPlant" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Tuber flesh is white, soft
											and rotted</td>
										<td><input type="checkbox" class="form-control"
											name="rottedTuberflesh" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Stem has a white to gray
											flaky growth just above the soil line</td>
										<td><input type="checkbox" class="form-control"
											name="grayFlakygrowth" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Underground stems and roots
											have brown, sunken dry spots</td>
										<td><input type="checkbox" class="form-control"
											name="brownDryspots" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Small hard black spots on
											the skin of tubers</td>
										<td><input type="checkbox" class="form-control"
											name="hardBlackspots" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Small and deformed tubers</td>
										<td><input type="checkbox" class="form-control"
											name="deformedTubers" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Small green tubers form on
											the stem above ground</td>
										<td><input type="checkbox" class="form-control"
											name="greenTubers" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Stems may be mottled green
											and yellow</td>
										<td><input type="checkbox" class="form-control"
											name="mottledStems" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Leaves have yellow rings,
											spots and arcs</td>
										<td><input type="checkbox" class="form-control"
											name="yellowRings" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Brown rings and arcs form on
											the skin and in the flesh of tubers</td>
										<td><input type="checkbox" class="form-control"
											name="brownRings" value="yes" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Cracked and malformed potato
											tubers</td>
										<td><input type="checkbox" class="form-control"
											name="crackedTubers" value="yes" /></td>
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