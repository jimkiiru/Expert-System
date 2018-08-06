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
							<form:form action="riceLeafDiag" method="post"
								commandName="riceLeafSymptoms">

								<table class="table table-bordered table-hover responsive">
									<tr>
										<th style="font-size:16px;">Symptoms</th>
										<th style="font-size:16px;">Checkbox</th>
									</tr>
									<tr>
										<td style="font-size: 16px;">Small specks originate on
											leaves</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="specks" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Several spots coalesce ->
											big irregular patches</td>
										<td><input type="checkbox" class="form-control"
											name="spots" value="yes" /></td>

									</tr>
									<tr>
										<td style="font-size: 16px;">Seedling wilt or kresek</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="wilt" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Water-soaked to yellowish
											stripes on leaf blades</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="yellowishStripes" /></td>
									<tr>
										<td style="font-size: 16px;">Appearance of bacterial ooze
											that looks like a milky or opaque dewdrop on young lesions
											early in the morning</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="bacterialOoze" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Lessions turn yellow to
											white as the disease advances</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="yellowLessions" /></td>
									</tr>
									<tr>
										<td style="font-size: 16px;">Discoloration in the flag
											leaf sheath</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="leafSheathDiscoloration" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Irregular spots or lesions,
											with dark reddish brown margins and gray center</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="irregularSpots" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Lesions enlarge and often
											coalesce and may cover the entire leaf sheath</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="lesionsEnlarge" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Unemerged panicles rot and
											florets turn red-brown to dark brown</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="unemergedPaniclesrot" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Whitish powdery growth
											inside the affected sheaths and young panicles</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="whitishPowdery" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Infected panicles sterile,
											shrivelled, or with partially filled grain.</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="infectedPaniclesSterile" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Initially, small,
											dark-green, water-soaked translucent streaks on veins from
											tillering to booting stage</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="translucentStreaks" /></td>
									</tr>
									<tr>

										<td style="font-size: 16px;">Lesions turn brown and
											bacteria ooze out under humid weather</td>
										<td><input type="checkbox" class="form-control"
											value="yes" name="brownLesions" /></td>
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